package org.usfirst.frc.team4571.robot.subsystems.PID;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PIDOutput;

public class DistanceOutput implements PIDOutput {
	
	private CANTalon frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;
	
	public DistanceOutput(CANTalon frontLeftMotor, 
						  CANTalon rearLeftMotor,
						  CANTalon frontRightMotor, 
						  CANTalon rearRightMotor) {
		this.frontLeftMotor = frontLeftMotor;
		this.rearLeftMotor = rearLeftMotor;
		this.frontRightMotor = frontRightMotor;
		this.rearRightMotor = rearRightMotor;
	}

	@Override
	public void pidWrite(double output) {
		this.frontLeftMotor.set(output);
		this.rearLeftMotor.set(output);
		this.frontRightMotor.set(output);
		this.rearRightMotor.set(output);
	}
}