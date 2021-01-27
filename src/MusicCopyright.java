import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 * MusixcCopyright Actor: Get the music to played in background
 */
public class MusicCopyright extends Actor
{
    private String link= "http://newagemusic.guide/new-age-music-history/the-amazing-windows-xp-installation-songs/";
    
    /*
     * Act method of the greenfoot
     * On click play soundtrack of the game
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            ProcessBuilder pb = new ProcessBuilder();
            String[] cmd = { "cmd", "/C", "start", link };
            pb.command(cmd);
            Process p;
            try
            {
                p = pb.start();
            }
            catch (Exception e)
            {
            }
        }
    }    
}
