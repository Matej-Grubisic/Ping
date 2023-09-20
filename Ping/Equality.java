import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Equality here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equality extends World
{

    /**
     * Constructor for objects of class Equality.
     * 
     */
   private int counter;
    private GreenfootSound sound;
    private boolean playSound=true;
    public Equality(int width, int height,int cellSize)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, cellSize); 
        GreenfootSound sound=  new GreenfootSound("equal.mp3");
        GreenfootImage background = new GreenfootImage("equal.png");
        background.scale(width,height);
        this.sound=sound; 
        setBackground(background);
         Label equal= new Label ("DRAW",50);
        addObject(equal,width/2,(int)(height*0.15));
      
    }
    
      public void act() {
      counter++;
      if(playSound){
        sound.play();
    }
    
    if(checkForKeyPress("enter")){
         Greenfoot.start();
         sound.stop();
         playSound=false;
         Ping pingWorld = new Ping(getWidth(),getHeight(),getCellSize());
         Greenfoot.setWorld(pingWorld);
    }
      if(counter%960==0){
        Greenfoot.start();
        Ping pingWorld = new Ping(getWidth(),getHeight(),getCellSize());
        Greenfoot.setWorld(pingWorld);
        sound.stop();
        playSound=false;
        }
    }
      private boolean checkForKeyPress(String string){
    return Greenfoot.isKeyDown(string);
    }
}
