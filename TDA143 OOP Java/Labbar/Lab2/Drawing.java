public class Drawing { 
	private Robot robot; 
	public static void main(String[] args) { 
		Drawing d = new Drawing(); 
		d.createEnviroment(); 
		d.draw (); 
	} 

	public void createEnviroment() { 
		RobotWorld world = RobotWorld.load("canvas.txt"); 
		robot = new Robot(new Location(3, 3), Robot.WEST, world); 
		robot.setDelay(50); 
	} 
 
   // before: none
   // after: drawn a smiley face :)
	public void draw() { 
      
	}
   
}
