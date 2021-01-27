import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayButton extends Actor implements ICommandInvoker
{
    ICommand command;

    public PlayButton(boolean inGame) //Setzt die Größe kleiner im Spiel
    {
        if(inGame)
        {
            getImage().scale(240,120);
        }
    }
    
    public void act()  //Funktioniert als Button und startet ein neues Spiel
    {
       if (Greenfoot.mouseClicked(this))
        {
            executeCommand();
        }
    }
  
    public void setCommand(ICommand c) {
        command = c;
    }
    public void executeCommand() {
        if (command != null) {
            command.execute();
        }
    }
}
