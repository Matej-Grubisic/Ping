import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerups here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerup extends Actor
{
    /**
     * Act - do whatever the Powerups wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int DX=0;
    private int DY=2;
    //to implement feature=> when player misses ball go back to normal, onlly when is bigger than normal ;
    //to implement mistery box
    // to implement end game bomb; 
    public Powerup (int width,int height){
    }
    
    public void act()
    {
       
        setLocation(getX()+DX,getY()+DY);
    }
  
    
    public int random(int max, int min){
    return Greenfoot.getRandomNumber(max-min)+min;
    }
    public void setDX(int val){
        this.DX=val;
    }
    public boolean  passedMiddle(){
        return (getY()>((Ping)getWorld()).getHeight()/2);
    }
    
    public boolean isTouchingPaddle(){
    Paddle paddlePlayer = ((Ping)getWorld()).getPaddlePlayer();   
    return this.intersects(paddlePlayer);
    }
    public boolean isAtBottom(){
    Wall lower = ((Ping)getWorld()).getLowerWall();
    return this.intersects(lower);
    }
}
