import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Padlle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    /**
     * Act - do whatever the Padlle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String name;
    private Color color;
    private int width;
    private final int initialWidth=200;
    private int height;
    private GreenfootImage image;
    public Paddle (int width,int height,Color color,String name){
        this.name=name;
        this.color=color;
        this.width=width;
        this.height=height;
    }
        public Paddle (int width,int height,Color color,String name,GreenfootImage image){
        this.name=name;
        this.color=color;
        this.width=width;
        this.height=height;
        this.image=image;
    }
    public void act()
    {
        
    }
    public String getName(){
    return this.name;
    }
     public boolean isTouchingWalls(Actor actor){
     return this.intersects(actor);
    }
    public void setWidth(int width){
    this.width=width;
    }
    public int getWidth(){
    return this.width;
    }
    public  int getInitialWidth(){
    return this.initialWidth;
    }
 
}
