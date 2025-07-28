package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class Motor extends SubsystemBase {
    private TalonFX motorOne;
    //pickle

    public Motor () {
        motorOne = new TalonFX(14);
    }

    public void setSpeed(double output) {
        motorOne.setVoltage(output * 2);
    }

    public void stopMotor() {
        motorOne.setVoltage(0);
    }
}
