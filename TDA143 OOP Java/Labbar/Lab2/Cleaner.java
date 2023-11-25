public class Cleaner {
   private Robot robot;
   public static void main(String[] args) {
	  System.out.println(System.getProperty("user.dir"));
      Cleaner cleaner = new Cleaner();
      cleaner.createEnviroment();
      cleaner.cleanCorridors();
   }

   private void createEnviroment() {
      RobotWorld world = RobotWorld.load("square.txt");
      robot = new Robot(new Location(1, world.getNumCols() - 2), Robot.WEST, world);
      robot.setDelay(250);
   }
   

	//before: The room has four corridors, forming a square
	//        The robot is located in beginning of a corridor, facing the corridor
	//        in counter-clockwise direction.
	//        Each corridor has a length of five cells.
	//        All cells in the corridors are dark.
	//after:  All cells in the corridors are light.
	//        The robot has the same location as before and is facing the same direction
   private void cleanCorridors() {
      // This is where your code goes (remove this comment)
   }
   
} 

