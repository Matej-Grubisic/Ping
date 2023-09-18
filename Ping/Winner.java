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

    public Winner()
    {    
    
        super(600, 400, 1); 
        GreenfootSound sound=  new GreenfootSound("success-fanfare-trumpets-6185.mp3");
        GreenfootImage background = new GreenfootImage("winner1.png");
        setBackground(background);
        Label winner = new Label ("YOU WON",50);
        addObject(winner,600/2,60);
        sound.play();
        
    }
}
