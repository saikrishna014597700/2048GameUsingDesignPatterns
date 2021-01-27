public class ScoreObserver extends Observer{
    
   private static int currentScore = 0;

   public ScoreObserver(MoveSubject subject){
      this.subject = subject;
   }

   @Override
   public void update(int score) {
       currentScore += score;
   }
   
   public static int getScore() {
       return currentScore;
    }
    
    public static void setScore(int score) {
       currentScore = score;
    }
    
    public static void resetScore()  {
        currentScore = 0;
    }
}
