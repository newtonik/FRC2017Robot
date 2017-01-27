package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Gearpneumaticscommand extends Command {

	
	private boolean IsGearPushedOut;
	public  Gearpneumaticscommand (){
		requires(Robot.GEAR_PNEUMATICS_SUBSYSTEM);
	}


	protected void initialize() {
		Robot.GEAR_PNEUMATICS_SUBSYSTEM.initializeSubsystem();

	}
	protected void execute (){
		if (IsGearPushedOut){
			Robot.GEAR_PNEUMATICS_SUBSYSTEM.pushIn();
			
			IsGearPushedOut = false; 
		}

		else  { 

         Robot.GEAR_PNEUMATICS_SUBSYSTEM.pushOut();
         
         IsGearPushedOut = true;
		}
		
	}


	protected boolean isFinished (){
		return  true;
	}
}
