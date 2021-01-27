import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighRatingDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighRatingDecorator extends RatingDecorator
{
    /**
     * Act - do whatever the HighRatingDecorator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    public HighRatingDecorator(IDecorator r)
    {
        super(r);
    }
    
    public void display() {
        super.display();
        getImage().scale(40, 40);
    }
}
