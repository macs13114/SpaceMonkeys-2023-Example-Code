package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class InvertCheck extends Robot {
    public static void CheckInvertVICTOR(VictorSPX motor1, boolean check){
        if(motor1.getInverted() != check){
            motor1.setInverted(check);
            System.out.print(motor1 + "INVERTED: Fixed");
        }
        else{
            System.out.print(motor1 + "INVERTED: Clear");
        }
    }

    public static void CheckInvertTALON(TalonSRX motor1, boolean check){
        if(motor1.getInverted() != check){
            motor1.setInverted(check);
            System.out.print(motor1 + "INVERTED: Fixed");
        }
        else{
            System.out.print(motor1 + "INVERTED: Clear");
        }
    }
}