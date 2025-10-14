package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotID;

public class IntakeSubsystem extends SubsystemBase {

    private final SparkMax RollerLeft = new SparkMax(RobotID.Intake.ROLLER_LEFT, MotorType.kBrushless);
    private final SparkMax RollerRight = new SparkMax(RobotID.Intake.ROLLER_RIGHT, MotorType.kBrushless);
    private final RelativeEncoder rollerleftencoder = RollerLeft.getEncoder();
    private final RelativeEncoder rollerrightencoder = RollerRight.getEncoder();


  /** Creates a new IntakeSubsytem. */
  public IntakeSubsytem() {}



  // Intake Alma
  public void intakeOn(double power) {

    RollerLeft.set(power);
    RollerRight.set(-power);

  }

  // Intake Fırlatma
  public void IntakeShoot(double power) {
    RollerLeft.set(-power);
    RollerRight.set(power);
  }

  // Motor Durdurma
  public void stopIntake() {
    RollerLeft.stopMotor();
    RollerRight.stopMotor();
  }

  public double getleftposition() {
    return rollerleftencoder.getPosition();
  }

  
  public double getrightposition() {
    return rollerrightencoder.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}