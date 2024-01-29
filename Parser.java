import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasse Parser
 * @author Steven und Ingo
 * @version 24-01-22
 */
public class Parser
{
    // Attribute
    private String dateipfad;
    private int zeilenAnzahl;

    /**
     * Konstruktor der Klasse Parser
     * @throws java.io.IOException
     */
    public Parser()
    {
        dateipfad = System.getProperty("user.dir") + "/Vokabeln.txt";
        zeilenAnzahl = countRows();
    }
    
    /*
     * Klasse zum Erstellen eines Objektes der Klasse Vokabel
     * @return vokabel Objekt der Klasse Vokabel
     */
    public void textZuVokabel()
    {
        try
        {
            FileReader reader = new FileReader(dateipfad);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int linesToRead = (int)(Math.random() * zeilenAnzahl);
            for (int i = 0; i < linesToRead; i++)
            {
            	bufferedReader.readLine();
            }
            bufferedReader.close();
            return count;
        }
        catch (IOException e)
        {
        	printException(e);
        	return 0;
        }
    }
    
    /*
     * Methode zum Zählen der Zeilen
     * @return count Anzahl der Zeilen in der Datei (0 im Falle einer IOException)
     */
    public int countRows()
    {
        try
        {
            FileReader reader = new FileReader(dateipfad);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int count = 0;
            while (bufferedReader.readLine() != null)
            {
            	count += 1;
            }
            bufferedReader.close();
            return count;
        }
        catch (IOException e)
        {
        	printException(e);
        	return 0;
        }
    }
    
    /*
     * Hilfsfunktion zur Information über eine IOException
     * @param e Objekt der Klasse IOException
     */
    public void printException(IOException e)
    {
    	String name = e.getClass().toString().split(" ")[1];
    	String msg = String.format("ERROR: %s", name);
    	System.out.println(msg);

    }
     /*
      * Get-Methode für das Attribut dateipfad
      * @return dateipfad
      */
    public String getDateipfad()
    {
    	return dateipfad;
    }
    
    /*
     * Set-Methode für das Attribut dateipfad
     * @param pDateipfad
     */
    public void setDateipfad(String pDateipfad)
    {
    	dateipfad = pDateipfad;
    }
    
    /*
     * Get-Methode für das Attribut zeilenAnzahl
     * @return zeilenAnzahl
     */
    public int getZeilenAnzahl()
    {
    	return zeilenAnzahl;
    }
}
