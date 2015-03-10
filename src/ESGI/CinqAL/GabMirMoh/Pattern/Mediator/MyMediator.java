package ESGI.CinqAL.GabMirMoh.Pattern.Mediator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ESGI.CinqAL.GabMirMoh.Main.Simulation;


public class MyMediator implements IMediator,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//----------------------------------------------
	private Simulation graphicBoundSimulation; 
	//----------------------------------------------
	
	List<WrapperXML> List_WrapperXML ;
	List<WrapperJSON> List_WrapperJSON ;
	List<WrapperSQL> List_WrapperSQL ;

	protected String myXpathRequest;
	
	//WrapperXML interrogateXML;
	//WrapperJSON interrogateJSON;
	//WrapperSQL interrogateSQL;
	
	public MyMediator()
	{
		List_WrapperXML = new ArrayList<WrapperXML>();
		List_WrapperJSON = new ArrayList<WrapperJSON>();
		List_WrapperSQL = new ArrayList<WrapperSQL>();
	}
	
	public Simulation getGBSimulation()
	{
		return graphicBoundSimulation;
	}
	
	public void setGBSimulation(Simulation aSimulation)
	{
		graphicBoundSimulation = aSimulation;
	}
	
	public void setXpathRequest(String str_Request)
	{
		myXpathRequest = str_Request;
	}
	
	public String getXpathRequest()
	{
		return myXpathRequest;
	}
	
	public void fixeWrapperXML(WrapperXML aWrapperXML)
	{
		if(aWrapperXML!=null)
		List_WrapperXML.add(aWrapperXML);
		
		//interrogateXML = aWrapperXML;
		//interrogateJSON = null;
		//interrogateSQL = null;
		
	}
	public void fixeWrapperJSON(WrapperJSON aWrapperJSON)
	{
		if(aWrapperJSON!=null)
		List_WrapperJSON.add(aWrapperJSON);
		
		//interrogateXML = null;
		//interrogateJSON = aWrapperJSON;
		//interrogateSQL = null;
	}
	public void fixeWrapperSQL(WrapperSQL aWrapperSQL)
	{
		if(aWrapperSQL!=null)
		List_WrapperSQL.add(aWrapperSQL);
		
		//interrogateXML = null;
		//interrogateJSON = null;
		//interrogateSQL = aWrapperSQL;
	}
	
	
	public void  interrogate(String traductorLanguage , String xmlresult)
	{
		for(WrapperXML w: List_WrapperXML) 
		{
			if(List_WrapperXML != null)			
			{
				System.out.println("Mediator is interrogating " + traductorLanguage 
						+ " with Xpath : "+ w.str_XPathRequeste);	
			}	
		}
		for(WrapperJSON w: List_WrapperJSON) 
		{
			if(List_WrapperJSON != null)			
			{
				System.out.println("Mediator is interrogating " + traductorLanguage 
						+ " with Xpath : "+ w.str_XPathRequeste);	
			}	
		}
		for(WrapperSQL w: List_WrapperSQL) 
		{
			if(List_WrapperSQL != null)			
			{
				System.out.println("Mediator is interrogating " + traductorLanguage 
						+ " with Xpath : "+ w.str_XPathRequeste);	
			}	
		}
		
		/*if(interrogateXML != null)			
		{
			System.out.println("Mediator is interrogating " + traductorLanguage);	
		}	
		if(interrogateJSON != null)	
		{
			System.out.println("Mediator is interrogating " + traductorLanguage);
		}
		if(interrogateSQL != null)
		{
			System.out.println("Mediator is interrogating " + traductorLanguage);
		}*/
		
		readXMLResult(xmlresult);
		
		//return myXpathRequest;
	}
	
	private void readXMLResult(String aXml)
	{
		if(aXml==null)
			aXml =" nothing...\n";
		System.out.println("Mediator is reading " + aXml +"\n");		
		graphicBoundSimulation.str_GraphicResult = aXml;
		
	}
}