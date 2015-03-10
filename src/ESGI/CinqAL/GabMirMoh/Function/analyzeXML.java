package ESGI.CinqAL.GabMirMoh.Function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;


public class analyzeXML
{
	
	public static Object analyzeXML(String aFile, String aXPathRequeste, QName aReturnType)
	{ 
		try
		{  
			
			XPathFactory o_Factory = XPathFactory.newInstance(); 
			XPath o_XPath = o_Factory.newXPath(); 

			XPathExpression o_XPathExp = (XPathExpression) o_XPath.compile(aXPathRequeste);
			Object o_TheResult;
			
			//System.out.println("ANDYYYY TESTT: if XML URL: " + aFile.split("###")[0]+"\n");	
			System.out.println(aFile.split("###")[0]+"\n");
			
			if(!aFile.split("###")[0].toString().equals("NETWORK")) //ADRESS FROM JFILECHOOZER
			{
				File xml = new File(/*System.getProperty("user.dir")+"\\"+*/aFile);
				FileInputStream o_FileIS;
				o_FileIS = new FileInputStream(xml);
				InputSource o_Srce = new InputSource(o_FileIS);
				o_TheResult = o_XPathExp.evaluate(o_Srce,aReturnType);		
			}
			else //URL NETWORK
			{				
				String str_URL=aFile.split("###")[1];
				System.out.println("XML URL:" + str_URL.toString());
				
				InputStream o_IS;	
				o_IS = new URL(str_URL/*aFile.toString()*/).openStream();
				InputSource o_Srce = new InputSource(o_IS); 
				
				if(o_IS==null)
					System.out.println("o_IS: 1 we got a Pb doc");
				if(o_Srce==null)
					System.out.println("o_Srce :2 we got a Pb doc");
				
				o_TheResult = o_XPathExp.evaluate(o_Srce,aReturnType);
				System.out.println("XML:" + o_Srce.toString());
			}
			
			System.out.println("XML:" + o_TheResult); 
					
			return o_TheResult;
		}
		catch(XPathExpressionException xpe_ex)
		{ 
			xpe_ex.printStackTrace(); 
		}
		catch(IOException  io_ex)
		{ 
			io_ex.printStackTrace(); 
		} 
		return null;
	}
}

/*NodeList myNodeList = (NodeList) o_XPath.compile(aXPathRequeste).evaluate(o_Srce, XPathConstants.NODESET);

for (int i = 0; i < myNodeList.getLength(); i++) 
{
  System.out.println(myNodeList.item(i).getFirstChild().getNodeValue()); 
  System.out.println(myNodeList.item(i).getNodeValue());
}*/