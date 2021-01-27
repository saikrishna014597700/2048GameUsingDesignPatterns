/**
 * RotationStrategy interface to define body for rotation strategies.
 * 
 * @author (Vaubhav Gupta) 
 * @version (04-29-2019)
 */
public interface RotationStrategy  
{
 
    /**
     * @param  field parameter that to be rotated
     * @return  an array of Fields after rotation 
     */
    public Field[][] doRotation(Field[][] field);
}


