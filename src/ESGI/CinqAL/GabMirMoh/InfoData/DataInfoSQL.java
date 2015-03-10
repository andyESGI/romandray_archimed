package ESGI.CinqAL.GabMirMoh.InfoData;

import java.io.Serializable;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DataInfoSQL implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String str_aPasswd ="";
	public String str_Login="";	
	public String str_DataBase="";
    public String str_URL="";
    public String str_Driver="";	
    
	public String str_Request="";
	
	public DataInfoSQL(String aPasswd, String aLogin,String aDataBase,String anURL,String aDriver) 
	{
		str_aPasswd= aPasswd;;
		str_Login = aLogin;	
		str_DataBase = aDataBase;
	    str_URL= anURL;
	    str_Driver = aDriver;
	    
	    //Test
		System.out.println("\nDataSrc SQL crée. Info: \n" + str_aPasswd 
				+"\n"+aLogin+"\n"
				+"\n"+aDataBase+"\n"
				+"\n"+anURL+"\n"
				+"\n"+aDriver +"\n");
	}

}
