package org.usfirst.frc.team4571.robot.subsystems.PID;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

public class AngleOutput implements PIDOutput {
	RobotDrive robotDrive;
	DistanceOutput distanceOutput;
	
	public AngleOutput(RobotDrive robotDrive, DistanceOutput distanceOutput) {
		this.robotDrive = robotDrive;
		this.distanceOutput = distanceOutput;
	}
	
	@Override
	public void pidWrite(double output) {
		this.robotDrive.tankDrive(distanceOutput.getTranslationalSpeed() - output, distanceOutput.getTranslationalSpeed() + output);
	}
}