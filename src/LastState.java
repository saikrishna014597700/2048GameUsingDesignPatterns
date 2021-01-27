import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LastState
{
    private int value; //Integer value wird deklariert | Nummer des Feldes
    private boolean moved; //Boolean wird deklariert | Feld wurde schon bewegt/addiert
    
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
    
}
