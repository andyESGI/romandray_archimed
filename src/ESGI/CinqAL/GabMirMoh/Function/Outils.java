package ESGI.CinqAL.GabMirMoh.Function;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Outils 
{
	public static boolean isValidURL(String str_URL) 
	{
        URL o_URL = null;
        try 
        {
        	o_URL = new URL(str_URL);
        } 
        catch (MalformedURLException mURL_ex) 
        {
            return false;
        }
        try 
        {
        	o_URL.toURI();
        } 
        catch (URISyntaxException URIs_ex) 
        {
            return false;
        }
        return true;
    }
}
