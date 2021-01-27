import java.io.*;

public class HighscoreObserver extends Observer{
    
   private static int currentHighScore;

   public HighscoreObserver(MoveSubject subject){
      this.subject = subject;
      currentHighScore = loadHighscore();
   }

   @Override
   public void update(int score) {
       
       score = ScoreObserver.getScore();
       
       if (score > currentHighScore)
       {
            currentHighScore=score;
            saveHighscore(score);
       }
   }
   
   public static int getHighScore() {
       return currentHighScore;
    }
    
       public void saveHighscore(int score) //Speichert highscore in highscore.txt
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("highscore.txt"));
            bw.write(score+"");
            bw.close();
        }
        catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
        }
    }
   


    public int loadHighscore() //Lädt highscore aus highscore.txt
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

