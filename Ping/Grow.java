import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grow extends Powerup
{
    /**
     * Act - do whatever the Grow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Grow(int width,int height){
      super(width,height);  
    GreenfootImage image = new GreenfootImage("stick.png");
    image.scale(width,height);
    setImage(image);
    }
    public void act()
    {
        // Add your action code here.
        super.act();
        
        if(passedMiddle()){
        setDX(random(2,1));
        if(isTouchingPaddle()){
        Paddle paddlePlayer = ((Ping)getWorld()).getPaddlePlayer();
        int width =((PaddlePlayer)paddlePlayer).getWidth();
        int height =((PaddlePlayer)paddlePlayer).getHeight();
        if(width<=225){
        int grow = ((int)(width * 1.5));
        paddlePlayer.setWidth(grow);
        GreenfootImage image = new GreenfootImage(grow,height);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,grow,paddlePlayer.getHeight());
        paddlePlayer.setImage(image);
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
