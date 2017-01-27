package org.usfirst.frc.team4571.robot.commands.autonomous;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author mxhim Team 4571 
 *
 */
public class DriveCommand extends Command {
	
    public DriveCommand(double distanceInFeet) {
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	Robot.TANK_DRIVE_SUBSYSTEM.driveStraightForGivenDistance(distanceInFeet);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.TANK_DRIVE_SUBSYSTEM.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Left Encoder distance", Robot.TANK_DRIVE_SUBSYSTEM.getLeftEncoderDistance() );
    	SmartDashboard.putNumber("Right Encoder distance", Robot.TANK_DRIVE_SUBSYSTEM.getRightEncoderDistance() );
    	SmartDashboard.putNumber("Average distance", Robot.TANK_DRIVE_SUBSYSTEM.getDistance() );
    	
    	SmartDashboard.putNumber("Distance setpoint", Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getSetpoint() );
    	SmartDashboard.putNumber("Distance Average Error", Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getAvgError()  );
    	SmartDashboard.putNumber("Distance Get Value", Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() );
    	SmartDashboard.putNumber("Distance Error", Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getError() );
    	
    	System.out.println( "Left Encoder distance = " + Robot.TANK_DRIVE_SUBSYSTEM.getLeftEncoderDistance());
    	System.out.println("Right Encoder distance = " +Robot.TANK_DRIVE_SUBSYSTEM.getRightEncoderDistance() );
    	System.out.println("Average distance = " +Robot.TANK_DRIVE_SUBSYSTEM.getDistance() );
    	
    	System.out.println("Distance setpoint = " +Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getSetpoint() );
    	System.out.println("Distance Average Error = " +Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getAvgError()  );
    	System.out.println("Distance Get Value = " +Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() );
    	System.out.println("Distance Error = " +Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getError() );
    	System.out.println("On Target = " +Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().onTarget() );
    	
    }

    protected boolean isFinished() {
        return Robot.TANK_DRIVE_SUBSYSTEM.isDriveStraightFinished();
    }

    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().disable();
    }
    
    protected void interrupted() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().disable();
    }
}