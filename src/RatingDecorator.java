import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RatingDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RatingDecorator extends Actor implements IDecorator
{
    
    private IDecorator ra;
    /**
     * Act - do whatever the RatingDecorator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    public RatingDecorator(IDecorator r)
    {
        ra = r;
    }
    
    public void display() {
       ra.display();
    }
}
