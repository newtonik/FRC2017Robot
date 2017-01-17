package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDriveCommand extends Command {
	public boolean driveStop = false;
	public AutonomousDriveCommand() {
		requires(Robot.TANK_DRIVE_SUBSYSTEM);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		long startFowardTime = System.currentTimeMillis();
		long finishFowardTime = 10000;
		while( System.currentTimeMillis() - startFowardTime <= finishFowardTime ){
			Robot.TANK_DRIVE_SUBSYSTEM.drive(1,1,true);
		}
		long fowardTimeStop = System.currentTimeMillis();
		long finishTimeStop = 2000;
		while(System.currentTimeMillis() - fowardTimeStop <= finishTimeStop ){
			Robot.TANK_DRIVE_SUBSYSTEM.stop();
		}
		long startReverseTime = System.currentTimeMillis();
		long finishReverseTime = 5000;
		while( System.currentTimeMillis() - startReverseTime <= finishReverseTime ){
			Robot.TANK_DRIVE_SUBSYSTEM.drive(-1,-1,true);
			driveStop = true;
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return driveStop;

	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.TANK_DRIVE_SUBSYSTEM.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
