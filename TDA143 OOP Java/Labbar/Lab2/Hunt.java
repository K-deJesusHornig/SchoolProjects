public class Hunt { 
	private Robot robot; 
   private Target target;
   
	public static void main(String[] args) { 
		Hunt d = new Hunt(); 
		d.createEnviroment(); 
		d.hunt(); 
	} 

	public void createEnviroment() { 
      int delay = 80;
		RobotWorld world = RobotWorld.load("canvas.txt"); 
		robot = new Robot(new Location(3,3),world); 
		robot.setDelay(delay); 
      
      target = new Target(world, delay+10);
      target.start();
	} 
 
   // Kill the annoying creature
   // It dies if it is in front of your robot when target.killBy(robot) is called 
   
	public void hunt() { 
      int kills = 0;
      while(true){
        while(!target.killBy(robot)){
          robot.turnLeft();
          // Put your creature-hunting code here
          // You can get the current location of the enemy by target.getLocation()
          // You should probably not have a loop here, more like a clever way to 
          //   get one step closer to the target
        }
        kills++;
        System.out.println();
        System.out.println("Nice! Kill count: " + target.getKills());
        System.out.println("Average hunt time: " + target.getAverageLifetime());
      }      
	}
}
