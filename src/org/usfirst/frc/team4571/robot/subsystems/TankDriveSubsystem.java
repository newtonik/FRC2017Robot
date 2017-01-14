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
	CANTalon frontLeftMotor;
	CANTalon frontRightMotor;
	CANTalon rearLeftMotor;
	CANTalon rearRightMotor;
	CANTalon goFoward;
	CANTalon goBack;
	
	public TankDriveSubsystem() {
		this.frontLeftMotor = new CANTalon(RobotConstants.FRONT_LEFT_MOTOR_CHANNEL);
		this.frontRightMotor = new CANTalon(RobotConstants.FRONT_RIGHT_MOTOR_CHANNEL);
		this.rearRightMotor = new CANTalon(RobotConstants.REAR_RIGHT_MOTOR_CHANNEL);
		this.rearLeftMotor = new CANTalon(RobotConstants.REAR_LEFT_MOTOR_CHANNEL);
		this.frontRightMotor.setInverted(true);
		this.rearRightMotor.setInverted(true);
		this.tankDrive = new RobotDrive(frontLeftMotor, frontRightMotor, rearLeftMotor, rearRightMotor);	
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
    
    public void drive(double leftValue, double rightValue, boolean squaredInputs) {
    	this.tankDrive.tankDrive(leftValue, rightValue, squaredInputs);
    
    }
    
    public void stop() {
    	tankDrive.drive(0,0);
    }
    
 }

