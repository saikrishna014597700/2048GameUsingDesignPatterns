import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * Logo Actor: Setting Logo of the game on the menu screen
 */
public class Logo extends Actor
{
    GreenfootImage image = getImage();  
    public Logo()
    {
        image.scale(200, 200);
        setImage(image);
    }
}
