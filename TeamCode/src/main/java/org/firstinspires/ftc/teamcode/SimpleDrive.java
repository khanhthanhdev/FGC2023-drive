package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

public class SimpleDrive extends LinearOpMode{

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private DcMotor intake;
    private DcMotor shooter;

    private Servo frontServo;
    private Servo backServo;

    private Color frontColor;
    private DistanceSensor frontDistance;

    @Override
    public void runOpMode(){
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        intake = hardwareMap.get(DcMotor.class, "intake");
        shooter = hardwareMap.get(DcMotor.class, "shooter");

        frontServo = hardwareMap.get(Servo.class, "frontServo");
        backServo = hardwareMap.get(Servo.class, "backServo");

        frontColor = hardwareMap.get(Color.class, "frontColor");
        frontDistance = hardwareMap.get(DistanceSensor.class, "frontDistance");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

                double rightPower, leftPower;

                rightPower = gamepad1.right_stick_y;
                leftPower = gamepad1.left_stick_y;


                // Tank Drive , 2 motor run independence
                if (leftPower > 0.1){
                    leftMotor.setPower(leftPower);
                } else if (leftPower < -0.1) {
                    leftMotor.setPower(leftPower);
                } else if (leftPower <= 0.1 && leftPower >= -0.1) {
                    leftMotor.setPower(0);
                }

                if (rightPower > 0.1){
                    rightMotor.setPower(rightPower);
                } else if (rightPower < -0.1) {
                    rightMotor.setPower(rightPower);
                } else if (rightPower <= 0.1 && rightPower >= -0.1) {
                    rightMotor.setPower(0);
                }




                // Show the elapsed game time and wheel power.
                telemetry.addData("Front left/Right", "%4.2f", rightPower);
                telemetry.addData("Back  left/Right", "%4.2f", leftPower);
                telemetry.update();
        }
    }





}
