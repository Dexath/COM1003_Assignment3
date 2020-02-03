import ShefRobot.*;

public class Assignment3 {

    private Robot myRobot;
    private LargeMotor left;
    private LargeMotor right;
    private MediumMotor trap;
    private ColorSensor colorSensor;
    private TouchSensor touchSensor;
    private boolean ballDropped;
    private final double SPEED; // percentage of maximum speed range 0.0 - 1.0

    public Assignment3() {

        this.myRobot = null;
        this.right = null;
        this.left = null;
        this.trap = null;
        this.colorSensor = null;
        this.touchSensor = null;
        this.ballDropped = false;
        this.SPEED = 0;

    }
    /**Constructor with specified: if of the robot and ports for motors and sensors 
     * 
     * @param robotId Id of the robot
     * @param right Port of the right large motor
     * @param left Port of the left large motor
     * @param trap Port of the medium motor operating the ball trap
     * @param touch Port of the touch sensor
     * @param color Port for the color sensor
     */
    public Assignment3(String robotId, Motor.Port right, Motor.Port left, Motor.Port trap, Sensor.Port touch,
            Sensor.Port color) {

        this.myRobot = new Robot(robotId);
        this.right = myRobot.getlargeMotor(right);
        this.left = myRobot.getLargeMotor(left);
        this.trap = myRobot.getMediumMotor(trap);
        this.colorSensor = myRobot.getCoulorSensor(color);
        this.touchSensor = myRobot.getTouchSensor(touch);
        this.ballDropped = false;
        this.SPEED = 0.4;
    }

    private void init() {
        this.myRobot = new Robot();
        //TODO write the rest of init
    }

    /**
     * Interprets color under the sensor
     * 
     * @return return 0 for black, 1 for white and 2 for red
     */
    private int whatColor() {
        //TODO write interpreting color
    }

    private boolean isWall() {
        return touchSensor.isTouched();
    }

    private void wallDetected() {

    }

    private boolean isRight() {
        if (whatColor() == 0)
            return true;
        return false;
    }

    private void rightDetected() {

    }

    private boolean isRed() {
        if (whatColor() == 2)
            return true;
        return false;
    }

    private void redDetected() {

    }

    private void mainForward() {

        right.setSpeed(right.getMaxSpeed * SPEED);
        left.setSpeed(right.getMaxSpeed * SPEED);
        right.forward();
        left.forward();

        while (true) {
            if (isWall()) {
                wallDetected();
                if (ballDropped)
                    break;
            }
            if (isRight())
                rightDetected();
            if (isRed())
                redDetected();
        }
    }

    public static void main(String[] args) {

        Assignment3 main = new Assignment3("dia-lego-e4");
        main.init();

    }
}