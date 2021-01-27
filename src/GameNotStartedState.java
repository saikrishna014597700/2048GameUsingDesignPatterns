import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameRunningState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameNotStartedState extends GameState 
{
   
    public GameNotStartedState(Board b){
         super(b);
    }
    
    @Override
    public void play(){
      board.setState("Playing");
    }
   
}
