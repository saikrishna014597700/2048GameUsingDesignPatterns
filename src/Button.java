import greenfoot.*;

//Generic button class
public class Button extends Actor implements ICommandInvoker
{
    private ICommand command;
    
    //Constructer that sets the button image by default scale (40*40)
    public Button(GreenfootImage i)
    {
        if (i !=null) {
            setImage(i);
            getImage().scale(40, 40);
        }
    }

    //Constructer that sets the button image scale by arguments x and y
    public Button(GreenfootImage i, int x, int y)
    {
        if (i !=null) {
            setImage(i);
            getImage().scale(x, y);
        }
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)){
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
