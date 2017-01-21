package org.usfirst.frc.team4571.robot;

public class RobotConstants {
	public static final int FRONT_LEFT_MOTOR_CHANNEL = 1;
	public static final int FRONT_RIGHT_MOTOR_CHANNEL = 2;
	public static final int REAR_LEFT_MOTOR_CHANNEL = 3;
	public static final int REAR_RIGHT_MOTOR_CHANNEL = 4;
	
	public static final int LEFT_JOYSTICK_PORT = 0;
	public static final int RIGHT_JOYSTICK_PORT = 1;
	public static final double JOYSTICK_TUNING_PARAMETER = 0.5;
	
	public static final int LEFT_ENCODER_CHANNEL_A = 5;
	public static final int LEFT_ENCODER_CHANNEL_B = 6;
	public static final int RIGHT_ENCODER_CHANNEL_A = 7;
	public static final int RIGHT_ENCODER_CHANNEL_B = 8; 
	
	public static final double DRIVE_TRAIN_WHEEL_DIAMETER_IN_FEET = 0.5;
	public static final double DRIVE_TRAIN_PULSES_PER_REVOLUTION = 1440.0;
	public static final double DRIVE_TRAIN_WHEEL_CIRCUMFERENCE = DRIVE_TRAIN_WHEEL_DIAMETER_IN_FEET * Math.PI;
	public static final double DRIVE_TRAIN_DISTANCE_PER_PULSE = DRIVE_TRAIN_WHEEL_CIRCUMFERENCE / DRIVE_TRAIN_PULSES_PER_REVOLUTION;

    public static final int ROLLER_SOLENOID = 1;
    public static final int ROLLER_FOWARD_SOLENOID_CHANNEL = 1;
    public static final int ROLLER_REVERSE_SOLENOID_CHANNEL = 2;

    public static final int RIGHT_MOTOR_CHANNEL = 5;
}