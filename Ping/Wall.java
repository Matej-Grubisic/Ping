import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Walls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    /**
     * Act - do whatever the Walls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 private String name;
 private int width;
 private int height;
 public Wall (int width ,int height,Color color,String name){
     this.name=name;
     this.width=width;
     this.height=height;
 GreenfootImage image =  new GreenfootImage(width,height);
    image.setColor(color);
    image.fillRect(0,0,width,height);
    setImage(image);
        }
    public void act()
    {
        // Add your action code here.
    }
    
    public String  getName(){
    return this.name;    
    }
    
    public int getWallWidth(){
    return this.width;
    }
    
     public int getWallHeight(){
    return this.height;
    }
}
