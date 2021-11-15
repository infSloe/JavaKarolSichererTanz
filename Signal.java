

public class Signal
{
    boolean istFrei;
   
    public Signal()
    {
        istFrei = true;
    }

    public synchronized boolean testenUndSperren()
    {
        if(istFrei)
        {
            istFrei = false;
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public synchronized void freigeben()
    {
        istFrei = true;
    }
}
