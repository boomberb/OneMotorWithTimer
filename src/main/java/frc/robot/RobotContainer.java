package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoMove;
import frc.robot.subsystems.Motor;
import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {
  private final Joystick buttonJoystick = new Joystick(OperatorConstants.kDriverControllerPort);
  private final Motor m_Motor = new Motor();
  //private final JoystickButton autoMoveIGuess = new JoystickButton(buttonJoystick, XboxController.Button, )
  private final JoystickButton activateAutoTurn = new JoystickButton(buttonJoystick);

  public RobotContainer(new AutoMove, () -> Motor.getAutonomousCommand ) {

    configureBindings();
    
    
  }

  private void configureBindings() {

  }

  
  public Command getAutonomousCommand() {
    return new AutoMove(m_Motor);
  }
}
