package org.usfirst.frc.team4571.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSource;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

public class averagedistanceEncoder implements PIDsource {
  
	public Encoder therightsideEncoder;
	public Encoder theleftsideEncoder;
	public PIDSourceType PIDSOURCE;
	public averagedistanceEncoder(Encoder therightsideEncoder, Encoder theleftsideEncoder) {
	this.therightsideEncoder= therightsideEncoder;
	this.theleftsideEncoder= theleftsideEncoder;
	}
	public void PIDSourceType(PIDSourceType PIDSOURCE) {
	    this.PIDSOURCE = PIDSOURCE;
	}
	public PIDSourceType getPIDSourceType(){
		return this.PIDSOURCE;
	}
	public double PIDget(){
		return ((therightsideEncoder.pidGet()+  theleftsideEncoder.pidGet()) / 2.0);
		
	}
}

