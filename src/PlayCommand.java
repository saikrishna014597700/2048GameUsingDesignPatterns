import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayCommand implements ICommand
{

    public PlayCommand()
    {
    }

    public boolean execute(){
        Greenfoot.setWorld(new Game());
        return false;
    }
}
