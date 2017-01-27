package org.usfirst.frc.team4571.robot.subsystems.PID;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

public class DistanceOutput implements PIDOutput {
	private RobotDrive robotDrive;
	public double output;
	
	public DistanceOutput(RobotDrive robotDrive) {
		this.robotDrive = robotDrive;
	}

	@Override
	public void pidWrite(double output) {
		this.output = output;
		this.robotDrive.tankDrive(output, output);
	}
	
	public double getTranslationalSpeed() {
		return this.output;
	}
}