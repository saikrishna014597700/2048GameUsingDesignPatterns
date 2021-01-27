import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Field extends Actor
{
    private int value; 
    private boolean moved; 
    
    /*
     * Get the value of the field
     * @return int value of the field
     */
    public int getValue()
    {
        return value;
    }
    
    /*
     * Set the value of the field
     * @param int pValue value to be set for the field
     */
    public void setValue(int pValue)
    {
        value=pValue;
    }

    /*
     * Check whether the field is moved or not
     * @return boolean whether moved or not
     */
    public boolean getMoved()
    {
        return moved;
    }
    
    /*
     * Set moved true or false to field
     * @param boolean pMoved moved or not
     */
    public void setMoved(boolean pMoved)

    {
        moved=pMoved;
    }
    
    /*
     * Set random value from 2 or 4 to the field
     */
    public void setRandomInitialValue()
    {
        int fourOrTwo = Greenfoot.getRandomNumber(2);
        if (fourOrTwo==1)
        {
            value=2;
        }
        else
        {
            value=4;
        }
    }
}
