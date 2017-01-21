package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;
import org.usfirst.frc.team4571.robot.subsystems.PID.DistanceOutput;
import org.usfirst.frc.team4571.robot.subsystems.sensors.EncoderAverage;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {

	private RobotDrive robotDrive;
	private CANTalon frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;

	private Encoder leftEncoder, rightEncoder;
	private double encoderKp, encoderKi, encoderKd;

	private final EncoderAverage encoderAverage;
	private final DistanceOutput distanceOutput;
	private final PIDController distanceController;

	public TankDriveSubsystem() {
		this.frontLeftMotor = new CANTalon(RobotConstants.FRONT_LEFT_MOTOR_CHANNEL);
		this.frontRightMotor = new CANTalon(RobotConstants.FRONT_RIGHT_MOTOR_CHANNEL);
		this.rearLeftMotor = new CANTalon(RobotConstants.REAR_LEFT_MOTOR_CHANNEL);
		this.rearRightMotor = new CANTalon(RobotConstants.REAR_RIGHT_MOTOR_CHANNEL);

//		this.frontRightMotor.setInverted(true);
//		this.rearRightMotor.setInverted(true);

		this.robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

		this.leftEncoder = new Encoder(RobotConstants.LEFT_ENCODER_CHANNEL_A,
				RobotConstants.LEFT_ENCODER_CHANNEL_B, false, EncodingType.k4X);
		this.rightEncoder = new Encoder(RobotConstants.RIGHT_ENCODER_CHANNEL_A,
				RobotConstants.RIGHT_ENCODER_CHANNEL_B, true, EncodingType.k4X);
		this.leftEncoder.setDistancePerPulse(RobotConstants.DISTANCE_PER_PULSE);
		this.rightEncoder.setDistancePerPulse(RobotConstants.DISTANCE_PER_PULSE);

		this.encoderAverage = new EncoderAverage(leftEncoder, rightEncoder);
		this.encoderAverage.setPIDSourceType(PIDSourceType.kDisplacement);
		this.distanceOutput = new DistanceOutput(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		this.distanceController = new PIDController(encoderKp, encoderKi, encoderKd, encoderAverage, distanceOutput);
		this.distanceController.setPercentTolerance(5.0); //TODO: find how much to put for percent
		this.distanceController.setContinuous(false);
		this.distanceController.setOutputRange(-1.0, 1.0);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}

	public void initialize() {
		this.leftEncoder.reset();
		this.rightEncoder.reset();
	}

//	public double getLeftEncoderDistance() {
//		return Math.abs(this.leftEncoder.getDistance());
//	}
//
//	public double getRightEncoderDistance() {
//		return Math.abs(this.rightEncoder.getDistance());
//	}
//
//	public double getDistance() {
//		double left = getLeftEncoderDistance();
//		double right = getRightEncoderDistance();
//		return Math.max(left, right);
//	}

	public boolean isDriveStraightFinished() {
		return this.distanceController.onTarget();
	}

	public double getDisplacement() {
		return this.encoderAverage.pidGet();
	}

	public void driveStraightForGivenDistance(double setPoint) {
		distanceController.reset();
		distanceController.setInputRange(0, setPoint);
		distanceController.setOutputRange(-1.0, 1.0);
		distanceController.enable();
	}
	
	public void drive(double distanceInFeet) {
		driveStraightForGivenDistance(distanceInFeet);
		while(!isDriveStraightFinished()) {
			this.robotDrive.arcadeDrive(distanceController.get(), 0.0);
		}
	}

	public void drive(double leftValue, double rightValue, boolean squaredInputs) {
		this.robotDrive.tankDrive(leftValue, rightValue, squaredInputs);
	}

	public void stop() {
		robotDrive.drive(0,0);
	}
}
