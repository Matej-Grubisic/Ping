import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Winner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Winner extends World
{

    /**
     * Constructor for objects of class Winner.
     * 
     */
    private GreenfootSound sound;
    private boolean playSound=true;
    private int counter;
    public Winner(int width,int height, int cellSize)
    {    
        super(width,height, cellSize); 
        GreenfootSound sound=  new GreenfootSound("winner.mp3");
        GreenfootImage background = new GreenfootImage("winner1.png");
        background.scale(width,height);
        setBackground(background);
        Label winner = new Label ("YOU WON",50);
        addObject(winner,width/2,(int)(height*0.15));
        this.sound=sound;
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
