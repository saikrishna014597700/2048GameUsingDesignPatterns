import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class upkey extends Actor
{
    public boolean key;
    public Board board; 
    public upkey(boolean inGame) //Setzt die Größe kleiner im Spiel
    {
      
        if(inGame)
        {
            getImage().scale(40,40);  
            key = false;         
        }
    }
    
    public void act()  //Funktioniert als Button und startet ein neues Spiel
    {
       if (Greenfoot.mouseClicked(this))
        {
            key = true;//Greenfoot.setWorld(new Game());
            board = (Board)getWorld().getObjects(Board.class).get(0);
            board.moveup();
            //board.notifyAll();
        }
    }     
}
