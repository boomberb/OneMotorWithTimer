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
            if (timer.hasElapsed(11.25)) {
                m_Motor.setSpeed(1 - (timer.get() - 11.25) / 3.75);
            } else {
                m_Motor.setSpeed((timer.get() - 7.5) / 3.75);
            }
        } else {
            if (timer.hasElapsed(3.75)) {
                m_Motor.setSpeed(-1 + (timer.get() - 3.75) / 3.75);
            } else {
            m_Motor.setSpeed(-timer.get() / 3.75);
            }
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
