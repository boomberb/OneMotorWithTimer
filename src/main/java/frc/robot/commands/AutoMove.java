package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor;
import edu.wpi.first.wpilibj.Timer;

public class AutoMove extends Command {
    private Motor m_Motor;
    private Timer timer;

    public AutoMove(Motor m_Motor) {
        this.m_Motor = m_Motor;
        timer = new Timer();
        addRequirements(m_Motor);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.hasElapsed(7.5)) {
            m_Motor.setSpeed(-1);
        } else {
            m_Motor.setSpeed(1);
        }
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(15);
    }

    @Override
    public void end(boolean interrupted) {
        m_Motor.stopMotor();
        timer.stop();
        timer.reset();
    }
}
