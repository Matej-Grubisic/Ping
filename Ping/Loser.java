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
    public Loser(int width, int height,int cellSize)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, cellSize); 
         GreenfootSound sound=  new GreenfootSound("failure.mp3");
        GreenfootImage background = new GreenfootImage("fail.png");
        background.scale(width,height);
        setBackground(background);
        sound.play();
    }
}
