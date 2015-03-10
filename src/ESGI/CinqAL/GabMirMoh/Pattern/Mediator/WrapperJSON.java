package ESGI.CinqAL.GabMirMoh.Pattern.Mediator;

import java.io.File;
import java.io.Serializable;

import org.json.XML;

import ESGI.CinqAL.GabMirMoh.Function.convJSonToXml;
import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoSQL;

public class WrapperJSON extends Wrapper implements Serializable
{ 	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrapperJSON(IMediator mediator) 
	{
		this.mediator = mediator;
		this.mediator.fixeWrapperJSON(this);
		
	}
	@Override
	public void fixeSource(String anURL) 
	{
		//String str_WrapperType,str_XPathRequeste, str_URL,str_XmlReturn ="" ;
		
		str_WrapperType = "JSON";	
		str_URL =anURL;
		str_XPathRequeste =  this.mediator.getXpathRequest(); 
									
		try 
		{
			str_XmlReturn = (String)convJSonToXml.convJSonToXml(str_URL,str_XPathRequeste);
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

//File o_jsonFile = new File(System.getProperty("user.dir")+"\\repertoire.xml");

//String xml = org.json.XML.toString(o_jsonFile);

//InputSource o_Srce = new InputSource(new FileInputStream(aFile)); 
	
//JSONObject o = new JSONObject("{'glossary': {'title': 'example glossary','GlossDiv': {'title': 'S','GlossList': {'GlossEntry': {'ID': 'SGML','SortAs': 'SGML','GlossTerm': 'Standard Generalized Markup Language','Acronym': 'SGML','Abbrev': 'ISO 8879:1986','GlossDef': {'para': 'A meta-markup language, used to create markup languages such as DocBook.',	'GlossSeeAlso': ['GML', 'XML']},'GlossSee': 'markup'}} } } }"); 

//String xml;


//try 
//{
//	//xml = org.json.XML.toString("{'glossary': {'title': 'example glossary','GlossDiv': {'title': 'S','GlossList': {'GlossEntry': {'ID': 'SGML','SortAs': 'SGML','GlossTerm': 'Standard Generalized Markup Language','Acronym': 'SGML','Abbrev': 'ISO 8879:1986','GlossDef': {'para': 'A meta-markup language, used to create markup languages such as DocBook.',	'GlossSeeAlso': ['GML', 'XML']},'GlossSee': 'markup'}} } } }");	
//	
//	//convJSonToXml.convJSonToXml("Test.json");

//	//xml = new File(System.getProperty("user.dir")+"\\repertoire.xml");
//	//analyzeXML.evaluerSAX(xml,"/repertoire/personne",XPathConstants.STRING);		
//} 
//catch (JSONException e) 
//{
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} 	
