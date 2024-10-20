package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakerConstants;
import frc.robot.subsystems.Intaker;

public class Intaker extends SubsystemBase {

    private static TalonFX m_Motor = new TalonFX(0, "canivore");

    public Intaker() {

    }

    public void SetTakingInSpd() {
        m_Motor.set(IntakerConstants.TakingInPct);
    }

    public void Stop() {
        m_Motor.set(0.);
    }

    public void SetSpd(double spd) {
        m_Motor.set(spd);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intaker", m_Motor.getVelocity().getValueAsDouble());
    }

    public static Intaker m_Instance;

    public static Intaker getInstance() {      //make sure everyone gets the same Instance
        return m_Instance == null ? m_Instance = new Intaker() : m_Instance;
    }
}
