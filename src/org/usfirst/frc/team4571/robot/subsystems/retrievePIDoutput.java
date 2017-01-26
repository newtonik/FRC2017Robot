package org.usfirst.frc.team4571.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;

public class retrievePIDoutput implements PIDOutput{

	public double output;
	
	public double getoutput(){
		return this.output;
	}
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		this.output= output;
	}
}
