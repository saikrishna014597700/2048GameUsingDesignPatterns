/**
 * Write a description of class ArrowKeysPlayingOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrowKeysPlayingOption implements IPlayingOptions
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ArrowKeysPlayingOption
     */
    public ArrowKeysPlayingOption()
    {
    }

    public void Move()
    {
    }
    
    public String upKey()
    {
       return "up";
    }
    public String downKey()
    {
       return "down";
    }
    public String leftKey()
    {
      return "left";
    }
    public String rightKey()
    {
      return "right";
    }
}
