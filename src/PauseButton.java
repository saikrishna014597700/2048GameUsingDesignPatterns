import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PauseButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseButton extends Actor
{
    
    Board b;
    
   private boolean pause;
   private GreenfootImage playButton= new GreenfootImage("playButton.png");
   private GreenfootImage pauseImg= new GreenfootImage("pause.jpeg");
    
    /**
     * Act - do whatever the PauseButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public PauseButton(Board board)
    {
        playButton.scale(40,40);
        pauseImg.scale(40,40);
        setImage(pauseImg);
        getImage().scale(40,40);
        this.b = board;
        pause = false;
    }
    
    public void act()  //Works as a button and goes back to the menu
    {
       if (Greenfoot.mouseClicked(this))
        {
            pause = !pause;
           if (pause)
        {
            setImage(playButton);
            b.setState("Paused");
        }
        if (!pause)
        {
            setImage(pauseImg);
            b.setState("Resumed");
        }
        
        }
    } 
    
}
