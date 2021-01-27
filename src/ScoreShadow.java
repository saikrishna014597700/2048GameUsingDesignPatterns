import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ScoreShadow extends Actor
{
    //Eigentlich das gleiche wie Score, nur in dunkel | dient als Schatten, um in das Spieldesign zu passen
    
    private Board board=new Board();
    private String text ="Score: 0";
    private GreenfootImage image;
    
    public ScoreShadow(int pScore, boolean gameOver)
    {
        if (gameOver)
        {
            text = "Your score: "+pScore;
            printText(text,50);
        }
        else
        {
            text = "Score: "+pScore;
            printText(text,30);
        }
    }

    public void printText(String pValue, int pSize)
    {
        setImage(new GreenfootImage(pValue, pSize, new Color(0,0,0,120),new Color(0,0,0,0)));
    }
}

