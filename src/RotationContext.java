/**
 * RotationContext class sets the context to select starttegy and perform appropriate rotation
 * 
 * @author (Vaubhav Gupta) 
 * @version (04-29-2019)
 */
public class RotationContext  
{
    // instance variables - for Strategy
   private RotationStrategy strategy;

   /**
     * Constructor for objects of class RotationContext
   */
   public RotationContext(RotationStrategy strategy){
      this.strategy = strategy;
   }

   /**
     * @param  field parameter that to be rotated
     * @return  an array of Fields after rotation 
   */
   public Field[][] executeStrategy(Field[][] field){
      return strategy.doRotation(field);
   }
}
