import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;


public abstract class MoveSubject
{
   
    private Field[][] field;
    private List<Observer> observers = new ArrayList<Observer>();
    private Integer score = new Integer(0);
    private HighscoreObserver highscoreObserver;
    private ScoreObserver scoreObserver ;
    //private LastState[][] lastState;
 

    public  MoveSubject (Field[][] field) {
        this.field = field;
          scoreObserver = new  ScoreObserver(this);
        highscoreObserver = new HighscoreObserver(this);
          
        this.attach(scoreObserver); 
        this.attach(highscoreObserver);    
    }


    abstract Pair<Integer,Boolean> moveDirection(Field[][] field,Integer score);

    public final boolean move() {
        
        
        Pair<Integer,Boolean> p =   moveDirection(field,score);
        score = p.getKey();
        
        updateScoreObservers();
        return p.getValue();

    }
    
    
    public void attach(Observer observer){
      observers.add(observer);      
    }

    public void updateScoreObservers(){
      for (Observer observer : observers) {
         observer.update(score);
      }
    } 



}
