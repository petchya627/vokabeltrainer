// Import
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
    private String dateiname;
    private int zeilenAnzahl;

    /**
     * Konstruktor der Klasse Parser
     */
    public Parser(String pDateiname)
    {
    	setDateiname(pDateiname);
        zeilenAnzahl = countRows();
    }
   
    
    /**
     * Methode zum Erstellen eines Objektes der Klasse Vokabel
     * @return vokabel Objekt der Klasse Vokabel
     */
    public Vokabel erstelleVokabel()
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
            String zeile = bufferedReader.readLine();
            if (dateiname.equals("EN-DE_Words_1.tsv"))
            {
            	try
            	{
	            	String[] array = zeile.split("\t");
	            	String wort = array[0].trim();
	            	String uebersetzung = filterInformationOfString(array[1])[0];
	            	String info;
	            	if (array.length >= 3)
	            	{
	            		info = array[2].trim();
		            	if (array.length >= 4)
		            	{
		            		info += " " + array[3];
		            	}
	            	}
	            	else
	            	{
	            		info = "";
	            	}
	            	Vokabel vokabel = new Vokabel(wort, uebersetzung, info);
	            	bufferedReader.close();
	            	return vokabel;            		
            	}
            	catch (Exception e)
            	{
            		printException(e);
            		erstelleVokabel();
            	}
            }
            bufferedReader.close();
        }
        catch (IOException e)
        {
        	printException(e);
        }
    	return new Vokabel("Wort", "Übersetzung", "Info");
    }
    
    /**
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
    
    /**
     * Hilfsfunktion zur Information über eine IOException
     * @param e Objekt der Klasse IOException
     */
    public void printException(Exception e)
    {
    	String name = e.getClass().toString().split(" ")[1];
    	String ausgabe = String.format("ERROR: %s", name);
    	System.out.println(ausgabe);

    }
    
    /**
     * Hilfsfunktion zum Filtern der Informationen aus dem String
     * @param pStr zu untersuchender String
     */
    public String[] filterInformationOfString(String pStr)
    {
    	String str = pStr;
    	List<String> liste = new List<String>();
    	String[] zeichen = new String[] {"[", "]", "{", "}", "(", ")", "<", ">"};
    	for (int i = 0; i < zeichen.length; i += 2)
    	{
        	if (str.indexOf(zeichen[i]) != -1)
        	{
        		int startindex = str.indexOf(zeichen[i]);
        		int endindex = str.indexOf(zeichen[i+1]) + 1;
        		liste.append(str.substring(startindex, endindex));
        		String str1 = str.substring(0, startindex).trim();
        		String str2 = str.substring(endindex, str.length()).trim();
        		str = str1 + " " + str2;
        	}
    	}
    	str = str.trim();
    	liste.toFirst();
    	liste.insert(str);
    	String[] rueckgabe = listToArray(liste);
    	return rueckgabe;
    }
    
    /**
     * Hilfsfunktion zum Konvertieren einer String-Liste zu einem String-Array
     * @param pListe zu konvertierende Liste
     * @return array konvertiertes Array
     */
    public String[] listToArray(List<String> pListe)
    {
    	pListe.toFirst();
    	int zaehler = 0;
    	while (pListe.hasAccess())
    	{
    		zaehler += 1;
    		pListe.next();
    	}
    	String[] array = new String[zaehler];
    	pListe.toFirst();
    	for (int i = 0; i < zaehler; i++)
    	{
    		array[i] = pListe.getContent();
    		pListe.next();
    	}
    	return array;
    }
    
    /**
     * Get-Methode für den Dateinamen
     * @return dateiname
     */
    public String getDateiname()
    {
    	return dateiname;
    }
    
    /**
     * Set-Methode für das Attribut dateiname
     * @param pDateiname zu verändernder Name der Datei
     */
    public void setDateiname(String pDateiname)
    {
    	dateiname = pDateiname;
    	dateipfad = System.getProperty("user.dir") + "\\data\\" + dateiname;
    }
    
     /**
      * Get-Methode für das Attribut dateipfad
      * @return dateipfad
      */
    public String getDateipfad()
    {
    	return dateipfad;
    }
    
    /**
     * Get-Methode für das Attribut zeilenAnzahl
     * @return zeilenAnzahl
     */
    public int getZeilenAnzahl()
    {
    	return zeilenAnzahl;
    }
}
