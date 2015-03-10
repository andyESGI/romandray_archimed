package ESGI.CinqAL.GabMirMoh.InfoData;

import java.io.Serializable;

public class DataInfoXML implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String AbsolutePath;
	
	public DataInfoXML(String anAbsolutePath) 
	{
		AbsolutePath = anAbsolutePath;
		
		System.out.println("\nDataSrc XML crée. Chemin: " + AbsolutePath +"\n");
	}

}
