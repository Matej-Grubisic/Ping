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
    private AIPaddle aiPaddle;
    private int scorePlayer;
    private Label scorePlayVal;
    private int scoreComputer;
    private Label scoreCompVal;
    private boolean increaseScoreComputer=false;
    private boolean increaseScorePlayer=false;
    public Ping(int width,int height,int pixelSize)
    {    
        super(width, height, 1);
        
        // adds player to the screen
        Paddle paddlePlayer =  new PaddlePlayer(100,10,Color.BLACK,"Player","left","right"); 
        
        GreenfootImage image =  new GreenfootImage(paddlePlayer.getWidth(),paddlePlayer.getHeight());
        image.setColor(Color.BLACK);
        image.fillRect(0,0,paddlePlayer.getWidth(),paddlePlayer.getHeight());
        paddlePlayer.setImage(image);
        addObject(paddlePlayer,getWidth()/2,getHeight()-30);
        this.paddlePlayer=paddlePlayer;
        
        // image for the self moving paddle
        GreenfootImage imageC =  new GreenfootImage(1,20);
        image.setColor(Color.BLACK);
        image.fillRect(0,0,0,10);
       
        // ads self moving paddle
        PaddleComputer paddleComputer =  new PaddleComputer (0,10,Color.BLACK,"Computer",imageC); 
        int quarterWorld=getHeight()/4;
        addObject(paddleComputer,0,randomPosition(quarterWorld,getHeight()-quarterWorld));
        this.paddleComputer=paddleComputer;
        
        
        // adds ai paddle to the world
        AIPaddle paddleAI= new AIPaddle(20,10,Color.BLACK,"aipaddle");
        GreenfootImage imageAI =  new GreenfootImage(paddleAI.getWidth(),paddleAI.getHeight());
        image.setColor(Color.BLACK);
        image.fillRect(0,0,paddleAI.getWidth(),paddleAI.getHeight());
        paddleAI.setImage(image);
        this.aiPaddle=paddleAI;
        addObject(paddleAI,getWidth()/2,30);
        
        // adds ball to the screen
        GreenfootSound sound=  new GreenfootSound("audiomass-output.wav");
        Ball ball = new Ball(10,10,Color.BLACK,sound);
        this.ball=ball;
        this.ball.turn(90);
        addObject(ball,width/2,height/2);
        
        // adds upper wall to the screen
        Wall upperWall = new Wall(getWidth(),10,Color.CYAN,"upper");
        addObject(upperWall,getWidth()/2,5);
        this.upperWall=upperWall;
        
        //adds lower wall to the screen
        Wall lowerWall = new Wall(getWidth(),10,Color.CYAN,"lower");
       addObject(lowerWall,getWidth()/2,(getHeight()-5));
       this.lowerWall=lowerWall;
       
       //adds right wall to the screen
       Wall rightWall = new Wall(10,(getHeight()-20),Color.CYAN,"right");
       addObject(rightWall,(getWidth()-5),(getHeight()/2));
       this.rightWall=rightWall;
       
       //adds left wall to the screen
       Wall leftWall = new Wall(10,(getHeight()-20),Color.CYAN,"left");
       addObject(leftWall,5,getHeight()/2);
       this.leftWall=leftWall;
       
    
       Label level = new Label("Level: ",40);
       Label count = new Label(this.levelCount,40);
       this.levelCounter=count;
       this.levelLabel=level;
       addObject(level,(int)(width*0.15),(int)(height * 0.15 ));
       addObject(count, (int)(width*0.28),(int)(height * 0.15 ) );
       
       // Add score labels
       Label scoreComp =  new Label("Score:",20);
       addObject(scoreComp,(int)(getWidth()*0.10),((int)(getHeight()*0.25)));
       Label scoreCompVal = new Label("",20);
       this.scoreCompVal=scoreCompVal;
       addObject(scoreCompVal,(int)(getWidth()*0.20),((int)(getHeight()*0.25)));
       Label scorePlay = new Label("Score: ",20);
       Label scorePlayVal =  new Label("",20);
       this.scorePlayVal=scorePlayVal;
       
       addObject(scorePlay,(int)(getWidth()*0.10),((int)(getHeight()*0.75)));
       addObject(scorePlayVal,(int)(getWidth()*0.20),((int)(getHeight()*0.75)));
       
       
       setPaintOrder(Ball.class,PaddleComputer.class,AIPaddle.class);
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
        paddleComputer.setImage(image);
        paddleComputer.setWidth(newWidth);
        }
       
       if(increaseScoreComputer){
        this.scoreComputer++;
        updateScoreValue(this.scoreComputer,this.scoreCompVal);
        this.increaseScoreComputer=false;
        }
        
        if(increaseScorePlayer){
        this.scorePlayer++;
        updateScoreValue(this.scorePlayer,this.scorePlayVal);
        this.increaseScorePlayer=false;
        }
        
       if(levelCount==8 && scorePlayer>0 ){
           if(scorePlayer>scoreComputer){
            Greenfoot.setWorld(new Winner(getWidth(),getHeight(),getCellSize()));
            }else if(scorePlayer<scoreComputer) {
            Greenfoot.setWorld(new Loser(getWidth(),getHeight(),getCellSize()) );
            }else {
            
            }
        } 
       if (levelCount==8 && scorePlayer==0){
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
    public AIPaddle getAiPaddle(){
    return this.aiPaddle;
    }
    
    public void  setComputerScore(boolean val){
     this.increaseScoreComputer=val;
    }
    public void setPlayerScore(boolean val){
        this.increaseScorePlayer=val;
    }
    
    public void updateScoreValue(int val,Label label){
    label.setValue(val);
    }
    
    

    
}
