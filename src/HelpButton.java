import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HelpButton extends Actor implements ICommandInvoker
{
    ICommand command;
    
    public HelpButton() //Setzt die Größe kleiner im Spiel
    {
        getImage().scale(40,40);
    }

    public void act()  //Funktioniert als Button und öffnet die Optionen/Credits
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
