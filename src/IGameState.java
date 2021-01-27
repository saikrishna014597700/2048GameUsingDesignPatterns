import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IGameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IGameState 
{
    void restart();
    
    void play();
    
    void pause();
    
    void resume();
}
