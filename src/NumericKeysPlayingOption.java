/**
 * Write a description of class NumericKeysPlayingOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumericKeysPlayingOption implements IPlayingOptions 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class NumericKeysPlayingOption
     */
    public NumericKeysPlayingOption()
    {
    }

   public void Move()
   {
   }
   
      public String upKey()
    {
       return "8";
    }
    public String downKey()
    {
       return "2";
    }
    public String leftKey()
    {
      return "4";
    }
    public String rightKey()
    {
      return "6";
    }
}
