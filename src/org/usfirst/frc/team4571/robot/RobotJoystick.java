package org.usfirst.frc.team4571.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class RobotJoystick extends Joystick {
		private Button button_1;
		private Button button_2;
		private Button button_3;
		private Button button_4;
		
		public RobotJoystick(int port) {
			super(port);
			this.button_1 = new JoystickButton(this, 1);
			this.button_2 = new JoystickButton(this, 2);
			this.button_3 = new JoystickButton(this, 3);
			this.button_4 = new JoystickButton(this, 4);
		}
		
		public RobotJoystick button_1WhenPressed(Command command) {
			this.button_1.whenPressed(command);
			return this;
		}
		
		public RobotJoystick button_1WhenReleased(Command command) {
			this.button_1.whenReleased(command);
			return this;
		}
		
		public RobotJoystick button_2WhenPressed(Command command) {
			this.button_2.whenPressed(command);
			return this;
		}
		
		public RobotJoystick button_2WhenReleased(Command command) {
			this.button_2.whenReleased(command);
			return this;
		}
		
		public RobotJoystick button_3WhenPressed(Command command) {
			this.button_3.whenPressed(command);
			return this;
		}
		
		public RobotJoystick button_3WhenReleased(Command command) {
			this.button_3.whenReleased(command);
			return this;
		}
		
		public RobotJoystick button_4WhenPressed(Command command) {
			this.button_4.whenPressed(command);
			return this;
		}
		
		public RobotJoystick button_4WhenReleased(Command command) {
			this.button_4.whenReleased(command);
			return this;
		}
		
		public Button getButton_1() {
			return this.button_1;	
		}
		
		public Button getButton_2() {
			return this.button_2;
		}
		
		public Button getButton_3() {
			return this.button_3;
		}
		
		public Button getButton_4() {
			return this.button_4;
		}
		
		public double getXAxisSpeed() {
			return this.getAxisType(0);
		}
		
		public double getYAxisSpeed() {
			return this.getAxisType(1);
		}
	}
		
