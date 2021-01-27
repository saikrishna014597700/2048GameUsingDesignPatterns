import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/*
 * Game Screen Class
 */
public class Game extends WorldMaster{
    
    private int width;
    private int height;
    private Board board = new Board();
    private Number number;
    private SoundButton soundButton = new SoundButton();
    private Button exitButton = new Button(new GreenfootImage("exit.png"));
    private UndoButton undoButton = new UndoButton(true);
    private PauseButton pauseButton = new PauseButton(board);
    
    /*
     * Constructor
     */
    public Game() //Create the world and start the game automatically
    {    
       super(480, 600, 1); //Creates the world (480 * 600, since each field is 120 * 120 large + 1 row for score etc. | a 4 * 5 world would work too, but the "small scaling" will not align the objects so well)
        
        ScoreObserver.resetScore();
        addObject(board, 60, 540);
        addObject(soundButton,100,560);
        addObject(exitButton,30,510);
        exitButton.setCommand(new ExitCommand()); 
        
        addObject(undoButton,30,560); 
        addObject(pauseButton, 100, 510);
        
        Greenfoot.start(); //Starts game automatically
    }

    
}
