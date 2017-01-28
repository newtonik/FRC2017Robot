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
	
    public DriveCommand(double distanceInFeet, double angle) {
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	Robot.TANK_DRIVE_SUBSYSTEM.setPIDParameters(distanceInFeet, angle);
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
    	
    	SmartDashboard.putNumber( "NavX angle", Robot.TANK_DRIVE_SUBSYSTEM.getNavXAngle() );    	
    }

    protected boolean isFinished() {
        return Robot.TANK_DRIVE_SUBSYSTEM.isFinished();
    }

    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().disable();
    }
    
    protected void interrupted() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().disable();
    }
}