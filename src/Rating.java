import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rating extends Actor implements IDecorator
{
    /**
     * Act - do whatever the Rating wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void display() {
       setImage(new GreenfootImage("Rating is", 30, Color.RED,new Color(0,0,0,0)));
       getImage().scale(100, 40);
    }
}
