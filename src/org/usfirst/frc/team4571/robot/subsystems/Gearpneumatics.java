package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gearpneumatics extends Subsystem {

	private static final DoubleSolenoid GearSolenoid = new DoubleSolenoid (RobotConstants.GEAR_CLICKER_FORWARD_CHANNEL,RobotConstants.GEAR_CLICKER_BACK_CHANNEL );
	private static final Compressor compressor = new Compressor (RobotConstants.COMPRESSOR_CHANNEL);
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	
	}
	
	public Gearpneumatics (){
		compressor.setClosedLoopControl(true);
	}
	public void initializeSubsystem (){
		pushOut();
		
	}
	public  void pushOut() {
		// TODO Auto-generated method stub
		GearSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void pushIn() {
		GearSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public Value getSolenoidvalue(){
		return GearSolenoid.get();
		
	}
	
}
	
	
	
      
	
	
