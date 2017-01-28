package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;
import org.usfirst.frc.team4571.robot.subsystems.PID.AngleOutput;
import org.usfirst.frc.team4571.robot.subsystems.PID.DistanceOutput;
import org.usfirst.frc.team4571.robot.subsystems.sensors.EncoderAverage;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {

	private RobotDrive robotDrive;
	private CANTalon frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;

	private Encoder leftEncoder, rightEncoder;
	
	private static final double encoderKp = 0.05;
	private static final double encoderKi = 10.0;
	private static final double encoderKd = 8.0;

	private final EncoderAverage encoderAverage;
	private final DistanceOutput distanceOutput;
	private final PIDController distanceController;
	
	private static final double navKp = 0.05;
	private static final double navKi = 5.0;
	private static final double navKd = 7.0;
	
	private final AHRS navX;
	private final AngleOutput angleOutput;
	private final PIDController turnController;

	public TankDriveSubsystem() {
		this.frontLeftMotor = new CANTalon(RobotConstants.FRONT_LEFT_MOTOR_CHANNEL);
		this.frontRightMotor = new CANTalon(RobotConstants.FRONT_RIGHT_MOTOR_CHANNEL);
		this.rearLeftMotor = new CANTalon(RobotConstants.REAR_LEFT_MOTOR_CHANNEL);
		this.rearRightMotor = new CANTalon(RobotConstants.REAR_RIGHT_MOTOR_CHANNEL);

//		this.frontRightMotor.setInverted(true);
//		this.rearRightMotor.setInverted(true);

		this.robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

		this.leftEncoder = new Encoder(RobotConstants.LEFT_ENCODER_CHANNEL_A,
				RobotConstants.LEFT_ENCODER_CHANNEL_B, true, EncodingType.k4X);
		this.rightEncoder = new Encoder(RobotConstants.RIGHT_ENCODER_CHANNEL_A,
				RobotConstants.RIGHT_ENCODER_CHANNEL_B, false, EncodingType.k4X);
		this.leftEncoder.setDistancePerPulse(RobotConstants.DISTANCE_PER_PULSE);
		this.rightEncoder.setDistancePerPulse(RobotConstants.DISTANCE_PER_PULSE);

		this.encoderAverage = new EncoderAverage(leftEncoder, rightEncoder);
		this.encoderAverage.setPIDSourceType(PIDSourceType.kDisplacement);
		this.distanceOutput = new DistanceOutput(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		this.distanceController = new PIDController(encoderKp, encoderKi, encoderKd, encoderAverage, distanceOutput);
		
		this.navX = new AHRS(SPI.Port.kMXP);
		this.navX.setPIDSourceType(PIDSourceType.kRate);
		this.angleOutput = new AngleOutput(robotDrive, distanceController);
		this.turnController = new PIDController(navKp, navKi, navKd, navX, angleOutput); 
	}
	
	public void initDefaultCommand() {}

	public void initialize() {
		this.encoderAverage.reset();
		this.navX.reset();
	}
	
	public double getLeftEncoderDistance() {
		return this.leftEncoder.getDistance();
	}

	public double getRightEncoderDistance() {
		return this.rightEncoder.getDistance();
	}

	public double getDistance() {
		return encoderAverage.pidGet();
	}
	
	public double getNavXAngle(){
		return this.navX.getAngle();
	}

	public boolean isDistanceFinished() {
		return distanceController.onTarget();
	}
	
	public boolean isBothFinished() {
		return distanceController.onTarget() && turnController.onTarget();
	}
	
	public boolean isAngleFinished() {
		return turnController.onTarget();
	}

	public void setBothPIDParameters(double distanceSetPoint, double angleSetPoint) {
		distanceController.reset();
		turnController.reset();

		distanceController.setOutputRange(-0.6, 0.6);
		distanceController.setSetpoint(distanceSetPoint);
		distanceController.setAbsoluteTolerance(0.1 * distanceSetPoint);
		turnController.setOutputRange(-0.6, 0.6);
		turnController.setSetpoint(angleSetPoint);
		turnController.setAbsoluteTolerance(2.0f);
		
		distanceController.enable();
		turnController.enable();
	}
	
	public void setAnglePIDParameter(double angleSetPoint) {
		turnController.reset();
		
		turnController.setOutputRange(-0.6, 0.6);
		turnController.setSetpoint(angleSetPoint);
		turnController.setAbsoluteTolerance(2.0f);

		turnController.enable();
	}
	
	// Teleop drive
	public void drive(double leftValue, double rightValue, boolean squaredInputs) {
		this.robotDrive.tankDrive(leftValue, rightValue, squaredInputs);
	}

	public void stop() {
		robotDrive.drive(0,0);
	}
	
	public PIDController getDistanceController() {
		return this.distanceController;
	}
	
	public PIDController getTurnController() {
		return this.turnController;
	}
}