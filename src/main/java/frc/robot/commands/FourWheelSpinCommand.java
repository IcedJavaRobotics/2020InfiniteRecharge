/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.FortuneWheelSubsystem;

public class FourWheelSpinCommand extends CommandBase {
  /**
   * Creates a new FourWheelSpinCommand.
   */

  private final FortuneWheelSubsystem fortuneWheelSubsystem;

  public FourWheelSpinCommand( FortuneWheelSubsystem subsystem ) {
    fortuneWheelSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements( fortuneWheelSubsystem );
  }

  // Called when the command is initially scheduled.

  @Override
  public void initialize() {

    long beginning = System.currentTimeMillis();
    long end = beginning + Constants.EIGHTH_SPINNER_TIME * 32;
    while (end > System.currentTimeMillis()){
      Robot.fortuneWheelSubsystem.wheelSpin();
    }
    Robot.fortuneWheelSubsystem.wheelStop();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
