// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.multi;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.elevator.ElevatorCommand;
import frc.robot.commands.pivot.PivotControl;
import frc.robot.subsystems.elevator.ElevatorSubsystem;
import frc.robot.subsystems.elevator.ElevatorSubsystem.ElevatorPosition;
import frc.robot.subsystems.pivot.PivotSubsystem;
import frc.robot.subsystems.pivot.PivotSubsystem.PivotPosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoLifter extends ParallelCommandGroup {
  private ElevatorSubsystem elevatorSubsystem;
  private PivotSubsystem pivotSubsystem;
  /** Creates a new AutoLifter. */
  public AutoLifter(ElevatorSubsystem elevatorSubsystem, ElevatorPosition elevatorPosition, PivotSubsystem pivotSubsystem, PivotPosition pivotPosition) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ElevatorCommand(elevatorSubsystem, elevatorPosition),
      new PivotControl(pivotSubsystem, pivotPosition)
    );
  }
}
