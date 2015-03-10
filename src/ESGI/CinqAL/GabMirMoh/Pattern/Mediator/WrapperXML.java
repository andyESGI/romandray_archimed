package ESGI.CinqAL.GabMirMoh.Pattern.Mediator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.xpath.XPathConstants;

import org.xml.sax.SAXException;

import ESGI.CinqAL.GabMirMoh.Function.*;
import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoSQL;


public class WrapperXML extends Wrapper implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrapperXML(IMediator mediator) 
	{
		this.mediator = mediator;
		this.mediator.fixeWrapperXML(this);
	}
	@Override
	public void fixeSource(String anURL) 
	{
		//String str_WrapperType,str_XPathRequeste, str_URL,str_XmlReturn ="" ;
		
		str_WrapperType = "XML"; 	
		str_URL =anURL;
		str_XPathRequeste =  this.mediator.getXpathRequest(); 

		try 
		{
			//File xml = new File(/*System.getProperty("user.dir")+"\\"+*/str_URL);
			str_XmlReturn = (String)analyzeXML.analyzeXML(str_URL,str_XPathRequeste,XPathConstants.STRING);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		this.mediator.interrogate(str_WrapperType,str_XmlReturn);
	}
	
	@Override
	public void fixeSource(DataInfoSQL aDataInfoSQL) 
	{
		// TODO Auto-generated method stub
		
	}
}