/**
 * Klasse zum Speichern einer Vokabel
 * 
 * @author Nick, Justus, Steven, Ingo
 * @version 24-01-22
 */

public class Vokabel
{
    // Instanzvariablen
    private String wort;
    private String uebersetzung;
    private String info;

    /**
     * Konstruktor für Objekte der Klasse Vokabel
     */
    public Vokabel(String pWort, String pUebersetzung, String pInfo)
    {
        wort = pWort;
        uebersetzung = pUebersetzung;
        info = pInfo;
    }

    /**
     * Get-Methode für das Attribut wort
     * @return wort der Wortteil der Vokabel
     */
    public String getWort()
    {
        return wort;
    }
    
    /**
     * Get-Methode für das Attribut uebersetzung
     * @return uebersetzung der Uebersetzungsteil der Vokabel
     */
    public String getUebersetzung()
    {
        return uebersetzung;
    }
    
    /**
     * Get-Methode für das Attribut info
     * @return info Informationen zur Vokabel
     */
    public String getInfo()
    {
    	return info;
    }
}
