// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.elevator.ElevatorCommand;
import frc.robot.commands.intake.IntakeOnCommand;
import frc.robot.commands.intake.IntakeShootCommand;
import frc.robot.commands.multi.AutoLifter;
import frc.robot.commands.pivot.PivotControl;
import frc.robot.subsystems.elevator.ElevatorSubsystem;
import frc.robot.subsystems.elevator.ElevatorSubsystem.ElevatorPosition;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.pivot.PivotSubsystem;
import frc.robot.subsystems.pivot.PivotSubsystem.PivotPosition;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    private final CommandXboxController joystick = new CommandXboxController(0);
    private final Joystick operator = new Joystick(1);

    private final PivotSubsystem pivotSubsystem = new PivotSubsystem();
    private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();

    private final JoystickButton intake = new JoystickButton(operator, 0);
    private final JoystickButton shoot = new JoystickButton(operator, 0);
    private final POVButton coralL2 = new POVButton(operator, 0);
    private final POVButton coralL3 = new POVButton(operator, 90);

    public RobotContainer() {

        configureBindings();

    }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
    // Hareket etme definelanmadı
    intake.whileTrue(new IntakeOnCommand(intakeSubsystem));
    shoot.whileTrue(new IntakeShootCommand(intakeSubsystem));

    coralL2.onTrue(new AutoLifter(elevatorSubsystem, ElevatorPosition.CORAL1, pivotSubsystem, PivotPosition.REEFL23));
    coralL3.onTrue(
        new ParallelCommandGroup(
            new ElevatorCommand(elevatorSubsystem, ElevatorPosition.CORAL3),
            new PivotControl(pivotSubsystem, PivotPosition.REEFL23)
        )
    );
  }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    // public Command getAutonomousCommand() {
    // // An example command will be run in autonomous
    // return;
    // }
}
