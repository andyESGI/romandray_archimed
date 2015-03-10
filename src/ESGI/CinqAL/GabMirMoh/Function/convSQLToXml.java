package ESGI.CinqAL.GabMirMoh.Function;

import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ESGI.CinqAL.GabMirMoh.DAL.Connection.FakeSglConnec;

import com.mysql.jdbc.ResultSetMetaData;

public class convSQLToXml 
{

	public static String convSQLToXml(String aPass, String aLogin, String aDataBase, String aURL, String aDriver, String aRequest)
	{	
		String xml = null;
		
		FakeSglConnec Sconn = new FakeSglConnec();		
		Sconn.getFsglConnec(aPass, aLogin, aDataBase, aURL,aDriver);
		
		String str_Tempo = null;
		String[] tableSQL;
		int nbTabAndOneField;
		
		if(aRequest.endsWith("]") || aRequest.contains("[")|| aRequest.contains("]"))
		{
			// Find a way to treate condition...
			str_Tempo= "";
		}
		else
		{	
			if(aRequest.startsWith("//"))
			{
				str_Tempo = aRequest.substring(2);
				tableSQL = str_Tempo.split("/");
				nbTabAndOneField = tableSQL.length;
				
				if(nbTabAndOneField==1)
					str_Tempo = "Select * from "+tableSQL[0]+";";
					
				if(nbTabAndOneField>1)
					str_Tempo = "Select "+tableSQL[nbTabAndOneField-1]+" from "+tableSQL[0]+";";
			}
			else if(aRequest.startsWith("/"))
			{
				str_Tempo = aRequest.substring(1);
				tableSQL = str_Tempo.split("/");
				nbTabAndOneField = tableSQL.length;
				
				if(nbTabAndOneField==1)
					str_Tempo = "Select * from "+tableSQL[0]+";";
				
				if(nbTabAndOneField>1)
					str_Tempo = "Select "+tableSQL[nbTabAndOneField-1]+" from "+tableSQL[0]+";";
				
				/*for(int i=0; i<nbTabAndOneField-1;i++)
				{
					str_Tempo += "Select * from "+tableSQL[i]+" ";
					if(i<nbTabAndOneField)
						str_Tempo +=",";	
				}*/
			}
		}
		
		DocumentBuilderFactory o_Factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder o_Builder = null;
		try 
		{
			o_Builder = o_Factory.newDocumentBuilder();
		} 
		catch (ParserConfigurationException pc_ex) 
		{
			pc_ex.printStackTrace();
		}
	    org.w3c.dom.Document doc = o_Builder.newDocument();
	    org.w3c.dom.Element o_Results = doc.createElement("MyResults");
	    doc.appendChild(o_Results);
	    
	    
		//--------------------ExecQuery------------------------------------------------------------
	    ResultSet o_rs = null;
	    try 
		{
			o_rs = Sconn.query(str_Tempo);
		} 
		catch (SQLException sql_ex) 
		{
			sql_ex.printStackTrace();
		}		
		//--------------------ExecQuery------------------------------------------------------------
		
	    try
	    {
			ResultSetMetaData o_Rsmd = (ResultSetMetaData) o_rs.getMetaData();
		    int colomnNumber = o_Rsmd.getColumnCount();
	
		    while (o_rs.next()) 
		    {
		      Element row = (Element) doc.createElement("Row");
		      o_Results.appendChild((Node) row);
		      
		      for (int i = 1; i <= colomnNumber; i++) 
		      {
		        String columnName = o_Rsmd.getColumnName(i);
		        Object value = o_rs.getObject(i);
		        Element node = (Element) doc.createElement(columnName);
		        ((Node) node).appendChild(doc.createTextNode(value.toString()));
		        ((Node) row).appendChild((Node) node);
		      }
		    }
		    DOMSource domSource = new DOMSource(doc);
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		    StringWriter sw = new StringWriter();
		    StreamResult sr = new StreamResult(sw);
		    transformer.transform(domSource, sr);
	
		    System.out.println(sw.toString());
		    xml = sw.toString();
		    
		    //Sconn.o_myConnObj.close();
		    o_rs.close();
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    
		return xml;
	}
}
