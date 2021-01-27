import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * GameOverOvelay Actor The Transparent overlay after the game is over
 */
public class GameOverOverlay extends Actor
{
    /*
     * Constructor
     * @param int pTransparency
     */
    public GameOverOverlay(int pTransparency)
    {
        getImage().setTransparency(pTransparency);
    }
}
