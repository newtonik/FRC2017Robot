package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	private CANTalon intakeMotor;
	private DoubleSolenoid rollerSolenoid;
	private boolean isRollerIn;
	private Compressor compressor;
	private Encoder encoder;

	public IntakeSubsystem(){
		this.intakeMotor = new CANTalon(RobotConstants.MOTOR_CHANNEL);
		this.rollerSolenoid = new DoubleSolenoid(RobotConstants.ROLLER_FOWARD_SOLENOID_CHANNEL, RobotConstants.ROLLER_REVERSE_SOLENOID_CHANNEL);
		this.compressor = new Compressor(0);
		compressor.setClosedLoopControl(true);
		this.encoder = new Encoder(RobotConstants.ENCODER_CHANNEL_A,
				RobotConstants.ENCODER_CHANNEL_B, false,EncodingType.k4X);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
	public void initialize() {
		out();
	}
	public void out(){
		this.rollerSolenoid.set(DoubleSolenoid.Value.kForward);
		isRollerIn = false;
	}
	public void in(){
		this.rollerSolenoid.set(DoubleSolenoid.Value.kReverse);
		isRollerIn = true;
	}
	public Value getRollerSolenoidValue(){
		return rollerSolenoid.get();
	}
	public void setSpeed(double speed){
		this.intakeMotor.set(speed);
	}
	public void stopRoller(double speed) {
		this.intakeMotor.set(0);
	}
	public boolean isSolenoidIn(){
		return this.isRollerIn;
	}
}
