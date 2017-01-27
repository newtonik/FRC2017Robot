package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.commands.AutonomousDriveCommand2;
import org.usfirst.frc.team4571.robot.commands.Gearpneumaticscommand;
import org.usfirst.frc.team4571.robot.commands.TankDriveCommand;
import org.usfirst.frc.team4571.robot.subsystems.Gearpneumatics;
import org.usfirst.frc.team4571.robot.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * 
 * @author arjunrao87
 *
 */
public class Robot extends IterativeRobot {

	public static final RobotJoystick LEFT_JOYSTICK = new RobotJoystick(RobotConstants.LEFT_JOYSTICK_PORT);
	public static final RobotJoystick RIGHT_JOYSTICK = new RobotJoystick(RobotConstants.RIGHT_JOYSTICK_PORT);
	
	public static final TankDriveSubsystem TANK_DRIVE_SUBSYSTEM = new TankDriveSubsystem();
	public static final TankDriveCommand TANK_DRIVE_COMMAND = new TankDriveCommand();
	public static final AutonomousDriveCommand2 AUTO_DRIVE_COMMAND2 = new AutonomousDriveCommand2();
	public static final Gearpneumatics GEAR_PNEUMATICS_SUBSYSTEM = new Gearpneumatics();
	public static final Gearpneumaticscommand GEAR_PNEMATICS_COMMAND = new Gearpneumaticscommand(); 

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	public void robotInit() {
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    @Override
    public void disabledInit(){
    }
	
    @Override
	public void disabledPeriodic() {
    	Scheduler.getInstance().removeAll();
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 */
    @Override
    public void autonomousInit() {
    	Scheduler.getInstance().add(AUTO_DRIVE_COMMAND2);
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
    	Scheduler.getInstance().add(GEAR_PNEMATICS_COMMAND);
    	Scheduler.getInstance().add(TANK_DRIVE_COMMAND);
    	
    	
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Robot.LEFT_JOYSTICK.button1WhenPressed(GEAR_PNEMATICS_COMMAND);
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}