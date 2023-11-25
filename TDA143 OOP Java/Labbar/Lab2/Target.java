public class Target implements Runnable {
  
  private Robot target;
  RobotWorld world;
  private boolean dead = true;
  int delay;
  int currentLifetime = 0;
  int totalLifetime = 0;
  int respawns = 0;
  
  public Target(RobotWorld world, int delay){
    this.world = world;
    this.delay = delay;
    respawn();
  }
  
  public Location getLocation(){
    return target.getLocation();
  }
  
  public boolean killBy(Robot murderbot){
    //System.out.println(murderbot.moveLocation() + " " + target.getLocation());  
    if (!dead && murderbot.moveLocation().equals(target.getLocation())){
      dead = true;
      world.setImage(target.getLocation(), null); 
      return true;
    }
    return false;
  }
  
  public void run() {
    while(true){
       while(!dead){
         currentLifetime++;
         double r = Math.random();
         if (r < 0.8 && target.canMove())
         try {
           target.move();
         } catch (RuntimeException e) {
         
         }
         else
           target.turnLeft();
       }
       world.setImage(target.getLocation(), null);
       respawn();
    }
     
  }
  
  public void respawn(){
    if (dead){
      respawns++;
      totalLifetime += currentLifetime;
      currentLifetime = 0;
      
      Location loc;
      do {
        loc = new Location((int) (Math.random() * world.getNumRows()), 
                           (int) (Math.random() * world.getNumCols()));
      } while (!world.isValid(loc) || world.getImage(loc) != null); 
      
      target = new Robot(loc, Robot.EAST, world, "creature.gif");
      target.setDelay(delay);
      dead = false;
    }
  }
  
  public void start(){
    new Thread(this).start();  
  }
  
  public int getKills(){
    return respawns;  
  }
  
  public double getAverageLifetime(){
    return (totalLifetime+currentLifetime)/(double)respawns;
  }
}