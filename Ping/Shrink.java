import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shrink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shrink extends Powerup
{
    /**
     * Act - do whatever the Shrink wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shrink(int width,int height){
    super(width,height);
    
    
    }
    public void act()
    {
        super.act();
        if(passedMiddle()){
        setDX((random(2,1)*(-1)));
        if(isTouchingPaddle()){
        Paddle paddlePlayer = ((Ping)getWorld()).getPaddlePlayer();
        int width =((PaddlePlayer)paddlePlayer).getWidth();
        int height =((PaddlePlayer)paddlePlayer).getHeight();
        if(width>50){
        int shrinck = ((int)(width * 0.5));
        paddlePlayer.setWidth(shrinck);
        GreenfootImage image = new GreenfootImage(shrinck,height);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,shrinck,paddlePlayer.getHeight());
        paddlePlayer.setImage(image);
        }
        ((Ping)getWorld()).removeObject(this);
        }else if(isAtBottom()){
        ((Ping)getWorld()).removeObject(this);
        }
        }else{setDX(0);}
        
    }
}
