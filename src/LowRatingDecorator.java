import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LowRatingDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LowRatingDecorator extends RatingDecorator
{
    /**
     * Act - do whatever the LowRatingDecorator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public LowRatingDecorator(IDecorator r)
    {
        super(r);
    }
    
    public void display() {
        super.display();
        getImage().scale(40, 40);
    }
}
