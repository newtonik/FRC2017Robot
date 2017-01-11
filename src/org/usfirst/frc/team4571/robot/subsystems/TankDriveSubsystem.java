package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;
import org.usfirst.frc.team4571.robot.RobotJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {
	
	RobotDrive tankDrive;
	CANTalon leftMotor;
	CANTalon rightMotor;
	
	public TankDriveSubsystem() {
		this.leftMotor = new CANTalon(RobotConstants.LEFT_MOTOR_CHANNEL);
		this.rightMotor = new CANTalon(RobotConstants.RIGHT_MOTOR_CHANNEL);
		this.tankDrive = new RobotDrive(leftMotor, rightMotor);	
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(RobotJoystick left, RobotJoystick right) {
    	tankDrive.tankDrive(left, right);
    }
    
    public void stop() {
    	tankDrive.drive(0,0);
    }
}

