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
        public Ball(int width,int height,Color color,GreenfootSound sound) {
            this.color=color;
            this.height=height;
            this.width=width;
            this.start=true;
            GreenfootImage image = new GreenfootImage(width, height); 
            image.setColor(color); 
            image.fillOval(0, 0, width,height); 
            setImage("orangeball.png");
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
             
       
            if(isTouchingPaddle(paddlePlayer)){
                paddleCount+=1;
                if(paddleCount%10==0){
                 this.speed+=1;
                 DX=this.speed;
                 DY=this.speed;
                 ((Ping)getWorld()).setChangeLevel(true);
                }
              mySound.play();
              int ballX =this.getX();
              int paddlePos = paddlePlayer.getX();
              
              // if ball is hitted with the right side off the paddle will move in oposite direction
              if(ballX>paddlePos){
              int calculatePos=ballX-paddlePos;
               changeDirectionRight(calculatePos);
                }
                
                // if ball is hitted with the left side off the paddle will move in oposite direction
                if(ballX<paddlePos){
              int calculatePos=paddlePos-ballX;
                changeDirectionLeft(calculatePos);
                
                }
             DY=-speed;
             
            }
            
            //controls the movement off the ball if hits the computer lower part off the paddle
            if(isTouchingPaddle(paddleComputer)&&DY<0){
              mySound.play();
             DY=+speed;   
        }
            // controlss the direction off the ball if is hitting the upper wall
            if(isTouchingWalls(upper)){
                 mySound.play();
               DY=(DY*(-1));
            }
            // controlss the direction off the ball if is hitting the left wall
            if(isTouchingWalls(left)){
               mySound.play();
                DX=(DX*(-1));
            }
            // controlss the direction off the ball if is hitting the right wall
             if(isTouchingWalls(right)){
               mySound.play();
                 DX=(DX*(-1));
            }
            // controlss the direction off the ball if is hitting the lower wall
            if(isTouchingWalls(lower)){
                // to implement game Over World
           //GreenfootSound fail = new GreenfootSound("negative_beeps-6008.mp3");    
            //fail.play();
             //this.setImage(changeColor(width,height,Color.WHITE));
             //setLocation(300,100);
              //this.setImage(changeColor(width,height,Color.BLACK));
              //DX=0;
             // DY=3;
              Greenfoot.setWorld(new Loser());
            }
            setLocation(getX()+DX,getY()+DY);
        }
        
       
        
        private boolean isTouchingPaddle(Actor actor){
        return this.intersects(actor);
        }
        
        private boolean isTouchingWalls(Actor actor){
         return this.intersects(actor);
        }
        
        private List <Wall> getInFront(){
        return this.getObjectsInRange(20,Wall.class);
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
        
        
        private void changeDirectionRight(int pos){
            DX=speed;
          // if(pos>=0&&pos<=25){
            //    DX=+1;
            //  }
              if(pos>=25&&pos<=50){
                DX=+1;
                }
              if(pos>=50&&pos<=75){
                DX=+2;
                }
                  if(pos>=75&&pos<=100){
                DX=+3;
                }
        }
        
        private void changeDirectionLeft(int pos){
            DX=speed;
            // if(pos>=0&&pos<=25){
              //  DX=-1;
             // }
              if(pos>=25&&pos<=50){
                DX=-1;
                }
              if(pos>=50&&pos<=75){
                DX=-2;
                }
                  if(pos>=75&&pos<=100){
                DX=-3;
                }
        }
    }
