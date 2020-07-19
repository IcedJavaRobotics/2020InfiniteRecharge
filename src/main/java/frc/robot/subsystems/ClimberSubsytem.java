/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsytem extends SubsystemBase {

  private Spark leftClimberSpark, rightClimberSpark, climberWire;
  private DigitalInput topSwitch, bottomSwitch;
  /**
   * Creates a new ClimberSubsytem.
   */
  public ClimberSubsytem() {

    leftClimberSpark = new Spark(Constants.LEFT_CLIMBER_SPARK);
    rightClimberSpark = new Spark(Constants.RIGHT_CLIMBER_SPARK);

    topSwitch = new DigitalInput(Constants.TOP_SWITCH);
    bottomSwitch = new DigitalInput(Constants.BOTTOM_SWITCH);

  }

  public void ClimberUp(){

    if (topSwitch.get()){
      leftClimberSpark.set(0);
      rightClimberSpark.set(0);
    } else {
      leftClimberSpark.set(.25);
      rightClimberSpark.set(.25);
    }

  }

  public void ClimberDown(){

    if (bottomSwitch.get()){
      leftClimberSpark.set(0);
      rightClimberSpark.set(0);
    } else {
      leftClimberSpark.set(-.25);
      rightClimberSpark.set(-.25);
    }

  }

  public void ClimbWire(){

    climberWire.set(.25);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
