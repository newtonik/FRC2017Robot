package org.usfirst.frc.team4571.robot.subsystems.PID;

import edu.wpi.first.wpilibj.PIDOutput;

public class DistanceOutput implements PIDOutput {
	private double output;

	@Override
	public void pidWrite(double output) {
		this.output = output;
	}
	
	public double getOutput() {
		return this.output;
	}
}