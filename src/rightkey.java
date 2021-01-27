import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class rightkey extends Actor
{
     public Board board;
    public rightkey(boolean inGame) //Setzt die Größe kleiner im Spiel
    {
        if(inGame)
        {
            getImage().scale(40,40);
        }
    }
    
    public void act()  //Funktioniert als Button und startet ein neues Spiel
    {
       if (Greenfoot.mouseClicked(this))
        {
            board = (Board)getWorld().getObjects(Board.class).get(0);
            board.moveright();
        }
    }     
}
