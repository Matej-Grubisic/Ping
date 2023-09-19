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
    private int DX =5;  
    private int sizeSpeed=(DX*2);
    public PaddleComputer(int width,int height,Color color,String name,GreenfootImage image){
        super(width,height,color,name,image);
         this.setImage(image);
    }
    public void act()
    {
        
        if(getX()>=((getWorld().getWidth())-1)){
            ((Ping)getWorld()).setComputerAtEdge(true);
       if(this.getWidth()<=sizeSpeed){
             int worldHeight =getWorld().getHeight();
            int quarterWorld=worldHeight/4;
            int y= randomPosition(quarterWorld,worldHeight-quarterWorld);
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
   
}
