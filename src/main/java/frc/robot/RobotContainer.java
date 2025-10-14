// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
// import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotID.Pivot;
import frc.robot.commands.intake.IntakeOnCommand;
import frc.robot.commands.intake.IntakeShootCommand;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.pivot.PivotSubsystem;
import frc.robot.subsystems.pivot.PivotSubsystem.PivotPosition;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  
  private final CommandXboxController joystick = new CommandXboxController(0);
  private final Joystick operator = new Joystick(0);
  private final PivotSubsystem pivotSubsystem = new PivotSubsystem();
  private final JoystickButton intake = new JoystickButton(operator, 0);
  private final JoystickButton shoot = new JoystickButton(operator, 0);
  

  public RobotContainer() {
    NamedCommands.registerCommand("intake", new IntakeOnCommand(intakeSubsystem));
    NamedCommands.registerCommand("shoot", new IntakeShootCommand(intakeSubsystem));

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
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}

//ASİL