import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasse Parser
 * 
 * @author Steven und Ingo
 * @version 24-01-22
 */
public class Parser
{
    // Attribute
    private String dateipfad;
    private FileReader reader;
    private BufferedReader bufferedReader;

    /**
     * Konstruktor der Klasse Parser
     */
    public Parser()
    {
        dateipfad = "G:\\2024-Q1-IF-GK1\\Austausch\\Vokabeltrainer_Steven_Nick_Justus_Steven_Ingo\\Vokabeln.txt";
        try
        {
            reader = new FileReader(dateipfad);
            bufferedReader = new BufferedReader(reader);
        }
        catch (IOException e)
        {
        	System.out.println("Error: Dateien nicht gefunden!");
        }
    }
    
    /*
     * Klasse zum Erstellen eines Objektes der Klasse Vokabel
     * @return vokabel Objekt der Klasse Vokabel
     */
    public void textZuVokabel()
    {
    	
    }
}
