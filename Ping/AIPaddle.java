import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AIPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIPaddle extends Paddle
{
    /**
     * Act - do whatever the AIPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed=5;
    private boolean ballReturnedByPlayer=false; 
    public AIPaddle(int width,int height,Color color,String name){
     super(width,height,color,name);
    }
    public void act()
    {
        if(ballReturnedByPlayer){
         Wall left = ((Ping)getWorld()).getLeftWall();
         Wall right = ((Ping)getWorld()).getRightWall();
          Ball ball = ((Ping)getWorld()).getBall();  
          int ballDirection= ball.getX();
          
          if(!isTouchingWalls(right)){
            if((getX()+getWidth()/2<ballDirection) ){
             move(speed);  
            }
        }
        if(!isTouchingWalls(left)){
        if((getX()+getWidth()/2>ballDirection) ){
             move(speed*(-1));  
            }
        }
    }else if(!ballReturnedByPlayer) {
           int myLocation= getX();
           int middle = ((Ping)getWorld()).getWidth()/2;
    if(myLocation>middle){
        move(speed*(-1));
    }
    if(myLocation<middle){
    move(speed);
    }
}
     
    }
    
    public void setReturnedBall(boolean value){
    this.ballReturnedByPlayer=value;
    }
    
    public boolean getReturnedBall(){
    return this.ballReturnedByPlayer;
    }
    
}
