import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameRunningState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePausedState extends GameState
   
    {
        public GamePausedState(Board b){
        super(b);
    }
    
    @Override
    public void resume() {
        board.setState("Resumed");
        System.out.println("Game resumed");
    }
}
