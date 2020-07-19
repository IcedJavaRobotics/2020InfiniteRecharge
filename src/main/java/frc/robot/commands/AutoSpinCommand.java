/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AutoSpinCommand extends CommandBase {
  /**
   * Creates a new AutoLSpinCommand.
   */
  private final double m_distance;
  private final double m_speed;
  private final DriveTrainSubsystem driveTrainSubsystem;

  public AutoSpinCommand(double speed, double distance, DriveTrainSubsystem drive) {

    m_speed = speed;
    m_distance = distance;
    driveTrainSubsystem = drive;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrainSubsystem.resetEncoderDistance();
    System.out.println("Spin Starts");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*
      Only God understands why this code works.

      Nested identical while loops

      Magic. Do not touch.
    */
    while (Math.abs(driveTrainSubsystem.getflEncoderPosition()) < m_distance) {
      System.out.println(driveTrainSubsystem.getflEncoderPosition());
    driveTrainSubsystem.RotateLeftCommand(m_speed, m_distance);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(driveTrainSubsystem.getflEncoderPosition()) >= m_distance;
  }
}
