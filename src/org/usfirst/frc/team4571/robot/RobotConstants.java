package org.usfirst.frc.team4571.robot;

public class RobotConstants {
	public static final int FRONT_LEFT_MOTOR_CHANNEL = 1;
	public static final int FRONT_RIGHT_MOTOR_CHANNEL = 2;
	public static final int REAR_LEFT_MOTOR_CHANNEL = 3;
	public static final int REAR_RIGHT_MOTOR_CHANNEL = 4;
	
	public static final int LEFT_JOYSTICK_PORT = 0;
	public static final int RIGHT_JOYSTICK_PORT = 1;
	public static final double JOYSTICK_TUNING_PARAMETER = 0.5;
	
	public static final int LEFT_ENCODER_CHANNEL_A = 0;
	public static final int LEFT_ENCODER_CHANNEL_B = 1;
	public static final int RIGHT_ENCODER_CHANNEL_A = 2;
	public static final int RIGHT_ENCODER_CHANNEL_B = 3; 
	
	public static final double DRIVE_TRAIN_WHEEL_DIAMETER_IN_FEET = 0.5;
	public static final double DRIVE_TRAIN_PULSES_PER_REVOLUTION = 360.0;
	public static final double GEAR_RATIO = 10.71;
	public static final double FUDGE_FACTOR = 1.0;
	public static final double DISTANCE_PER_PULSE = Math.PI * DRIVE_TRAIN_WHEEL_DIAMETER_IN_FEET /
	DRIVE_TRAIN_PULSES_PER_REVOLUTION / GEAR_RATIO * FUDGE_FACTOR;
}