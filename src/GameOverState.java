import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameRunningState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverState extends GameState 
{
  
    public GameOverState(Board b){
          super(b);
    }
    
    @Override
    public void restart() {
         board.setState("Restarted");
        System.out.println("Game restarted");
    }
    
    
}
