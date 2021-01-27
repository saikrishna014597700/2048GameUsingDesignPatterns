import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExitCommand implements ICommand
{
    /**
     * Constructor for objects of class ExitCommand
     */
    public ExitCommand()
    {
    }
    
    public boolean execute(){
        Greenfoot.setWorld(new Menu());
        return false;
    }
}
