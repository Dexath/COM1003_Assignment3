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
    }

    private boolean isWall(){

    }

    private void wallDetected() {

    }

    private boolean isRight(){
        
    }

    private void rightDetected() {

    }

    private boolean isRed(){
        
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