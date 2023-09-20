import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{

    /**
     * Constructor for objects of class Intro.
     * 
     */
    private GreenfootSound backgroundSound;
    private int counter;
    private boolean playSound=true;
    private GreenfootImage backgroundImage;
    public Intro (){
    super(400,600,1);
    setDefaultImage();  
    setDefaultSound(); 
    setText();
    setControls();
    }
    public void act() {
      counter++;
      if(playSound){
        backgroundSound.play();
    }
    
    if(checkForKeyPress("enter")){
         Greenfoot.start();
         backgroundSound.stop();
         playSound=false;
         Ping pingWorld = new Ping(getWidth(),getHeight(),getCellSize());
         Greenfoot.setWorld(pingWorld);
    }
      if(counter%960==0){
        Greenfoot.start();
        Ping pingWorld = new Ping(400,600,1);
        Greenfoot.setWorld(pingWorld);
        backgroundSound.stop();
        playSound=false;
        }
    }
    
    
    private boolean checkForKeyPress(String string){
    return Greenfoot.isKeyDown(string);
    }
    private void setDefaultImage(){
       GreenfootImage image = new GreenfootImage("retropong.png");
        image.scale(getWidth(),getHeight());
        setBackground(image);
        this.backgroundImage =image;
    }
    private void scaleImage(GreenfootImage image){
      image.scale(getWidth(),getHeight());
    }
    private void setDefaultSound(){
            GreenfootSound sound = new GreenfootSound("intro.mp3");
            this.backgroundSound=sound;
    }
    private void setText(){
     String title = "Classic ping game";
        String rulePlayer ="1) If the ball touches the bottom,you lose.";
         String ruleComputer ="2) If the ball touches the upper wall,";
         String computer= "computer loose.";
         String start ="To start:";
         String press = "Press Enter";
        Label label= new Label(title,30);
        addObject(label,getWidth()/2,((int)((getHeight()/4)*0.2)));
        Label labelRPlayer= new Label(rulePlayer,25);
        addObject(labelRPlayer,getWidth()/2,((int)((getHeight()/4)*0.4)));
        Label labelRComp= new Label(ruleComputer,25);
        addObject(labelRComp,getWidth()/2,((int)((getHeight()/4)*0.6)));
        Label labelRComp1= new Label(computer,25);
        addObject(labelRComp1,getWidth()/2,((int)((getHeight()/4)*0.8)));
               Label startL= new Label(start,30);
        addObject(startL,((int)((getWidth()/2)*0.6)),((int)((getHeight()/4)*1.2)));
               Label pressL= new Label(press,30);
        addObject(pressL,(int)((getWidth()/2)),((int)((getHeight()/4)*1.4)));
    }
    private void setControls(){
        String controlls="Controlls";
        String left="Left <-";
        String right =" -> Right";
    Label label= new Label(controlls,30);
    addObject(label,(int)(getWidth()*0.75),((int)((getHeight()*0.45))));
    GreenfootImage image  = new GreenfootImage("left.png");
    image.scale(10,10);
    Label leftL = new Label(left,30);
    addObject(leftL,(int)(getWidth()*0.65),((int)((getHeight()*0.50))));
    Label rightL = new Label(right,30);
    addObject(rightL,(int)(getWidth()*0.85),((int)((getHeight()*0.50))));
    
    
    }
}
