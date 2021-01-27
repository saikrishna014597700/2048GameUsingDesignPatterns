/**
 * Write a description of class TwoNumberBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;  

public class Numbered32Block extends NumberedBlock
{
 
    /**
     * Constructor for objects of class Numbered2Block
     */
    public Numbered32Block() //Setzt Bild je nach übergebenem Parameter
    {
        setNumberImage(32);
    }       
     
    public void setScale(int pScale)
    {
        image.scale(pScale,pScale);
        setImage(image);
    }
    

    public void setNumberImage(int pNumber)
    {
        if(pNumber<=16384&&pNumber!=0) //Normale Zahl
        {
            image=new GreenfootImage(pNumber+".png");
            setImage(image);
        }
        else //Für Zahlen über 16384, weitere lassen sich einfach hinzufügen, "aber so weit kommt eh keiner" - I challenge you
        {
            image=new GreenfootImage("noImage.png");
            setImage(image);
        }
    }
  
   }
