/**
 * Import der Klasse java.nio.file.Files
 */
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.List;

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
    private Vokabel vokabeln;

    public Parser() // (String pDateipfad)
    {
        // dateipfad = pDateipfad;
        dateipfad = "G:\\2024-Q1-IF-GK1\\Austausch\\Ingo Steven Nick Justus Vokabeltrainer\\vokabelliste,In,St,Ni,Ju-copy\\Vokabeln.txt";
    }
    
    public List<String> einlesen()
    {
        List<String> zeilen;
        try
        {
            zeilen = Files.readAllLines(Path.of(dateipfad), UTF_8);
            return zeilen;
        }
        catch (IOException e)
        {
            System.out.println("Error: Textdatei nicht gefunden");
        }
        finally
        {
            return zeilen;
        }
    }
    
    public Vokabel[] textZuVokabeln()
    {
        List<String> zeilen = einlesen();
        for (String zeile : zeilen)
        {
            
        }
    }
}
