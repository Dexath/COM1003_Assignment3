

import ShefRobot.*;

public class SensorsTest{


    public static void main(String[] args) {
        Robot test = new Robot("dia-lego-a7");
        ColorSensor color = test.getColorSensor(Sensor.Port.S1);
        color.setMode(ColorSensor.Mode.AMBIENT);
        GyroSensor gyro = test.getGyroSensor(Sensor.Port.S2);
        TouchSensor touch = test.getTouchSensor(Sensor.Port.S3);

        while(!touch.isTouched()){

            System.out.println("Getcolor: " + color.getAmbient());
            System.out.println("Getgyro " + gyro.getAngle());

        }

        System.out.println("Touch detected");
    }

}