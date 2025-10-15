
package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.elevator.ElevatorSubsystem;
import frc.robot.subsystems.elevator.ElevatorSubsystem.ElevatorPosition;

public class ElevatorCommand extends Command {
  private ElevatorSubsystem elevatorSubsystem;
  private ElevatorPosition level;
  private double goalPos;
  public ElevatorCommand(ElevatorSubsystem elevatorSubsystem,ElevatorPosition level) {
    this.elevatorSubsystem=elevatorSubsystem;
    this.level=level;
    addRequirements(elevatorSubsystem);
   
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    switch(level){
      case CORAL1:
        goalPos=Constants.ElevatorConstants.CORAL1;
        break;
      case CORAL2:
        goalPos=Constants.ElevatorConstants.CORAL2;
        break;
      case CORAL3:
        goalPos=Constants.ElevatorConstants.CORAL3;
        break;
      case ALGI1:
        goalPos=Constants.ElevatorConstants.ALGI1;
        break;
      case ALGI2:
        goalPos = Constants.ElevatorConstants.ALGI2;
        break;
      case BARGE:
        goalPos = Constants.ElevatorConstants.BARGE;
        break;
      case HUMAN_PLAYER:
        goalPos = Constants.ElevatorConstants.HUMAN_PLAYER;
        break;


      default:
        break;
    }
    elevatorSubsystem.ElevatorController.setSetpoint(goalPos);


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  double power = elevatorSubsystem.ElevatorController.calculate(elevatorSubsystem.getElevatorPosition());
    power = power * 0.6;
    if(power < 0) {
      power = Math.max(-1.6, power);
      
    }else{
      power = Math.min(power, 1.6) * 1.3;
    }

    elevatorSubsystem.ElevatorUp(power);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return elevatorSubsystem.ElevatorController.atSetpoint();
  }
}
