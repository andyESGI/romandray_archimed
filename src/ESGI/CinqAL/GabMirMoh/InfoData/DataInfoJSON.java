package ESGI.CinqAL.GabMirMoh.InfoData;

import java.io.Serializable;

public class DataInfoJSON implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String AbsolutePath;
	
	public DataInfoJSON(String anAbsolutePath) 
	{
		AbsolutePath = anAbsolutePath;
		
		System.out.println("\nDataSrc JSON crée. Chemin: " + AbsolutePath +"\n");
	}
}
