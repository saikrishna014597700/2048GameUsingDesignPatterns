/**
 * Write a description of class NumberStore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.util.Map;
 
public class NumberStore   
{
    private static Map<String, NumberdButton> numberMap = new HashMap<String, NumberdButton>();  
       
    static 
    { 
        numberMap.put("FourNumberedButton", new FourNumberedButton()); 
        numberMap.put("TwoNumberedButton", new TwoNumberedButton()); 
    } 
       
    public static NumberdButton getNumber(String numberName) 
    { 
        return (NumberdButton) numberMap.get(numberName).clone(); 
    } 
}
