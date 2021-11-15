import javakarol.Roboter;
import javakarol.Welt;

/**
 * Die Klasse RoboAufgabe
 */
public class RoboSteuerung extends Thread
{
    // Attribute
    private Roboter robo;
    private Signal signal;

    // Konstruktor
    public RoboSteuerung(Roboter robo_, Signal signal_)
    {
        robo = robo_;
        signal = signal_;
    }

    // Methoden
    // Roboter läuft bis zur Wand und denkt manchmal nach
    public void run()
    {
        tanzen();
    }

    public void tanzen()
    {
        while(true)
        {

            sehrVorsichtigerSchritt();
            robo.RechtsDrehen();
            robo.RechtsDrehen();
        }
    }

    public void vorsichtigerSchritt()
    {

        if(!robo.IstRoboter() && !robo.IstWand())
        {
            robo.Schritt();
        }
    }

    public void sehrVorsichtigerSchritt()
    {
        if(signal.testenUndSperren())
        {
            if(!robo.IstRoboter() && !robo.IstWand())
            {
                robo.Schritt();
            }
            signal.freigeben();
        }
    }
}
