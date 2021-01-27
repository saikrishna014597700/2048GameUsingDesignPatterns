import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Score extends Actor
{
    private Board board=new Board();
    private String text ="Score: 0";
    private GreenfootImage image;
    public  int score;

    public Score(int pScore, boolean gameOver) //Zeigt Score in verschiedenen Gräßen an
    {
        if (gameOver)
        {
            text = "Your score: "+pScore;
            score = pScore;
            printText(text,50);
        }
        else
        {
             score = pScore;
            text = "Score: "+pScore;
            printText(text,30) ;
        }
    }

    public void printText(String pValue, int pSize) //Setzt Text als Bild
    {
        setImage(new GreenfootImage(pValue, pSize, Color.WHITE,new Color(0,0,0,0)));
    }
}
