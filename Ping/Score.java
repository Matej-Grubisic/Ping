import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int value;
    private boolean updateValue;
    private final Label name =  new Label ("Score: ",30);
    private Label labelValue;
         
    public Score (){
    Label value = new Label("",30);
    this.labelValue=value;
    }
    
    public void act()
    {
     if(updateValue){
        changeValue();
        updateValue=false;
        }
    }
    
    public int getValue(){
    return this.value;
    };
    
    public void setValue(int value){
    this.value+=value;
    this.updateValue=true;
    }
    private void changeValue(){
    this.labelValue.setValue(this.value);
    } 
    public Label getName(){
    return this.name;
    }
    public Label getValueLabel(){
        return this.labelValue;
    }
}
