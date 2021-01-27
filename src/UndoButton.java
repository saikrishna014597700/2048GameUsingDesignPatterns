import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class UndoButton extends Actor
{
    Board board = new Board();
    
    public UndoButton(boolean inGame) //Setzt die Größe kleiner im Spiel
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
           getWorld().getObjects(Board.class).get(0).undo();
           //Greenfoot.setWorld();
       }
    }    
}
