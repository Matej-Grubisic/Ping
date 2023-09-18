import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaddleComputer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaddleComputer extends Paddle
{
    /**
     * Act - do whatever the PaddleComputer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int DX =4;  
    private int sizeSpeed=(DX*2);
    public PaddleComputer(int width,int height,Color color,String name, GreenfootImage image){
        super(width,height,color,name, image);
        
    }
    public void act()
    {
        if(getX()>=599){
            ((Ping)getWorld()).setComputerAtEdge(true);
       if(this.getWidth()<=sizeSpeed){
            int y= randomPosition(50,150);
           ((Ping)getWorld()).setComputerAtEdge(false);
           setLocation(0,y);
        }
                    
        }
        if(this.getWidth()>=this.getInitialWidth()){
        setLocation(getX()+DX,getY());
        }
         
        
    }
    
    public void setX(int speed){
    this.DX=speed;
    }
    
    private int randomPosition(int min,int max){
    return Greenfoot.getRandomNumber(max-min)+min;
    }
    public void setSizeSpeed(int speed){
    this.sizeSpeed=speed; 
    }
     public int getSizeSpeed(){
    return this.sizeSpeed; 
    }
    public GreenfootImage getPimage(){
        return this.getImage();
    }
}
