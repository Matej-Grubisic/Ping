import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

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
    public Ping()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1); 
        
        Paddle paddlePlayer =  new PaddlePlayer(200,10,Color.BLACK,"Player","left","right"); 
        GreenfootImage image =  new GreenfootImage("stickpaddlenobg2.png");
        //image.setColor(Color.BLACK);
        //image.fillRect(0,0,200,10);
        paddlePlayer.setImage(image);
        addObject(paddlePlayer,600/2,700-30);
        this.paddlePlayer=paddlePlayer;
        
        GreenfootImage imagestick = new GreenfootImage("stickpaddlenobg2.png");
        imagestick.scale(1, 33);
        PaddleComputer paddleComputer =  new PaddleComputer (0,10,Color.BLACK,"Computer", imagestick);  
        addObject(paddleComputer,0,randomPosition(50,150));
        this.paddleComputer=paddleComputer;        
        
        
        
        GreenfootSound sound=  new GreenfootSound("audiomass-output.wav");
        
        Ball ball = new Ball(10,10,Color.BLACK,sound);
        this.ball=ball;
        this.ball.turn(90);
        addObject(ball,300,100);
        
        Wall upperWall = new Wall(600,10,Color.GREEN,"upper");
        addObject(upperWall,600/2,5);
        this.upperWall=upperWall;
        
        Wall lowerWall = new Wall(600,10,Color.GREEN,"lower");
       addObject(lowerWall,600/2,695);
       this.lowerWall=lowerWall;
       
       Wall rightWall = new Wall(10,800,Color.GREEN,"right");
       addObject(rightWall,595,300);
       this.rightWall=rightWall;
       
       Wall leftWall = new Wall(10,800,Color.GREEN,"left");
       addObject(leftWall,5,300);
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
        
        //image.setColor(Color.BLACK);
        //image.fillRect(0,0,newWidth,10);
        paddleComputer.getPimage().scale(newWidth, 33);
        paddleComputer.setWidth(newWidth);
        }else if(paddleComputer.getX()<=0 && paddleComputer.getWidth()<=paddleComputer.getInitialWidth()){    
        int newWidth = paddleComputer.getWidth()+paddleComputer.getSizeSpeed();
        //GreenfootImage imagestick = new GreenfootImage("stickpaddlenobg2.png");
        //image.setColor(Color.BLACK);
        //image.fillRect(0,0,newWidth,10);
        paddleComputer.getPimage().scale(newWidth,33);
        //paddleComputer.setImage(imagestick);
        paddleComputer.setWidth(newWidth);
        }
       
       if(levelCount==8){
        Greenfoot.setWorld(new Winner());
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
