import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javafx.util.Pair;

public class LeftMove extends MoveSubject {

    
     public LeftMove(Field[][] field) {
        super(field);
    }

      @Override
     Pair<Integer,Boolean> moveDirection(Field[][] field, Integer score) {

        
        int x;
        int y;
        Boolean anyfieldMoved = false;

    for (x=1; x<field.length; x++) //Verschachtelte for-Schleife, um die jeweiligen Felder des Arrays zu bearbeiten
                {
                    for (y=0; y< field.length; y++)
                    {
                        for (int i=1; i<field.length; i++) //Noch eine for-Schleife, für den Fall dass ein Feld um mehrere Einheiten bewegt werden kann
                        {
                            if(field[i][y].getValue()!=0&&field[i-1][y].getMoved()==false&&field[i][y].getMoved()==false&&(field[i-1][y].getValue()==field[i][y].getValue()||field[i-1][y].getValue()==0))
                            {
                                if(field[i-1][y].getValue()!=0)
                                {
                                    score += (field[i][y].getValue()*2); //Fügt Punktzahl zum Score hinzu
                                    //field[i][y].setMoved(true);
                                    field[i-1][y].setMoved(true); //moved wird auf true gesetzt, damit keine Felder doppelt addiert werden
                                }
                                field[i-1][y].setValue(field[i][y].getValue()+field[i-1][y].getValue()); //Addiert Werte
                                field[i][y].setValue(0); //Setzt vorherigen Wert auf 0
                                anyfieldMoved=true; //Es wurden Felder bewegt

                            }
                        }
                    }
                }
    return new Pair(score,anyfieldMoved) ;
    }

}