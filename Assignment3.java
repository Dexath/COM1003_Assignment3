import ShefRobot.*;

public class Assignment3 {

    private Robot myRobot;
    private LargeMotor left;
    private LargeMotor right;
    private MediumMotor trap;
    private ColorSensor colorSensor;
    private TouchSensor touchSensor;
    private boolean ballDropped;
    private final double SPEED; // percentage of maximum speed range 0.2 - 0.8

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

    }

    /** Function initializing parts of the robot and the the rest of the program */
    private void init() {
        
        //mainForward();
        doDance();
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
        while (colorSensor.getColor() != ColorSensor.Color.BLACK){}
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
        if (colorSensor.getColor() == ColorSensor.Color.BLACK) {
            
             * left.setSpeed((int)(left.getMaxSpeed()*(SPEED+0.1))); myRobot.sleep(300);
             * if(colorSensor.getColor() == ColorSensor.Color.BLACK) foundJunction=true; right.backwards(); left.backwards();
             * myRobot.sleep(300); left.setSpeed((int)(left).getMaxSpeed()*SPEED));
             * right.forward(); left.forward();
             
        }
        
        return foundJunction;
        */

        return (colorSensor.getColor() == ColorSensor.Color.BLACK);
    }

    private void rightDetected() {

        right.setSpeed(0);
    	left.setSpeed((int) (left.getMaxSpeed() * SPEED));
        left.forward();
        myRobot.sleep(3000);
        left.stop();

    }

    private boolean isRed() {
        return (colorSensor.getColor() == ColorSensor.Color.RED);
    }

    private void redDetected() {
  
    }

    private void doDance() {
    	
    	/*right.backward();
    	left.backward();
    	myRobot.sleep(3000);
    	left.stop();
    	right.setSpeed(right.getMaxSpeed());*/
    	
    	Speaker song = myRobot.getSpeaker();
    	song.playTone(1108, 250);
    	song.playTone(1108, 250);
    	song.playTone(1108, 250);
    	song.playTone(1108, 250);
    	song.playTone(1108, 250);
    	song.playTone(1108, 250);
    	song.playTone(1108, 250);
    	song.playTone(880, 150);
    	song.playTone(1108, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
      	song.playTone(740, 150);
    	song.playTone(880, 250);
    	song.playTone(987, 250);
    	song.playTone(987, 250);
    	song.playTone(987, 250);
    	song.playTone(987, 250);
    	song.playTone(987, 250);
    	song.playTone(987, 250);
    	song.playTone(987, 250);
    	song.playTone(830, 150);
    	song.playTone(987, 250);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 250);
    	song.playTone(880, 250);
    	song.playTone(830, 700);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(830, 700);
    	song.playTone(740, 250);
    	song.playTone(740, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 250);
    	song.playTone(880, 250);
    	song.playTone(830, 700);
    	
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

        Assignment3 main = new Assignment3("dia-lego-D1", Motor.Port.B, Motor.Port.A, Motor.Port.C, Sensor.Port.S2, Sensor.Port.S1);
        main.init();

    }
}