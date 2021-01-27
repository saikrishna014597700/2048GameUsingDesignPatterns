import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameRunningState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameRunningState extends GameState 
{
    
    
    public GameRunningState(Board b){
         super(b);
    }
    
    @Override
    public void pause(){
       board.setState("Paused");
    }
    
   
}
