
package frc.robot;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.pathplanner.lib.config.PIDConstants;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.*;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;

import java.io.IOException;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class IntakeConstants {
    public static final double IntakePower = 0.35;
}
public static final class PivotConstants {
  public static final double PIVOT_KP = 0.07;
  public static final double PIVOT_KI = 0.0002;
  public static final double PIVOT_KD = 0.0002;

  public static final double CLOSE = 0.0;
  public static final double NORMAL = -5;
  public static final double HP = -10.7;
  public static final double REEFL1 = -9;
  public static final double REEF_L2_L3 = -24.5;
  public static final double REEF_L4 = -24;
  public static final double BARGE = -24;
  public static final double PROCESSOR = -24;
  public static final double A1 = -22.5;
  public static final double A2 = -22.4;

  public static final double PIVOT_POWER = 0.65;
} 
public static final class ElevatorConstants {
  public static final double ELEVATOR_KP = 0.07;
  public static final double ELEVATOR_KI = 0.0002;
  public static final double ELEVATOR_KD = 0.0002;



  public static final double CORAL1 = 5;
  public static final double CORAL2 = 10;
  public static final double CORAL3 = 15;
  public static final double ALGI1 = 9;
  public static final double ALGI2 = 14;
  public static final double BARGE = -24;
  public static final double HUMAN_PLAYER = 10;

}
}
