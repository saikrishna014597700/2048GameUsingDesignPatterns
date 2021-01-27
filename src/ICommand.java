public interface ICommand  
{
    //return true if the command supports undo
    boolean execute();
   
}
