import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState implements IGameState
{
    Board board;
    public GameState(Board b){
        board = b ;
    }
   
    public void restart() {
        //default implementation
    }
    
    public void play(){
         //default implementation
    }
    
    public void pause(){
         //default implementation
    }
    
    public void resume() {
         //default implementation
    }
}

