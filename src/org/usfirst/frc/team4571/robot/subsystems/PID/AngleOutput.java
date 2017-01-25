package org.usfirst.frc.team4571.robot.subsystems.PID;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

public class AngleOutput implements PIDOutput {
	RobotDrive robotDrive;
	
	public AngleOutput(RobotDrive robotDrive) {
		this.robotDrive = robotDrive;
	}
	
	@Override
	public void pidWrite(double output) {
		this.robotDrive.tankDrive(-output, output);
	}
}