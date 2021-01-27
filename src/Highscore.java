import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


//import java.awt.Color;
import java.awt.Font;

/*
 * Highscore Actor: Displays the highscore in different ways according to State
 */
public class Highscore extends Actor
{
    private Board board=new Board();
    private String text ="Score: 0";
    private GreenfootImage image;

    /*
     * Constructor
     * @param int pScore highscore to be set
     * @param boolean gameOver whether game is over or not
     */
    public Highscore(int pScore, boolean gameOver) //Zeigt den Highscore in verschiedenen Größen an, je nach Spielstatus (Game Over oder nicht)
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
     * Print highscore as a greenfoot image
     * @param String pValue Value to be printed as a highscore
     * @param int pSize size of the greenfoot image according to state of the game
     */
    public void printText(String pValue,int pSize) //Setzt den Text asl Bild
    {
        setImage(new GreenfootImage(pValue, pSize, Color.WHITE,new Color(0,0,0,0)));
    }
}
