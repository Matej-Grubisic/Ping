import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaddlePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaddlePlayer extends Paddle
{
    /**
     * Act - do whatever the PaddlePlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed=5;
    private String control1;
    private String control2;
    public PaddlePlayer (int width,int height,Color color,String name,String control1,String control2){
    super(width,height,color,name);
    this.control1=control1;
    this.control2=control2;
    }
    public void act()
    {
        Wall left = ((Ping)getWorld()).getLeftWall();
         Wall right = ((Ping)getWorld()).getRightWall();
         if (Greenfoot.isKeyDown(control1) && isTouchingWalls(left)!=true) {
           move(-this.speed);
          
          
        }else{
            move(0);}
         if (Greenfoot.isKeyDown(control2) && isTouchingWalls(right)!=true) {
           move(this.speed);
       
           
        }else{
        move(0);
         } 
    }
    public int getSpeed(){
    return this.speed;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
        public String getControl1() {
        return control1;
    }

    public void setControl1(String control1) {
        this.control1 = control1;
    }

    public String getControl2() {
        return control2;
    }

    public void setControl2(String control2) {
        this.control2 = control2;
    }
}
