package ESGI.CinqAL.GabMirMoh.Function;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.JSONObject;
import org.xml.sax.InputSource;

public class convJSonToXml 
{	
	public static String getMyFile(File aFile) 
	{
	    try 
	    {
	       BufferedInputStream o_Bis = new BufferedInputStream(new FileInputStream(aFile));
	       StringWriter o_Sw = new StringWriter();
	       int i_carac;
	       while ((i_carac=o_Bis.read()) != -1)
	       {
	    	   o_Sw.write(i_carac);
	       }
	       o_Sw.flush();
	       o_Sw.close();
	       o_Bis.close();
	       
	       return o_Sw.toString();
	    }
	    catch (IOException ex_io)
	    {
	    	ex_io.printStackTrace(); 
	    } 
	    return null;
	}
	
	public static Object convJSonToXml(String aJsonFileName, String aXPathExpression) throws Exception 
	{
		String xml;
		
		if(!aJsonFileName.split("###")[0].toString().equals("NETWORK")) //ADRESS FROM JFILECHOOZER
		{
			String ContentJSon= getMyFile(new File(aJsonFileName));
			
			JSONObject jObj=new JSONObject(ContentJSon);
		
			xml = org.json.XML.toString(jObj); 
		
			//System.out.println("Test : \n"+xml+"\n");
			
		}
		else //URL NETWORK
		{				
			xml = networkJSonToXml(aJsonFileName.split("###")[1], aXPathExpression);	
		}
		
		File temp = null;
		try 
		{
			if(new File(System.getProperty("user.dir")+"\\tempo.xml").exists())
				new File(System.getProperty("user.dir")+"\\tempo.xml").delete();
			
			temp = new File(System.getProperty("user.dir")+"\\tempo.xml");
			//temp = File.createTempFile ("tempo",".tmp");
			
			FileWriter writer = new FileWriter("tempo.xml", false);
		    writer.write(xml);
		    
		    if(writer != null)
		        writer.close();
			
			InputSource o_Srce = new InputSource(new FileInputStream(temp));
			
			XPathFactory o_Factory = XPathFactory.newInstance(); 
			XPath o_XPath = o_Factory.newXPath(); 
			
			XPathExpression o_XPathExp = (XPathExpression) o_XPath.compile(aXPathExpression); 
			Object o_TheResult = o_XPathExp.evaluate(o_Srce,XPathConstants.STRING);
			
			//System.out.println("XML: " + o_TheResult);
			
			return o_TheResult;
		} 
		catch(XPathExpressionException xpe_ex)
		{ 
			xpe_ex.printStackTrace(); 
		}catch(IOException  io_ex)
		{ 
			io_ex.printStackTrace(); 
		} 
		finally 
		{
		    temp.delete();
		}		
		return null;
	}
	
	public static String networkJSonToXml(String aJsonFileName, String aXPathExpression) throws Exception 
	{
		String xml;
		
		InputStream o_IS= new URL(aJsonFileName/*aFile.toString()*/).openStream();
		
		try 
		{
		      BufferedReader o_BuffRead = new BufferedReader(new InputStreamReader(o_IS, Charset.forName("UTF-8")));
		      String str_JsonToText;
		      
		      StringBuilder o_StrBuilder = new StringBuilder();
		      int cp;
		      
		      while ((cp = o_BuffRead.read()) != -1) 
		      {
		    	  o_StrBuilder.append((char) cp);
		      }
		      str_JsonToText = o_StrBuilder.toString();
		      
		      JSONObject jObj = new JSONObject(str_JsonToText);
		      xml = org.json.XML.toString(jObj);
		      
		    //System.out.println("Test : \n"+xml+"\n");
		} 
		finally 
		{
			o_IS.close();
		}	
		return xml;
	}
}


//InputStream o_inStream   = convJSonToXml.class.getResourceAsStream(aJsonFileName/*"input.json"*/);
//OutputStream o_outStream = System.out;
//
//JsonXMLConfig o_JSXConf = new JsonXMLConfigBuilder().multiplePI(false).build();
//
//try 
//{ 	
//	 XMLStreamReader o_XmlSReader = new JsonXMLInputFactory(o_JSXConf).createXMLStreamReader(o_inStream);
//   Source o_Srce = new StAXSource(o_XmlSReader);
//
//   XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(o_outStream);
//   Result result = new StAXResult(new PrettyXMLStreamWriter(writer)); // format output
//
// TransformerFactory.newInstance().newTransformer().transform(o_Srce, result);
//     
//} 
//catch(Exception ex)
//{
//	ex.printStackTrace();
//}
//finally 
//{
	//o_inStream.close();
	//o_outStream.close();
	
//}