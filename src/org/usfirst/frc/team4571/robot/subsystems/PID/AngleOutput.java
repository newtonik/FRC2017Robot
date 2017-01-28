package org.usfirst.frc.team4571.robot.subsystems.PID;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AngleOutput implements PIDOutput {
	
	private RobotDrive robotDrive;
	private PIDController distanceController;
	
	public AngleOutput(RobotDrive robotDrive, PIDController distanceController) {
		this.robotDrive = robotDrive;
		this.distanceController = distanceController;
	}
	
	@Override
	public void pidWrite(double output) {
		SmartDashboard.putNumber("Left Speed ( Distance - Turn )" , distanceController.get() - output);
		SmartDashboard.putNumber("Right Speed ( Distance + Turn )" , distanceController.get() + output);
		this.robotDrive.tankDrive(distanceController.get() - output, distanceController.get() + output);
	}
}