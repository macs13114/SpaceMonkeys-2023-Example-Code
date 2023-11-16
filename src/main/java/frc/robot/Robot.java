// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private VictorSPX left_back_CIM;
  private VictorSPX right_back_CIM;
  private VictorSPX right_front_CIM;
  private VictorSPX left_front_CIM;

  private TalonSRX left_fire;
  private TalonSRX right_fire;

  private Joystick xboxJoystick;
  private boolean but_X_Intake = xboxJoystick.getRawButton(0);
  private boolean but_A_Fire = xboxJoystick.getRawButton(1);

  public void arcade(double thr, double turn)
  {
    double left = -thr - turn;
    double right = -thr + turn;
    
    left_front_CIM.set(ControlMode.PercentOutput, left);
    right_back_CIM.set(ControlMode.PercentOutput, right);
  }

  public void firing()
  {
    if(but_X_Intake)
    {
      left_fire.set(ControlMode.PercentOutput, 0.6);
    }
    else if(but_A_Fire)
    {
      left_fire.set(ControlMode.PercentOutput, -1.0);
    }
  }
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    left_back_CIM = new VictorSPX(0);
    left_front_CIM = new VictorSPX(1);
    right_front_CIM = new VictorSPX(2);
    right_back_CIM = new VictorSPX(3);

    left_fire = new TalonSRX(4);
    right_fire = new TalonSRX(5);

    if(left_back_CIM.getInverted() != true){
      left_back_CIM.setInverted(true);
      System.out.print("Left Back INVERTED: Fixed");
    }
    else
    {
      System.out.print("Left Back INVERTED: Clear");
    }

    if(left_front_CIM.getInverted() != true){
      left_front_CIM.setInverted(true);
      System.out.print("Left Back INVERTED: Fixed");
    }
    else{
      System.out.print("Left Back INVERTED: Clear");
    }

    if(right_front_CIM.getInverted() != false){
      right_front_CIM.setInverted(false);
      System.out.print("Left Back INVERTED: Fixed");
    }
    else{
      System.out.print("Left Back INVERTED: Clear");
    }

    if(right_back_CIM.getInverted() != false){
      right_back_CIM.setInverted(false);
      System.out.print("Left Back INVERTED: Fixed");
    }
    else{
      System.out.print("Left Back INVERTED: Clear");
    }

    if(left_fire.getInverted() != true){
      left_fire.setInverted(true);
      System.out.print("Left Back INVERTED: Fixed");
    }
    else{
      System.out.print("Left Back INVERTED: Clear");
    }

    if(right_fire.getInverted() != false){
      right_fire.setInverted(false);
      System.out.print("Left Back INVERTED: Fixed");
    }
    else{
      System.out.print("Left Back INVERTED: Clear");
    }

    left_back_CIM.follow(left_front_CIM);
    right_back_CIM.follow(left_front_CIM);
    right_fire.follow(left_fire);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double thr = xboxJoystick.getRawAxis(0);
    double turn = xboxJoystick.getRawAxis(1);
    
    arcade(thr, turn);
    firing();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
