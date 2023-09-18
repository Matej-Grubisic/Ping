import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Loser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loser extends World
{

    /**
     * Constructor for objects of class Loser.
     * 
     */
    public Loser()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
         GreenfootSound sound=  new GreenfootSound("failure.mp3");
        GreenfootImage background = new GreenfootImage("fail.png");
        setBackground(background);
        sound.play();
    }
}
