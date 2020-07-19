/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {

  private CANSparkMax frontLeft, backLeft, frontRight, backRight;
  private CANEncoder encoderfl, encoderbl, encoderfr, encoderbr;

  /**
   * Creates a new DriveTrainSubsystem.
   */

  public DriveTrainSubsystem() {

    // Creating the sparks

    frontLeft = new CANSparkMax(Constants.FRONT_LEFT_SPARK, MotorType.kBrushless);
    backLeft = new CANSparkMax(Constants.BACK_LEFT_SPARK, MotorType.kBrushless);
    frontRight = new CANSparkMax(Constants.FRONT_RIGHT_SPARK, MotorType.kBrushless);
    backRight = new CANSparkMax(Constants.BACK_RIGHT_SPARK, MotorType.kBrushless);

    // Setting Spark Inversion

    frontLeft.setInverted(false);
    backLeft.setInverted(false);
    frontRight.setInverted(false);
    backRight.setInverted(false);

    // Creating the encoders

    encoderfl = new CANEncoder(frontLeft);
    encoderbl = new CANEncoder(backLeft);
    encoderfr = new CANEncoder(frontRight);
    encoderbr = new CANEncoder(backRight);

  }

  // Moves a spark by a set speed

  public void moveMotor( double speed, CANSparkMax spark ) {

    spark.set( speed );

  }

  public void resetEncoderDistance(){

    encoderfl.setPosition(0);
    encoderbl.setPosition(0);
    encoderfr.setPosition(0);
    encoderbr.setPosition(0);

  }

  public double getflEncoderPosition(){

    return encoderfl.getPosition();

  }

  public void moveMotorDistance(double speed, CANSparkMax spark, double distance, CANEncoder encoder) {

   spark.set(speed);

  }

  // Moving sparks baced on JoyStick

  public void mecanumDrive( double X, double Y, double R ) {

    moveMotor( X + Y + R, frontLeft );
    moveMotor( X - Y - R, frontRight );
    moveMotor( X - Y + R, backLeft );
    moveMotor( X + Y - R, backRight );
    System.out.println(getflEncoderPosition());
  }

  public void ForwardCommand(double speed, double distance){

    moveMotorDistance(speed, frontLeft, distance, encoderfl);
    moveMotorDistance(speed, frontRight, distance, encoderbl);
    moveMotorDistance(speed, backLeft, distance, encoderfr);
    moveMotorDistance(speed, backRight, distance, encoderbr);

  }

  public void ForwardRightDiagonalDrive(double speed, double distance) {
    System.out.println("Alright");
    moveMotorDistance(speed, frontLeft, distance, encoderfl);
    moveMotorDistance(speed, backRight, distance, encoderbr);

    double encoderOutput = encoderfl.getPosition();
    System.out.println(encoderOutput);

  }

  public void RotateLeftCommand(double speed, double distance){

    moveMotorDistance(-speed, frontLeft, distance, encoderfl);
    moveMotorDistance(speed, frontRight, distance, encoderbl);
    moveMotorDistance(-speed, backLeft, distance, encoderfr);
    moveMotorDistance(speed, backRight, distance, encoderbr);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}