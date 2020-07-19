/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class FortuneWheelSubsystem extends SubsystemBase {

  private Spark fortuneWheelSpark;
  
  /**
   * Creates a new FortuneWheelSubsystem.
   */

  public final static Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  public final static Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  public final static Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  public final static Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  public final static I2C.Port i2cPort = I2C.Port.kOnboard;
  //public final static ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  public final static ColorMatch m_colorMatcher = new ColorMatch();


  public FortuneWheelSubsystem() {

    fortuneWheelSpark = new Spark(Constants.FORTUNE_WHEEL_SPARK);
    fortuneWheelSpark .setInverted(false);
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

  }

  public void wheelSpin() {

    fortuneWheelSpark.set( Constants.WHEEL_SPEED );

  }

  public void wheelStop() {

    fortuneWheelSpark.set(0);

  }

  public void colorSet() {

    String gameData;
    int runTime = 0;

    //Color detectedColor = m_colorSensor.getColor();
    //ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    /*if( gameData.length() > 0 )
    {
      switch (gameData.charAt(0))
      {

        case 'B' :
          if (match.color == kRedTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 2;
          } 
          else if (match.color == kGreenTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 3;
          } 
          else if (match.color == kYellowTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME;
          } 
          else {}
          break;

        case 'G' :
          if (match.color == kBlueTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME;
          } 
          else if (match.color == kRedTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 3;
          } 
          else if (match.color == kYellowTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 2;
          } 
          else {}
          break;

        case 'R' :
          if (match.color == kBlueTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 2;
          } 
          else if (match.color == kGreenTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME;
          } 
          else if (match.color == kYellowTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 3;
          } 
          else {}
          break;

        case 'Y' :
          if (match.color == kBlueTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 3;
          } 
          else if (match.color == kRedTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME;
          } 
          else if (match.color == kGreenTarget) {
            runTime = Constants.EIGHTH_SPINNER_TIME * 2;
          } 
          else {} 
          break;

        default :
          //This is corrupt data
          break;
      }
    } 
    else {
      //Code for no data received yet
    }
*/
    long beginning = System.currentTimeMillis();
    long end = beginning + runTime;
    while (end > System.currentTimeMillis()){
      Robot.fortuneWheelSubsystem.wheelSpin();
    }
      Robot.fortuneWheelSubsystem.wheelStop();

    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
