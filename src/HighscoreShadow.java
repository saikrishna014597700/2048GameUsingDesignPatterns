import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


//import java.awt.Color;
import java.awt.Font;

/*
 * HighscoreShadow Actor: Shadow of the highscore
 */
public class HighscoreShadow extends Actor
{
    
    private Board board=new Board();
    private String text ="Score: 0";
    private GreenfootImage image;

    /*
     * Constructor
     * @param int pScore current highscore
     * @param boolean gameOver whether game is over or not
     */
    public HighscoreShadow(int pScore, boolean gameOver)
    {
        text = "Highscore: "+pScore;
        if (gameOver)
        {
            printText(text,50);
        }
        else
        {
            printText(text,30);
        }
    }

    /*
     * Print highscoreshadow as a greenfoot image
     * @param String pValue Value to be printed as a highscore
     * @param int pSize size of the greenfoot image according to state of the game
     */
    public void printText(String pValue,int pSize)
    {
        setImage(new GreenfootImage(pValue, pSize,new Color(0,0,0,120),new Color(0,0,0,0)));
    }
}
