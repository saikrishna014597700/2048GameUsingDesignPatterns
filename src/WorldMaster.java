import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

class WorldMaster extends World
{   
    Stack<ICommand> commandHistory = new Stack<>();
    
    public WorldMaster(int width, int height, int cellSize) //World-Objekte nur als Subklassen, macht weitere Konzepte und Ideen möglich
    {
        super(width, height, cellSize);
    }
    
    public void executeCommand(ICommand c) {
        if (c.execute()) {
            commandHistory.push(c);
        }
    }
}
