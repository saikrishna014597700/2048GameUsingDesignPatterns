import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * How to Play Screen
 */
public class Options extends WorldMaster
{
    private SoundButton soundButton = new SoundButton();
    private Button exitButton = new Button(new GreenfootImage("exit.png"));
    private HowToPlay howToPlay = new HowToPlay();
    private MusicCopyright musicCopyright = new MusicCopyright();
    
    /*
     * Constructor
     */
    public Options() //Erstellt das aus Modulen bestehende Optionsmenü und startet das Spiel u. die Musik automatisch
    {    
        super(480, 600, 1); //Erstellt die Welt
        
        addObject(soundButton,420,540); //Fügt Objekte hinzu
        //soundButton.setCommand(new SoundCommand(soundButton));

        addObject(exitButton,60,540);
        exitButton.setCommand(new ExitCommand()); 

        addObject(howToPlay,240,180);
        addObject(musicCopyright,240,400);
        
        //soundButton.playIfSoundOn(); //Startet Musik
        Greenfoot.start(); //Startet Spiel automatisch
    }
    
}
