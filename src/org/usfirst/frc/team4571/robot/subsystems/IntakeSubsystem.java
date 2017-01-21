package org.usfirst.frc.team4571.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team4571.robot.RobotConstants;
import org.usfirst.frc.team4571.robot.subsystems.PID.DistanceOutput;
import org.usfirst.frc.team4571.robot.subsystems.sensors.EncoderAverage;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	private CANTalon rightMotor;
	private boolean isRollerIn;
	public static final DoubleSolenoid ROLLER_SOLENOID = new DoubleSolenoid(RobotConstants.ROLLER_FOWARD_SOLENOID_CHANNEL, RobotConstants.ROLLER_REVERSE_SOLENOID_CHANNEL);

	public IntakeSubsystem(){
		this.rightMotor = new CANTalon(RobotConstants.RIGHT_MOTOR_CHANNEL);

	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}

	public void initialize() {
		out(0);
	}
	public void out(double speed){
		ROLLER_SOLENOID.set(DoubleSolenoid.Value.kForward);
		this.rightMotor.set(speed);
		isRollerIn = false;
	}
	 public void reverse(double speed){
		ROLLER_SOLENOID.set(DoubleSolenoid.Value.kReverse);
        this.rightMotor.set(speed);
        isRollerIn = true;
    }
	public Value getRollerSolenoidValue(){
		return ROLLER_SOLENOID.get();
	}
	public void foward(double speed){
		this.rightMotor.set(speed);
	}
	public void stop() {
		this.rightMotor.set(0);
    }
	public boolean getRollerIn(){
		return this.isRollerIn;
	}
}
