import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javafx.util.Pair;

public class UpMove extends MoveSubject {
    
    
     public UpMove(Field[][] field) {
        super(field);
    }

     @Override
     Pair<Integer,Boolean> moveDirection(Field[][] field,Integer score) {

         Boolean anyfieldMoved = false;
        int x;
        int y;
        
        
  for (y=1; y< field.length; y++) //Verschachtelte for-Schleife, um die jeweiligen Felder des Arrays zu bearbeiten
                {
                    for (x=0; x< field.length; x++)
                    {
                        for (int i=1; i< field.length; i++) //Noch eine for-Schleife, für den Fall dass ein Feld um mehrere Einheiten bewegt werden kann
                        {
                            if (field[x][i].getValue()!=0&&field[x][i-1].getMoved()==false&&field[x][i].getMoved()==false&&(field[x][i-1].getValue()==field[x][i].getValue()||field[x][i-1].getValue()==0))
                            {
                                if(field[x][i-1].getValue()!=0)
                                {
                                    score += (field[x][i].getValue()*2); //Fügt Punktzahl zum Score hinzu
                                    //field[x][i].setMoved(true);
                                    field[x][i-1].setMoved(true); //moved wird auf true gesetzt, damit keine Felder doppelt addiert werden
                                }
                                field[x][i-1].setValue(field[x][i].getValue()+field[x][i-1].getValue()); //Addiert Werte
                                field[x][i].setValue(0); //Setzt vorherigen Wert auf 0
                                anyfieldMoved=true; //Es wurden Felder bewegt

                            }
                        }
                    }
                }
    return new Pair(score,anyfieldMoved) ;
    }

}