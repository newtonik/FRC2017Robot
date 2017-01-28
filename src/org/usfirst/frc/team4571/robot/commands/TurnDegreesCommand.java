package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnDegreesCommand extends Command {

    public TurnDegreesCommand(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	Robot.TANK_DRIVE_SUBSYSTEM.setPIDParameters(0, angle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.TANK_DRIVE_SUBSYSTEM.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber( "NavX angle", Robot.TANK_DRIVE_SUBSYSTEM.getNavXAngle() );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.TANK_DRIVE_SUBSYSTEM.isFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
    }
}
