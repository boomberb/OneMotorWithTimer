package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoMove;
import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final Joystick buttonJoystick = new Joystick();
  private final Motor m_Motor = new Motor();

  public RobotContainer() {
  
    configureBindings();
  }

  private void configureBindings() {

  }

  
  public Command getAutonomousCommand() {
    return new AutoMove(m_Motor);
  }
}
