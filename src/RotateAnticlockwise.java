/**
 * RotateAnticlockwise class define starttegy to rotate fields block anti clockwise by 90 degree.
 * 
 * @author (Vaubhav Gupta) 
 * @version (04-29-2019)
 */
public class RotateAnticlockwise implements RotationStrategy
{
   
    /**
     * Constructor for objects of class RotateAntiClockwise
     */
    public RotateAnticlockwise()
    {
    }

    /**
     * @param  field parameter that to be rotated
     * @return  an array of Fields after rotation 
     */
      public Field[][] doRotation(Field[][] field)
     {
        final int M = field.length;
        final int N = field[0].length;
        Field[][] ret = new Field[N][M];
        for (int r = 0; r < M; r++) {
        for (int c = 0; c < N; c++) {
                ret[c][M-1-r] = field[r][c];
            }
        }
    return ret;
   }
    
}
