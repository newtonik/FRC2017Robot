package org.usfirst.frc.team4571.robot.commands.autonomous;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightCommand extends Command {
	
	private double distanceInFeet;

    public DriveStraightCommand(double distanceInFeet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.distanceInFeet = distanceInFeet;
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	Robot.TANK_DRIVE_SUBSYSTEM.driveStraightForGivenDistance(distanceInFeet, 0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.TANK_DRIVE_SUBSYSTEM.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.TANK_DRIVE_SUBSYSTEM.isDriveStraightFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}