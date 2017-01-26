package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MillSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Servo leftMillMotor, rightMillMotor;
	
	public MillSubsystem(){
		
		this.leftMillMotor = new Servo(RobotConstants.LEFT_MILL_CHANNEL);
		this.rightMillMotor = new Servo(RobotConstants.RIGHT_MILL_CHANNEL);
	}
	
	public void forward(double speed){
		this.leftMillMotor.set(speed);
		this.rightMillMotor.set(speed);
	}
	
	public void reverse(double speed){
		this.leftMillMotor.set(speed);
		this.rightMillMotor.set(speed);
	}
	
	public void stop(){
		this.leftMillMotor.set(0.0);
		this.rightMillMotor.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    
    
    }
}

