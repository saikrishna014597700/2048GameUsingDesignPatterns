import greenfoot.*;

public class SoundCommand implements ICommand
{
    private Button soundButton;
    static boolean soundOn = true;
    private GreenfootImage soundOnImg= new GreenfootImage("soundOn.png");;
    private GreenfootImage soundOffImg= new GreenfootImage("soundOff.png");
    static GreenfootSound musicSound = new GreenfootSound("windowsXpInstallationMusic.mp3");
    
    //receives the parameter of the sound button
    public SoundCommand(Button receiver)
    {
        soundButton = receiver;
        
        soundOnImg.scale(40,40);
        soundOffImg.scale(40,40);
        try
            {
                musicSound.setVolume(70);
            }
            catch (Exception e)
            {
                System.err.print('\f');
                System.err.println("The sound can not be played. There may be a problem with the sound card (this is the case with the computers in the media library). Tip: leave the terminal open and minimize it, then you will not be disturbed by this message again.");
            }
    }
    
    public boolean execute() {
        if (!soundOn) {
            try
            {
                musicSound.playLoop();
            }
            catch (Exception e)
            {
                System.err.print('\f');
                System.err.println("The sound cannot be played. There may be a problem with the sound card (this is the case with the computers in the media library). Tip: leave the terminal open and minimize it, then you will not be disturbed by this message again.");
            }
            if (soundButton != null) soundButton.setImage(soundOnImg);
            soundOn = true ;
        } else if (soundOn) {
            try
            {
                musicSound.pause();
            }
            catch (Exception e)
            {
                System.err.print('\f');
                System.err.println("The sound cannot be played. There may be a problem with the sound card (this is the case with the computers in the media library). Tip: leave the terminal open and minimize it, then you will not be disturbed by this message again.");
            }
            if (soundButton != null) soundButton.setImage(soundOffImg);
            soundOn = false ;
        }
        return false;
    }
}
