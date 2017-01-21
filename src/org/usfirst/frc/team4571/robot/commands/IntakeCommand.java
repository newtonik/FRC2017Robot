package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {


	public IntakeCommand() {
		requires(Robot.INTAKE_SUBSYSTEM);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.INTAKE_SUBSYSTEM.reverse(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if( Robot.INTAKE_SUBSYSTEM.getRollerIn() ){
			Robot.INTAKE_SUBSYSTEM.out(.5);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.INTAKE_SUBSYSTEM.stop();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}


}
