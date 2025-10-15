
package frc.robot.subsystems.elevator;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotID;

public class ElevatorSubsystem extends SubsystemBase {
  
  double positionZero=0;

  private TalonFX MotorRight = new TalonFX(14);
  private TalonFX MotorLeft = new TalonFX(15);

  public final PIDController ElevatorController;

  private double PIDOutput = 0;


  public enum ElevatorPosition{
    CORAL1,CORAL2,CORAL3,ALGI1,ALGI2,BARGE,HUMAN_PLAYER
  }

  public ElevatorSubsystem() {
    
    ElevatorController = new PIDController(Constants.ElevatorConstants.ELEVATOR_KP, Constants.ElevatorConstants.ELEVATOR_KI, Constants.ElevatorConstants.ELEVATOR_KD);

    ElevatorController.setTolerance(0.15); //Tolerance 0.15

    MotorLeft.setPosition(0);
    MotorRight.setPosition(0);
  }
  public void setSetPoint(double setPoint){
    ElevatorController.setSetpoint(setPoint);


  }
  public void setDistance(double setPoint){
    PIDOutput = ElevatorController.calculate((getElevatorPosition() - positionZero) - setPoint);
    ElevatorUp(PIDOutput);

  }
  public void ElevatorUp(double speed){
    MotorRight.set(speed);
    MotorLeft.set(speed);

  }

  public void ElevatorDown(double speed){
    MotorRight.set(-speed);
    MotorLeft.set(-speed);

  }

  public void ElevatorStop(){
    MotorRight.stopMotor();
    MotorLeft.stopMotor(); 

  }

  public double getElevatorPosition(){
    return MotorRight.getPosition().getValueAsDouble();

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
