//package team_a7;
import ShefRobot.*;
/**
 * Code for COM1003 Assignment3
 * Written on 01.02.20 - 07.02.20
 * @author Zbigniew Lisak
 * @author
 * @author
 */
public class Assignment3 {

    private Robot myRobot;
    private LargeMotor left;
    private LargeMotor right;
    private MediumMotor trap;
    private ColorSensor colorSensor;
    private TouchSensor touchSensor;
    private boolean ballDropped;
    private final int SPEED; //General speed of the robot

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
     * Constructor with specified id of the robot and ports for motors and sensors
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
    
    private boolean isBlack(){
    	ColorSensor.Color x = colorSensor.getColor();
    	if(x==ColorSensor.Color.BLACK||x==ColorSensor.Color.BLUE) return true;
    	return false;
    }
    
    

	/**
	 * The rutine used for turning around when robot hits a wall
	 */
    private void wallDetected() {
		
		//Move back a little
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

		//empty while loops used for waiting will something happens
		myRobot.sleep(300);
    	while(colorSensor.getColor()==ColorSensor.Color.WHITE){}
    	while(isBlack()){}
    	left.stop();
		right.stop();
		
    	// Moving back to the opposite direction
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.forward();
    	right.forward();

    	
    }


    private void redDetected() {
    	
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.forward();
    	right.forward();
    	myRobot.sleep(750);
    	left.stop();
		right.stop();
    	
    	// Rotation
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	right.forward();
		left.backward();
		
		//empty while loops used for waiting will something happens
    	//myRobot.sleep(300);
    	while(colorSensor.getColor()==ColorSensor.Color.RED||colorSensor.getColor()==ColorSensor.Color.YELLOW){}
    	while(colorSensor.getColor()==ColorSensor.Color.WHITE){}
    	left.stop();
		right.stop();
		
    	//Moving a little bit back 
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.backward();
    	right.backward();
    	myRobot.sleep(500);
    	left.stop();
		right.stop();*/
		
    	//Dropping of the ball
    	trap.setSpeed(SPEED);
    	trap.forward();
    	myRobot.sleep(1000);
    	trap.stop();
    	trap.setSpeed(SPEED);
    	trap.backward();
    	myRobot.sleep(1000);
    	trap.stop();
		ballDropped = true;
		
    	//Moving back towards the line
    	left.setSpeed(SPEED);
    	right.setSpeed(SPEED);
    	left.forward();
    	right.forward();
    	myRobot.sleep(500);
    	*/
    }

    private void doDance() {
    	
    	right.backward();
    	left.backward();
    	myRobot.sleep(2000);
    	left.stop();
    	right.setSpeed(right.getMaxSpeed());
    	
    	Speaker song = myRobot.getSpeaker();
    	song.setVolume(80);
		
		//a fragment of song "Dance Monkey"
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
     * Main forward function with detection of different events and logic for following the line
     */

    private void mainForward() {
        while(true){
        	
        	ColorSensor.Color read = colorSensor.getColor();
        	System.out.println(read);
        	if(read==ColorSensor.Color.RED){
        		redDetected();
			}
			
        	if(isBlack()){
        		left.setSpeed(SPEED);
        		right.setSpeed(SPEED/4);
        		right.backward();
        		left.forward();
			}
			
        	if(read==ColorSensor.Color.WHITE){
        		right.setSpeed(SPEED);
        		left.setSpeed(SPEED/4);
        		right.forward();
        		left.backward();
			}
			
        	if(touchSensor.isTouched()){
        		if(!ballDropped) wallDetected();
        		else break; //ball dropped + hit the wall = everything was done we can celebrate
        	}
        }

        
    }

    public static void main(String[] args) {

        Assignment3 main = new Assignment3("dia-lego-D1", Motor.Port.B, Motor.Port.A, Motor.Port.C, Sensor.Port.S2, Sensor.Port.S1);
        main.init();

    }
}