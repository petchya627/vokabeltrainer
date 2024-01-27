
/**
 * Beschreiben Sie hier die Klasse Vokabel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Vokabel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String englisch;
    private String deutsch;
    private boolean gewusst;

    /**
     * Konstruktor für Objekte der Klasse Vokabel
     */
    public Vokabel(String pDeutsch,String pEnglisch,boolean pGewusst)
    {
        deutsch  = pDeutsch;
        englisch = pEnglisch;
        gewusst = pGewusst;
        
    }
    public void setGewusst(boolean pGewusst)
    {
        pGewusst = gewusst;
    }
    public String getEnglisch()
    {
        return englisch;
    }
     public String getDeutsch()
    {
        return deutsch;
    }
     public boolean getGewusst()
    {
        return gewusst;
    }
}
