import ShefRobot.*;

public class Assignment3 {

    private Robot myRobot;
    private LargeMotor left;
    private LargeMotor right;
    private MediumMotor trap;
    private ColorSensor colorSensor;
    private TouchSensor touchSensor;
    private boolean ballDropped;
    private final double SPEED; // percentage of maximum speed for normal functions range 0.2 - 0.8
    private final double CHECK_SPEED; // percentage of macimum speed for checkLine turns range 0.2 - 0.8

    /** Default constructor for the object Assignment3 */
    public Assignment3() {

        this.myRobot = null;
        this.right = null;
        this.left = null;
        this.trap = null;
        this.colorSensor = null;
        this.touchSensor = null;
        this.ballDropped = false;
        this.SPEED = 0.0;
        this.CHECK_SPEED = 0.0;

    }

    /**
     * Constructor with specified: if of the robot and ports for motors and sensors
     * 
     * @param robotId Id of the robot
     * @param right   Port of the right large motor
     * @param left    Port of the left large motor
     * @param trap    Port of the medium motor operating the ball trap
     * @param touch   Port of the touch sensor
     * @param color   Port for the color sensor
     */
    public Assignment3(String robotId, Motor.Port right, Motor.Port left, Motor.Port trap, Sensor.Port touch,
            Sensor.Port color) {

        this.myRobot = new Robot(robotId);
        this.right = myRobot.getLargeMotor(right);
        this.left = myRobot.getLargeMotor(left);
        this.trap = myRobot.getMediumMotor(trap);
        this.colorSensor = myRobot.getColorSensor(color);
        this.touchSensor = myRobot.getTouchSensor(touch);
        this.ballDropped = false;
        this.SPEED = 0.4;
        this.CHECK_SPEED = 0.2;
    }

    /** Function initializing parts of the robot and the the rest of the program */
    private void init() {

        mainForward();
        doDance();

    }

    /**
     * Interprets color under the sensor
     * 
     * @return return 0 for black, 1 for white and 2 for red
     */
    private int whatColor() {
        // TODO write interpreting color
        return 1;
    }
    /**Function that rotates robot around axis pependicular to the surface and going through the left weel
     * until the colorSensor registers black after which it returns the robot to position parallel to the line
     *
     * Use when using line check
     */

    private void checkLine() {
        right.resetTachoCount();
        right.setSpeed((int) (right.getMaxSpeed() * SPEED));
        left.setSpeed(0);
        while (whatColor() != 0){}
        right.setSpeed(0);
        left.setSpeed((int) (left.getMaxSpeed() * SPEED));
        left.rotate(right.getTachoCount());

        right.setSpeed((int) (right.getMaxSpeed() * SPEED));
        left.setSpeed((int) (left.getMaxSpeed() * SPEED));

    }

    private boolean isWall() {
        return touchSensor.isTouched();
    }

    private void wallDetected() {

    }

    private boolean isRight() {
        /*
        boolean foundJunction = false;
        if (whatColor() == 0) {
            
             * left.setSpeed((int)(left.getMaxSpeed()*(SPEED+0.1))); myRobot.sleep(300);
             * if(whatColor() == 0) foundJunction=true; right.backwards(); left.backwards();
             * myRobot.sleep(300); left.setSpeed((int)(left).getMaxSpeed()*SPEED));
             * right.forward(); left.forward();
             
        }
        
        return foundJunction;
        */

        return (whatColor()==0);
    }

    private void rightDetected() {

    }

    private boolean isRed() {
        return (whatColor()==2);
    }

    private void redDetected() {

    }

    private void doDance() {

    }

    /**
     * Main forward function with detection of different events
     */
    private void mainForward() {

        right.setSpeed((int) (right.getMaxSpeed() * SPEED));
        left.setSpeed((int) (right.getMaxSpeed() * SPEED));
        right.forward();
        left.forward();

        // int counter = 0;
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

            /*
             * myRobot.sleep(250); if(counter==4){ checkLine(); counter=0; } counter++;
             */
        }
    }

    public static void main(String[] args) {

        Assignment3 main = new Assignment3("dia-lego-e4", Motor.Port.B, Motor.Port.A, Motor.Port.C, Sensor.Port.S2, Sensor.Port.S1);
        main.init();

    }
}