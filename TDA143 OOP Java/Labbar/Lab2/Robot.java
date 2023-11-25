public class Robot  { 
   private RobotWorld world; 
   private Location robotLoc; 
   private int direction; 
   private int delay = 250; 
   private static final String ROBOT_NORTH_IMAGE = "robotnorth.gif"; 
   private static final String ROBOT_SOUTH_IMAGE = "robotsouth.gif"; 
   private static final String ROBOT_EAST_IMAGE = "roboteast.gif"; 
   private static final String ROBOT_WEST_IMAGE = "robotwest.gif"; 
   public static final int NORTH = 0; 
   public static final int EAST = 1; 
   public static final int SOUTH = 2; 
   public static final int WEST = 3; 
   
   private final String[] IMAGES = new String[4];
   private static final Location[] VECTORS = new Location[4];
   private static final int[] LEFT = new int[4];

   public Robot(Location loc, int direction, RobotWorld world, String image) { 
      this. world = world;
      if (image != null) {
        // Override all images
        IMAGES[NORTH] = image;
        IMAGES[EAST]  = image;
        IMAGES[SOUTH] = image;
        IMAGES[WEST]  = image;
      } else {
        IMAGES[NORTH] = ROBOT_NORTH_IMAGE;
        IMAGES[EAST]  = ROBOT_EAST_IMAGE;
        IMAGES[SOUTH] = ROBOT_SOUTH_IMAGE;
        IMAGES[WEST]  = ROBOT_WEST_IMAGE;
      }
      
      VECTORS[NORTH] = new Location(-1,0);
      VECTORS[EAST]  = new Location(0,+1);
      VECTORS[SOUTH] = new Location(+1,0);
      VECTORS[WEST]  = new Location(0,-1);
      
      LEFT[NORTH] = WEST;
      LEFT[EAST]  = NORTH;
      LEFT[SOUTH] = EAST;
      LEFT[WEST]  = SOUTH;
       
      robotLoc = loc; 
      if (world.isValid(robotLoc) && world.getImage(robotLoc) != null) 
         throw new RuntimeException("Can't set image, location is occupied!"); 
      setDirection(direction); 
   } 
   
   public Robot(Location loc, int direction, RobotWorld world) { 
      this(loc,direction,world,null);
   }

   public Robot(Location loc, RobotWorld world) { 
      this(loc, NORTH, world);
   } 

   private void setDirection(int direction) { 
      this.direction = direction; 
      world.setImage(robotLoc, getImage()); 
   } 
   
   public void setDelay(int milliseconds)  { 
      delay = milliseconds; 
      RobotWorld.pause(delay);
    } 

   public void move()  { 
      if (world == null) 
         throw new RuntimeException("Map not loaded yet"); 
      Location newLoc = moveLocation();
      if (!world.isValid(newLoc)) 
         throw new RuntimeException("Attempt to move robot from " + robotLoc 
                                    + " to invalid location " + newLoc); 
      if (world.getImage(newLoc) != null) 
         throw new RuntimeException("Attempt to move robot from " + robotLoc 
                                    + " to occupied location " + newLoc); 
      world.setImage(robotLoc, null); 
      robotLoc = newLoc; 
      world.setImage(robotLoc, getImage()); 
      RobotWorld.pause(delay); 
   }//move 

   public void turnLeft()  { 
      if ( world == null) 
         throw new RuntimeException("Map not loaded yet"); 
      direction = LEFT[direction];
      world.setImage(robotLoc, getImage()); 
      RobotWorld.pause(delay); 
   }//turnLeft 

   public void makeLight()  { 
      if (world == null) 
         throw new RuntimeException("Map not loaded yet"); 
      if (!onDark()) 
         throw new RuntimeException("Location " + robotLoc + " is already light"); 
      world.setColor(robotLoc, RobotWorld.LIGHT_COLOR); 
      RobotWorld.pause(delay); 
   } 

   public void makeDark()  { 
      if (world == null) 
         throw new RuntimeException("Map not loaded yet"); 
      if (onDark()) 
         throw new RuntimeException("Location " + robotLoc + " is already dark"); 
      world.setColor(robotLoc, RobotWorld.DARK_COLOR); 
      RobotWorld.pause(delay); 
   } 

   public boolean onDark()  { 
      if (world == null) 
         throw new RuntimeException("Map not loaded yet"); 
      return world.getColor(robotLoc).equals(RobotWorld.DARK_COLOR); 
   } 

   public boolean canMove()  { 
      if ( world == null) 
         throw new RuntimeException("Map not loaded yet"); 
      int row = robotLoc.getRow(); 
      int col = robotLoc.getCol(); 
      Location loc; 
      if (direction == NORTH) 
         loc = new Location(row - 1, col); 
      else if (direction == SOUTH) 
         loc = new Location(row + 1, col); 
      else if (direction == EAST) 
           loc = new Location(row, col + 1); 
      else 
         loc = new Location(row, col - 1); 
      return world.isValid(loc) && world.getImage(loc) == null; 
   } 

   public boolean atEndOfWorld() { 
      if (direction == NORTH) { 
         return robotLoc.getRow() == 0; 
          } 
      else if (direction == SOUTH) { 
         return robotLoc.getRow() == world.getNumRows() - 1; 
      } 
      else if (direction == EAST) { 
            return robotLoc.getCol() == world.getNumCols() - 1; 
        } 
      else { 
         return robotLoc.getCol() == 0; 
      } 
   } 

   public Location getLocation() { 
      return robotLoc; 
   } 

   public int getDirection() {
      return direction;
   }
   
   public Location moveLocation(){
      return getLocation().delta(VECTORS[direction]);
   }
   
   public String getImage(){
     return IMAGES[direction];
   }

} 
