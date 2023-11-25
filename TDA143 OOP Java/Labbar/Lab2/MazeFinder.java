public class MazeFinder { 
	private Robot robot; 
	public static void main(String[] args) { 
		MazeFinder finder = new MazeFinder(); 
		finder.createEnviroment(); 
		finder.findExit(); 
	} 

	public void createEnviroment() { 
		RobotWorld world = RobotWorld.load("maze.txt"); 
		robot = new Robot(new Location(2, 0), Robot.EAST, world); 
		robot.setDelay(200); 
	} 

	// The robot finds the way through a simply connected maze
	//before: The maze is simply connected.
	//        The robot is at the entrance of the maze.
	//after:  The robot is at the exit of the maze
	public void findExit() { 
		//The implementation is your work to do!
	} 
}
