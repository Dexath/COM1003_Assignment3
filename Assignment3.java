import ShefRobot.*;

public class Assignment3 {

    private Robot myRobot;
    private LargeMotor left;
    private LargeMotor right;
    private MediumMotor trap;
    private ColorSensor colorSensor;
    private TouchSensor touchSensor;
    private boolean ballDropped;
    private final int SPEED; // percentage of maximum speed range 0.2 - 0.8

    /** Default constructor for the object Assignment3 */
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
        this.SPEED = 100;

    }

    /** Function initializing parts of the robot and the the rest of the program */

    private void init() {
       
        mainForward();
        doDance();

    }

    private void wallDetected() {
    	

    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.backward();
    	right.backward();
    	myRobot.sleep(500);
    	left.stop();
    	right.stop();
    	// Rotation
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.forward();
    	right.backward();
    	myRobot.sleep(300);
    	while(colorSensor.getColor()==ColorSensor.Color.WHITE){}
    	while(colorSensor.getColor()==ColorSensor.Color.BLACK){}
    	left.stop();
    	right.stop();
    	// Moving back to the opposite direction
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.forward();
    	right.forward();
    	myRobot.sleep(100);
    	left.stop();
    	right.stop();

    	
    }

    private boolean isRed() {
        return (colorSensor.getColor() == ColorSensor.Color.RED);
    }

    private void redDetected() {

    	
    	// Rotation
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.forward();
    	right.backward();
    	myRobot.sleep(500);
    	while(colorSensor.getColor()==ColorSensor.Color.WHITE){}
    	while(colorSensor.getColor()==ColorSensor.Color.BLACK){}
    	left.stop();
    	right.stop();
    	//Moving a little bit back 
    	left.backward();
    	right.backward();
    	myRobot.sleep(500);
    	left.stop();
    	right.stop();
    	//Dropping of the ball
    	trap.setSpeed(100);
    	trap.forward();
    	myRobot.sleep(1000);
    	trap.stop();
    	trap.setSpeed(100);
    	trap.backward();
    	myRobot.sleep(1000);
    	trap.stop();
    	ballDropped = true;
    	// Moving back towards the line
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.forward();
    	right.forward();
    	myRobot.sleep(500);
    	

    	
    }

    private void doDance() {
    	
    	right.backward();
    	left.backward();
    	myRobot.sleep(2000);
    	left.stop();
    	right.setSpeed(right.getMaxSpeed());
    	
    	Speaker song = myRobot.getSpeaker();
    	
    	song.setVolume(80);
    	
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
    	song.playTone(1108, 750);
    	song.playTone(987, 450);
    	song.playTone(880, 250);
    	song.playTone(987, 250);
    	song.playTone(880, 250);
    	song.playTone(987, 250); 
    	song.playTone(880, 250);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(660, 250);
    	song.playTone(740, 750);
    	song.playTone(740, 250);
    	song.playTone(880, 150);
    	song.playTone(880, 150);
    	song.playTone(830, 750);
    	song.playTone(880, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(740, 250);
    	song.playTone(740, 250);
    	song.playTone(880, 750);
    	song.playTone(987, 450);
    	song.playTone(830, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(740, 150);
    	song.playTone(740, 150);
    	song.playTone(880, 750);
    	song.playTone(830, 750);
    	song.playTone(740, 250);  	
    	song.playTone(740, 450);
    	song.playTone(740, 250);
    	song.playTone(880, 250);
    	song.playTone(830, 250);
    	song.playTone(880, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 150);
    	song.playTone(830, 150);
    	song.playTone(880, 250);
    	song.playTone(830, 150);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(740, 750);
    	song.playTone(880, 150);
    	song.playTone(880, 150);
    	song.playTone(880, 150);
    	song.playTone(830, 550);
    	song.playTone(830, 150);
    	song.playTone(740, 150);
    	song.playTone(830, 150);
    	song.playTone(740, 150);
    	song.playTone(830, 150);
    	song.playTone(740, 150);
    	song.playTone(830, 450);
    	song.playTone(740, 150);
    	song.playTone(880, 150);
    	song.playTone(830, 250);
    	song.playTone(740, 150);
    	song.playTone(880, 750);
    	song.playTone(740, 450);
    	song.playTone(740, 450);
    	song.playTone(880, 250);
    	song.playTone(830, 150);
    	song.playTone(880, 150);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(830, 150);
    	song.playTone(880, 250);
    	song.playTone(830, 150);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(880, 250);
    	song.playTone(740, 750);
    	song.playTone(880, 150);
    	song.playTone(880, 150);
    	song.playTone(880, 150);
    	song.playTone(830, 550);
    	song.playTone(740, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(830, 250);
    	song.playTone(740, 250);
    	song.playTone(880, 450);
    	song.playTone(830, 250);
     	song.playTone(740, 250);
     	song.playTone(880, 750);
     	song.playTone(880, 450);
     	song.playTone(830, 450);
     	song.playTone(740, 450);
    }

    /**
     * Main forward function with detection of different events
     */
    private void mainForward() {
        while(true){
        	if(colorSensor.getColor()==ColorSensor.Color.RED){
        		redDetected();
        	}
        	if(colorSensor.getColor()==ColorSensor.Color.BLACK){
        		left.setSpeed(SPEED);
        		right.setSpeed(SPEED/4);
        		right.backward();
        		left.forward();
        	}
        	if(colorSensor.getColor()==ColorSensor.Color.WHITE){
        		right.setSpeed(SPEED);
        		left.setSpeed(SPEED/4);
        		right.forward();
        		left.backward();
        	}
        	if(touchSensor.isTouched()){
        		if(!ballDropped) wallDetected();
        		else break;
        	}
        }

        
    }

    public static void main(String[] args) {

        Assignment3 main = new Assignment3("dia-lego-D1", Motor.Port.B, Motor.Port.A, Motor.Port.C, Sensor.Port.S2, Sensor.Port.S1);
        main.init();

    }
}