import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/*
 * Menu Screen
 */
public class Menu extends WorldMaster
{
    private Logo logo = new Logo();
    private Button playButton = new Button(new GreenfootImage("play.png"), 480, 240);
    private Button helpButton = new Button(new GreenfootImage("about.png"));
    private SoundButton soundButton = new SoundButton();
    private MenuBackground menuBackground= new MenuBackground();
    private Highscore highScoreActor;
    private HighscoreShadow highScoreShadowActor;

    /*
     * Constructor
     */
    public Menu() //Erstellt das aus Modulen bestehende Menü und startet das Spiel u. die Musik automatisch
    {    
        super(480, 600, 1); //Erstellt Welt
        
        addObject(menuBackground,240,360); //Fügt Objekte hinzu
        addObject(logo, 240, 120);
        addObject(playButton, 240, 400);
        playButton.setCommand(new PlayCommand());
        
        addObject(soundButton,420,540);
        //soundButton.setCommand(new SoundCommand(soundButton));
        
        addObject(helpButton,60,540);
        helpButton.setCommand(new HelpCommand());
        
        highScoreShadowActor = new HighscoreShadow(loadHighscore(),false); //Highscore mit Schatten
        addObject(highScoreShadowActor,242,542);
        highScoreActor = new Highscore(loadHighscore(),false);
        addObject(highScoreActor,240,540);
        
        //soundButton.playIfSoundOn(); //Spielt Musik
        Greenfoot.start(); //Startet
    }

    /*
     * Load high score from txt file
     * @return int highscore from text file
     */
    public int loadHighscore() //Lädt den highscore aus highscore.txt
    {
        int readHighscore = 0;
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("highscore.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            String stringHighscore = r.readLine();
            r.close();
            if(stringHighscore!="")
            {
                readHighscore = Integer.parseInt(stringHighscore);
            }
        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
        }
        return readHighscore;
    }
}
