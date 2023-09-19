import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ping extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Paddle paddlePlayer;
    private PaddleComputer paddleComputer; 
    private Ball ball;
    private Wall upperWall;
    private Wall lowerWall;
    private Wall rightWall;
    private Wall leftWall;
    private boolean isComputerAtEdge;
    private int levelCount=1;
    private Label levelLabel;
    private Label levelCounter;
    private boolean changeLevel;
    private int defaultWidth;
    private int defaultHeight;
    private int defaultCellSize; 
    
    
    public Ping(int width,int height,int pixelSize)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1); 
        Paddle paddlePlayer =  new PaddlePlayer(200,10,Color.BLACK,"Player","left","right"); 
        GreenfootImage image =  new GreenfootImage(200,10);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,200,10);
        paddlePlayer.setImage(image);
        addObject(paddlePlayer,getWidth()/2,getHeight()-30);
        this.paddlePlayer=paddlePlayer;
        
          GreenfootImage imageC =  new GreenfootImage(1,20);
       // GreenfootImage stick = new GreenfootImage("stick.jpeg"); 
        image.setColor(Color.BLACK);
        image.fillRect(0,0,0,10);
        //stick.scale(newWidth,20);
       
        PaddleComputer paddleComputer =  new PaddleComputer (0,10,Color.BLACK,"Computer",imageC); 
        int quarterWorld=getHeight()/4;
        addObject(paddleComputer,0,randomPosition(quarterWorld,getHeight()-quarterWorld));
        this.paddleComputer=paddleComputer;
        
        GreenfootSound sound=  new GreenfootSound("audiomass-output.wav");
        
        Ball ball = new Ball(10,10,Color.BLACK,sound);
        this.ball=ball;
        this.ball.turn(90);
        addObject(ball,300,100);
        
        Wall upperWall = new Wall(getWidth(),10,Color.CYAN,"upper");
        addObject(upperWall,getWidth()/2,5);
        this.upperWall=upperWall;
        
        Wall lowerWall = new Wall(getWidth(),10,Color.CYAN,"lower");
       addObject(lowerWall,getWidth()/2,(getHeight()-5));
       this.lowerWall=lowerWall;
       
       Wall rightWall = new Wall(10,(getHeight()-20),Color.CYAN,"right");
       addObject(rightWall,(getWidth()-5),(getHeight()/2));
       this.rightWall=rightWall;
       
       Wall leftWall = new Wall(10,(getHeight()-20),Color.CYAN,"left");
       addObject(leftWall,5,getHeight()/2);
       this.leftWall=leftWall;
       
    
       Label level = new Label("Level: ",40);
       Label count = new Label(this.levelCount,40);
       this.levelCounter=count;
       this.levelLabel=level;
       addObject(level, 71,38 );
       addObject(count, 125,40 );
       setPaintOrder(Ball.class,PaddleComputer.class);
    }
    public void act(){
       
       
       if(isComputerAtEdge){    
        int newWidth = paddleComputer.getWidth()-paddleComputer.getSizeSpeed();
        GreenfootImage image =  new GreenfootImage(newWidth,20);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,newWidth,10);
        paddleComputer.setImage(image);
        paddleComputer.setWidth(newWidth);
        }else if(paddleComputer.getX()<=0 && paddleComputer.getWidth()<=paddleComputer.getCurrentWidth()){    
        int newWidth = paddleComputer.getWidth()+paddleComputer.getSizeSpeed();
        GreenfootImage image =  new GreenfootImage(newWidth,20);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,newWidth,10);
        //GreenfootImage stick = new GreenfootImage("stick.jpeg");
       // stick.scale(newWidth,20);
        paddleComputer.setImage(image);
        paddleComputer.setWidth(newWidth);
        }
       
       if(levelCount==8){
        Greenfoot.setWorld(new Winner(getWidth(),getHeight(),getCellSize()));
        } 
        
       if(changeLevel){
        this.levelCount+=1;
        this.levelCounter.setValue(this.levelCount);
        this.changeLevel=false;
        } 
    }
    
    
     public Paddle getPaddlePlayer() {
        return this.paddlePlayer;
    }

    public void setPaddlePlayer(Paddle paddle) {
        this.paddlePlayer = paddle;
    }
       
     public Paddle getPaddleComputer() {
        return this.paddleComputer;
    }

    public void setPaddleComputer(PaddleComputer paddle) {
        this.paddleComputer = paddle;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Wall getUpperWall() {
        return upperWall;
    }

    public void setUpperWall(Wall upperWall) {
        this.upperWall = upperWall;
    }

    public Wall getLowerWall() {
        return lowerWall;
    }

    public void setLowerWall(Wall lowerWall) {
        this.lowerWall = lowerWall;
    }

    public Wall getRightWall() {
        return rightWall;
    }

    public void setRightWall(Wall rightWall) {
        this.rightWall = rightWall;
    }

    public Wall getLeftWall() {
        return leftWall;
    }

    public void setLeftWall(Wall leftWall) {
        this.leftWall = leftWall;
    }
    
    private int randomPosition(int min,int max){
    return Greenfoot.getRandomNumber(max-min)+min;
    }
    
    public void setComputerAtEdge(boolean value){
    this.isComputerAtEdge=value;
    }
    
       public boolean isChangeLevel() {
        return changeLevel;
    }

    public void setChangeLevel(boolean changeLevel) {
        this.changeLevel = changeLevel;
    }

    
}
