import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class NumberedBlock extends Actor implements Cloneable 
{
    //Jedes visuell dargestellte Feld ist ein Number-Objekt | Field-Objekte beziehen sich nur auf die Spiellogik, ist flexibler
    
    protected int imageNumber=0; 
    protected GreenfootImage image;
    
  
    abstract void setNumberImage(int pNumber);
    abstract void setScale(int pScale);
     
   
     public Object clone() {
      Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }
}
