package ESGI.CinqAL.GabMirMoh.Pattern.Mediator;

import java.io.File;
import java.io.Serializable;

import javax.xml.xpath.XPathConstants;

import ESGI.CinqAL.GabMirMoh.Function.analyzeXML;
import ESGI.CinqAL.GabMirMoh.Function.convSQLToXml;
import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoSQL;


public class WrapperSQL extends Wrapper implements Serializable
{
	//String str_WrapperType,str_XPathRequeste, str_URL,str_XmlReturn ; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrapperSQL(IMediator mediator) 
	{
		this.mediator = mediator;
		this.mediator.fixeWrapperSQL(this);
	}
	@Override
	public void fixeSource(String anURL) 
	{
		// TODO Auto-generated method stub
	}
	
	@Override
	public void fixeSource(DataInfoSQL aDataInfoSQL) 
	{
		str_WrapperType="SQL";
		
		String str_aPasswd	= aDataInfoSQL.str_aPasswd;
		String str_Login 	= aDataInfoSQL.str_Login ;	
		String str_DataBase = aDataInfoSQL.str_DataBase;
	    String str_Driver 	= aDataInfoSQL.str_Driver;
		
		str_URL =aDataInfoSQL.str_URL;
		str_XPathRequeste =  this.mediator.getXpathRequest();

		try 
		{
			str_XmlReturn = convSQLToXml.convSQLToXml(str_aPasswd,str_Login, str_DataBase,str_URL,str_Driver,str_XPathRequeste); 
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		this.mediator.interrogate(str_WrapperType,str_XmlReturn);
	}	
}