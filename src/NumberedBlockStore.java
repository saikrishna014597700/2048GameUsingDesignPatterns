/**
 * Write a description of class NumberedBlockStore here. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;

public class NumberedBlockStore  
{
 private static Map<String, NumberedBlock> NumberedBlockMap = new HashMap<String, NumberedBlock>();  
       
    static 
    { 
        NumberedBlockMap.put("NumberedBlock2", new Numbered2Block()); 
        NumberedBlockMap.put("NumberedBlock4", new Numbered4Block()); 
        NumberedBlockMap.put("NumberedBlock8", new Numbered8Block()); 
        NumberedBlockMap.put("NumberedBlock16", new Numbered16Block()); 
        NumberedBlockMap.put("NumberedBlock32", new Numbered32Block()); 
        NumberedBlockMap.put("NumberedBlock64", new Numbered64Block()); 
        NumberedBlockMap.put("NumberedBlock128", new Numbered128Block()); 
        NumberedBlockMap.put("NumberedBlock256", new Numbered8Block()); 
        NumberedBlockMap.put("NumberedBlock512", new Numbered8Block()); 
        NumberedBlockMap.put("NumberedBlock1024", new Numbered8Block()); 
        NumberedBlockMap.put("NumberedBlock2048", new Numbered8Block()); 
        NumberedBlockMap.put("NumberedBlock4096", new Numbered8Block()); 
	NumberedBlockMap.put("NumberedBlock8192", new Numbered8Block());
    } 
       
    public static NumberedBlock getNumberedBlock(String colorName) 
    { 
        return (NumberedBlock) NumberedBlockMap.get(colorName).clone(); 
    } 
}
