import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoundButton extends  Actor 
{

    //Pauses / plays the music | there may be bugs with audio devices, hence the try commands
    
    static boolean soundOn=true;
    private GreenfootImage soundOnImage= new GreenfootImage("soundOn.png");;
    private GreenfootImage soundOffImage= new GreenfootImage("soundOff.png");
    static GreenfootSound xpMusic=new GreenfootSound("windowsXpInstallationMusic.mp3");
    
    // public SoundButton(GreenfootImage i)
    // {
        // super(i);
    // }
    public SoundButton(){ 
        soundOnImage.scale(40,40);
        soundOffImage.scale(40,40);
        try
            {
                xpMusic.setVolume(70);
            }
            catch (Exception e)
            {
                System.err.print('\f');
                System.err.println("The sound can not be played. There may be a problem with the sound card (this is the case with the computers in the media library). Tip: leave the terminal open and minimize it, then you will not be disturbed by this message again.");
            }
        
    }

    public void playIfSoundOn() //Play the music if soundOn = true
    {
        // if(soundOn) {
            // executeCommand();
        // }
        if(soundOn)
        {
            try
            {
                xpMusic.playLoop();
            }
            catch (Exception e)
            {
                System.err.print('\f');
                System.err.println("The sound can not be played. There may be a problem with the sound card (this is the case with the computers in the media library). Tip: if you leave the terminal open and minimize it, you will not be disturbed by this message again.");
            }
            soundOn = true;
        }
    }

    public void act() //Works as switch / flip flop and muted / starts the music
    {
        playIfSoundOn();
        //super.act();
        
        if (Greenfoot.mouseClicked(this))
        {
            if (soundOn)
            {
                try
                {
                    xpMusic.pause();
                }
                catch (Exception e)
                {
                    System.err.print('\f');
                    System.err.println("Der Sound kann nicht abgespielt werden. Möglicherweise gibt es ein Problem mit der Soundkarte (Ist bei den Rechnern in der Mediothek der Fall). Tipp: lassen Sie das Terminal offen und minimieren es, dann werden Sie nicht nochmal von dieser Meldung gestört.");
                }
                soundOn=false;
            }
            else if (!soundOn)
            {
                try
                {
                    xpMusic.playLoop();
                }
                catch (Exception e)
                {
                    System.err.print('\f');
                    System.err.println("Der Sound kann nicht abgespielt werden. Möglicherweise gibt es ein Problem mit der Soundkarte (Ist bei den Rechnern in der Mediothek der Fall). Tipp: lassen Sie das Terminal offen und minimieren es, dann werden Sie nicht nochmal von dieser Meldung gestört.");
                }
                soundOn=true;
            }
        }
        if (soundOn)
        {
            setImage(soundOnImage);
        }
        if (!soundOn)
        {
            setImage(soundOffImage);
        }
    }  
       
}
