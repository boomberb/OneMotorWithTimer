package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor;

public class TeleopMove extends Command {
    private Motor m_Motor;
    private DoubleSupplier speedSup;

    public TeleopMove(Motor m_Motor, DoubleSupplier speedSup) {
        this.m_Motor = m_Motor;
        this.speedSup = speedSup;
        addRequirements(m_Motor);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_Motor.setSpeed(speedSup.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
