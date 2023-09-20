    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.List;
    
    /**
     * Write a description of class Ball here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Ball extends Actor
    {
        /**
         * Act - do whatever the Ball wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        private int width;
        private int height;
        private Color color;
        private int DX=0;
        private int DY=3;
        private final int initialSpeed=2;
        private int speed=2;
        private boolean start =true;
        private GreenfootSound mySound; 
        private int paddleCount;
        private  final int[] dividers= {25,50,75,100};
        private  String lastTouchedWall=null;
        
        public Ball(int width,int height,Color color,GreenfootSound sound) {
            this.color=color;
            this.height=height;
            this.width=width;
            this.start=true;
            GreenfootImage image = new GreenfootImage(width, height); 
            image.setColor(color); 
            image.fillOval(0, 0, width,height); 
            setImage(image);
            this.mySound =sound ;
        }
        public void act()
        {
             World world= (Ping)getWorld();
             Wall right = ((Ping)getWorld()).getRightWall();
             Wall upper = ((Ping)getWorld()).getUpperWall();
             Wall left = ((Ping)getWorld()).getLeftWall();
             Wall lower = ((Ping)getWorld()).getLowerWall();
             Paddle paddlePlayer = ((Ping)getWorld()).getPaddlePlayer();
             Paddle paddleComputer = ((Ping)getWorld()).getPaddleComputer();
             AIPaddle paddleAi = ((Ping)getWorld()).getAiPaddle(); 
             
           
       
            if(isTouchingPaddle(paddlePlayer)){
                paddleCount+=1;
                paddleAi.setReturnedBall(true);
                if(paddleCount%10==0){
                 this.speed+=1;
                 DX=this.speed;
                 DY=this.speed;
                 ((Ping)getWorld()).setChangeLevel(true);
                }
              mySound.play();
              int ballX =this.getX();
              int paddlePos = paddlePlayer.getX();
              
               //if ball is hitted with the right side off the paddle will move in oposite direction
           

              if(lastTouchedWall!=null){   
               //if ball comes from the right and hits the right part off the paddle,bounce to left
              if((lastTouchedWall=="right") && (ballX<paddlePos)){
               int calculatePos=paddlePos-ballX;
               changeDirectionLeft(calculatePos,paddlePlayer.getWidth());
                }else if((lastTouchedWall=="right") && (ballX>paddlePos)){ 
               int calculatePos=ballX-paddlePos;
               changeDirectionLeft(calculatePos,paddlePlayer.getWidth());        
            }
                //if ball comes from the left and hits left side off the paddle,bounce to right
                  if((lastTouchedWall=="left") && (ballX<paddlePos)){
               int calculatePos=paddlePos-ballX;
               changeDirectionRight(calculatePos,paddlePlayer.getWidth());
                }else if((lastTouchedWall=="left") && (ballX>paddlePos)){
               int calculatePos=ballX-paddlePos;
               changeDirectionRight(calculatePos,paddlePlayer.getWidth()); 
                }
                
            }else {
               if(ballX>paddlePos){
              int calculatePos=ballX-paddlePos;
               changeDirectionRight(calculatePos,paddlePlayer.getWidth());
            }
                     if(ballX<paddlePos){
               int calculatePos=paddlePos-ballX;
                changeDirectionLeft(calculatePos,paddlePlayer.getWidth());
               }
            }
        
                
                 //if ball is hitted with the left side off the paddle will move in oposite direction
          
             DY=speed*(-1);
             
            }
               if(isTouchingPaddle(paddleAi)){
                mySound.play();
                paddleAi.setReturnedBall(false);
                DY=+speed;
                lastTouchedWall=null;
                }
            
            //controls the movement off the ball if hits the computer lower part off the paddle
            if(isTouchingPaddle(paddleComputer)&&DY<0){
              mySound.play();
             DY=+speed;
             lastTouchedWall=null;
             paddleAi.setReturnedBall(false);
        }
            
            //controls the movement off the ball if hits the computer lower part off the paddle
            if(isTouchingPaddle(paddleComputer)&&DY<0){
              mySound.play();
             DY=+speed;
             lastTouchedWall=null;
        }
            // controls the direction off the ball if is hitting the upper wall
            if(isTouchingWalls(upper)){
                 mySound.play();
               lastTouchedWall=null;
                paddleAi.setReturnedBall(false);
                ((Ping)getWorld()).setPlayerScore(true);
                reSpawnBall();
              DX=0;
              DY=(DY*(-1));
            }
            // controlss the direction off the ball if is hitting the left wall
            if(isTouchingWalls(left)){
               mySound.play();
                DX=(DX*(-1));
                lastTouchedWall="left";
            }
            // controlss the direction off the ball if is hitting the right wall
             if(isTouchingWalls(right)){
               mySound.play();
                 DX=(DX*(-1));
                 lastTouchedWall="right";
            }
            // controlss the direction off the ball if is hitting the lower wall
            if(isTouchingWalls(lower)){
              mySound.play();
              ((Ping)getWorld()).setComputerScore(true);
           reSpawnBall();
              DX=0;
            }
            setLocation(getX()+DX,getY()+DY);
        }
        
       
        
        private boolean isTouchingPaddle(Actor actor){
        return this.intersects(actor);
        }
        
        private boolean isTouchingWalls(Actor actor){
         return this.intersects(actor);
        }
        
        private int randomDegrees(){
        return  Greenfoot.getRandomNumber(3)+1;
        }
        
        public int getDY(){
        return this.DY;
        }
        
        public int getDX(){
        return this.DX;
        }
        
        private GreenfootImage changeColor( int width, int height,Color color){
        GreenfootImage image = new GreenfootImage(width, height); 
            image.setColor(color); 
            image.fillOval(0, 0, width,height); 
             return image;
        }
        
        
        private void changeDirectionRight(int pos,int paddleSize){
              
            if(pos>=paddleSize&&pos<=(paddleSize*0.25)){
                DX=this.speed+1;
                }
         
              if(pos>=(paddleSize*0.25)&&pos<=(paddleSize*0.50)){
                DX=this.speed+2;
                }
              if(pos>=(paddleSize*0.50)&&pos<=(paddleSize*0.75)){
                DX=this.speed+3;
                }
                  if(pos>=(paddleSize*0.75)&&pos<=paddleSize){
                DX=this.speed+4;
                }
        }
        
        private void changeDirectionLeft(int pos,int paddleSize){
     if(pos>=paddleSize&&pos<=(paddleSize*0.25)){
                DX=(this.speed+1)*(-1);
                }
             if(pos>=(paddleSize*0.25)&&pos<=(paddleSize*0.50)){
                DX=(this.speed+2)*(-1);
                }
              if(pos>=(paddleSize*0.50)&&pos<=(paddleSize*0.75)){
                DX=(this.speed+3)*(-1);
                }
                  if(pos>=(paddleSize*0.75)&&pos<=paddleSize){
                DX=(this.speed+4)*(-1);
                }
        }
        
        private void checkDirectionFromRight(Wall wall){
        this.lastTouchedWall=wall.getName();
        }
        
        private void checkDirectionFromLeft(Wall wall){
        this.lastTouchedWall=wall.getName();
        }
        private void reverseDirectionLeft(int pos){
           if(pos>=dividers[2]&&pos<=dividers[3]){
                DX=(this.speed)*(-1);
                }
        }
        private void reverseDirectionRight(int pos){
                  if(pos>=dividers[2]&&pos<=dividers[3]){
                DX=this.speed;
                }
        }
        private void reSpawnBall(){
              int middleX =(int)(((Ping)getWorld()).getWidth()/2);
              int middleY = (int)(((Ping)getWorld()).getHeight()/3);
              setLocation(middleX,middleY);
        }
        
    }
