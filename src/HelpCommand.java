import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HelpCommand implements ICommand
{
    public HelpCommand()
    {
    }

    public boolean execute() {
        Greenfoot.setWorld(new Options());
        return false;
    }
}
