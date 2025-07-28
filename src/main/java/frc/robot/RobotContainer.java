package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoMove;
import frc.robot.commands.TeleopMove;
import frc.robot.subsystems.Motor;
import frc.robot.Constants.OperatorConstants;

public class RobotContainer {
  private final Joystick controller = new Joystick(OperatorConstants.kDriverControllerPort);
  private final Motor m_Motor = new Motor();
  private final JoystickButton activateAuto = new JoystickButton(controller, XboxController.Button.kA.value);
  private final int manualMove = XboxController.Axis.kLeftY.value;

  public RobotContainer() {
    m_Motor.setDefaultCommand(
      new TeleopMove(
        m_Motor,
        () -> -controller.getRawAxis(manualMove)
      )
    );
    configureBindings();  
  }

  private void configureBindings() {
    activateAuto.onTrue(new AutoMove(m_Motor));
  }

  
  public Command getAutonomousCommand() {
    return new AutoMove(m_Motor);
  }
}
