import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends Powerup
{
    /**
     * Act - do whatever the Speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Speed (int width, int height){
    super(width,height);
    }
    
    public void act()
    {
       
        super.act();
        if(passedMiddle()){
        setDX(random(2,1));
        
        if(isTouchingPaddle()){
        Paddle paddlePlayer = ((Ping)getWorld()).getPaddlePlayer();
        int speed=((PaddlePlayer)paddlePlayer).getSpeed();
        if(speed<8){
        ((PaddlePlayer)paddlePlayer).setSpeed(speed+=1);
        }
        ((Ping)getWorld()).removeObject(this);
        }else if(isAtBottom()){
        ((Ping)getWorld()).removeObject(this);
        }
        }else{
        setDX(0);
        }
        
        
    }
}
