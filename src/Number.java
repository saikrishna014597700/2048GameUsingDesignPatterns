import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * Number Actor: Setting image according to be number on the field
 */
public class Number extends Actor
{
    
    private int imageNumber=0;
    private GreenfootImage image;
    
    /*
     * Constructor
     * @param int pNumber Value of the number
     * @param int pScale Size of the Number Image
     */
    public Number(int pNumber, int pScale)
    {
        setNumberImage(pNumber);
        setScale(pScale);
    }
    
    /*
     * set Image of the number according to the value of the field
     * @param int pNumber value 
     */
    public void setNumberImage(int pNumber)
    {
        if(pNumber<=16384&&pNumber!=0)
        {
            image=new GreenfootImage(pNumber+".png");
            setImage(image);
        }
        else
        {
            image=new GreenfootImage("noImage.png");
            setImage(image);
        }
    }
    
    /*
     * set image with the specific size
     * @param int pScale Size of the Number Image
     */
    public void setScale(int pScale)
    {
        image.scale(pScale,pScale);
        setImage(image);
    }
}
