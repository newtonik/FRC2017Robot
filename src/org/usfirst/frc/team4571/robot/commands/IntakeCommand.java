package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {
	private boolean isRollerOut;
	public IntakeCommand() {
		requires(Robot.INTAKE_SUBSYSTEM);

	}
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.INTAKE_SUBSYSTEM.initialize();
	}
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if( isRollerOut ) {
			Robot.INTAKE_SUBSYSTEM.in();
			isRollerOut = false;
		}
		else{
			Robot.INTAKE_SUBSYSTEM.out();
			Robot.INTAKE_SUBSYSTEM.setSpeed(.5);
			isRollerOut = true;
			
		}
	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}
	// Called once after isFinished returns true
	protected void end() {
		Robot.INTAKE_SUBSYSTEM.stopRoller(0);
		Robot.INTAKE_SUBSYSTEM.in();
	}
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
