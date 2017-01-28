package org.usfirst.frc.team4571.robot.subsystems.PID;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

public class AngleOutput implements PIDOutput {
	
	private RobotDrive robotDrive;
	private PIDController distanceController;
	
	public AngleOutput(RobotDrive robotDrive, PIDController distanceController) {
		this.robotDrive = robotDrive;
		this.distanceController = distanceController;
	}
	
	@Override
	public void pidWrite(double output) {
		this.robotDrive.tankDrive(distanceController.get() - output, distanceController.get() + output);
	}
}