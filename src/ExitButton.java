import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * ExitButton Actor: When clicked navigate to Menu Screen  
 */
public class ExitButton extends Actor 
{
    /*
     * Constructor
     */
    public ExitButton()
    {
        getImage().scale(40,40);
    }
    
    /*
     * Act method of greenfoot, On click navigate to Menu Screen
     */
    public void act()
    {
       if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Menu());
        }
    } 
        
}
