/**
 * Write a description of class NumberdButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberdButton implements Cloneable
{
    // instance variables - replace the example below with your own
    protected String type;
    protected int value; //Integer value wird deklariert | Nummer des Feldes
    private boolean moved; //Boolean wird deklariert | Feld wurde schon bewegt/addiert
    
    /**
     * Constructor for objects of class NumberdButton
     */
    public NumberdButton()
    {
    }
    
   //abstract void setButtonValue(); 

   public String getType(){
      return type;
   }
   
   public int getValue() //Getter wegen private
    {
        return value;
    }
    
    public void setValue(int pValue) //Setter wegen private
    {
        value=pValue;
    }
    
    public boolean getMoved() //Getter wegen private
    {
        return moved;
    }
    
    public void setMoved(boolean pMoved) //Setter wegen private
    {
        moved=pMoved;
    }
   
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
