/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //DriveTrain
    public static final int FRONT_LEFT_SPARK = 4;
    public static final int BACK_LEFT_SPARK = 1;
    public static final int FRONT_RIGHT_SPARK = 3;
    public static final int BACK_RIGHT_SPARK = 2;
    //Make sure to name the motors correctly

    //Controllers
    public static final double JOYSTICK_DEADZONE = .2;
    public static final int CONTROLLER = 1;
    public static final int FLIGHTSTICK = 0;
    public static final int SHOOTER_STICK = 1;

    //Intake
    public static final int INTAKE_SPARK = 1;
    public static final double INTAKE_SPEED = .1;

    // Fortune wheel
    public static final int FORTUNE_WHEEL_SPARK = 9;
    public static final int FOUR_WHEEL_SPEED = 0;
    public static final int EIGHTH_SPINNER_TIME = 0;

    public static final int WHEEL_SPEED = 0;

    //Climber
    public static final int LEFT_CLIMBER_SPARK = 2;
    public static final int RIGHT_CLIMBER_SPARK = 3;
    public static final int TOP_SWITCH = 0;
    public static final int BOTTOM_SWITCH = 1;

    //Shooter
    public static final double SHOOTER_SPEED = 1;
    public static final double TRIGGER_SPEED = .25;
}
