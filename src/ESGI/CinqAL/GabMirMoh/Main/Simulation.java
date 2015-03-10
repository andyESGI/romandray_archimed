package ESGI.CinqAL.GabMirMoh.Main;

import java.awt.Frame;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ESGI.CinqAL.GabMirMoh.Function.Outils;
import ESGI.CinqAL.GabMirMoh.IHM.IHM_MainMenu;
import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoJSON;
import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoSQL;
import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoXML;
import ESGI.CinqAL.GabMirMoh.Pattern.Mediator.IMediator;
import ESGI.CinqAL.GabMirMoh.Pattern.Mediator.MyMediator;
import ESGI.CinqAL.GabMirMoh.Pattern.Mediator.Wrapper;
import ESGI.CinqAL.GabMirMoh.Pattern.Mediator.WrapperJSON;
import ESGI.CinqAL.GabMirMoh.Pattern.Mediator.WrapperSQL;
import ESGI.CinqAL.GabMirMoh.Pattern.Mediator.WrapperXML;

public class Simulation implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ArrayList<Simulation> AllSimulation ;
	
	private static int SimulationCount = 0;
	
	private IMediator theOnlySimMediator;
	private ArrayList<WrapperXML> AllSimWrapperXML;
	private ArrayList<WrapperJSON> AllSimWrapperJSON;
	private ArrayList<WrapperSQL> AllSimWrapperSQL;
	
	private ArrayList<DataInfoXML> AlldataXML;
	private ArrayList<DataInfoJSON> AlldataJSON;
	private ArrayList<DataInfoSQL> AlldataSQL;
	
	public String str_SimulationName;
	public String str_GraphicResult;
	
	public Simulation()
	{
		SimulationCount++;
		
		str_SimulationName = "Sim - "+SimulationCount;
		
		AllSimWrapperXML  = new ArrayList<WrapperXML>();
		AllSimWrapperJSON = new ArrayList<WrapperJSON>();
		AllSimWrapperSQL  = new ArrayList<WrapperSQL>();
		
		AlldataXML = new ArrayList<DataInfoXML>();
		AlldataJSON = new ArrayList<DataInfoJSON>();
		AlldataSQL = new ArrayList<DataInfoSQL>();
		
		AllSimulation.add(this);
	}
	
	public void fixeRequest(String Request)
	{
		if(theOnlySimMediator!=null)
		{
			System.out.println("Mediator is geting a Xpath request");
			theOnlySimMediator.setXpathRequest(Request);
		}
		else
		{
			System.out.println("No Mediator for this simulation");
		}
	}
	
	public void addWrapper(Wrapper aWrapper)
	{
		if(aWrapper instanceof WrapperXML)
			AllSimWrapperXML.add((WrapperXML) aWrapper); 
		if(aWrapper instanceof WrapperJSON)
			AllSimWrapperJSON.add((WrapperJSON) aWrapper); 
		if(aWrapper instanceof WrapperSQL)
			AllSimWrapperSQL.add((WrapperSQL) aWrapper); 
	}
	
	public static Simulation getSimByName(String aSimNam)
	 {
		for(Simulation s: Simulation.AllSimulation)
		{
			System.out.println("Test comp :"+s.str_SimulationName+" - "+aSimNam);
			if(s.str_SimulationName.equals(aSimNam))
			{
				return s;
			}
		}
		return null;
	 }
	
	public static boolean loadJButtonBehaviour(String str_TxtOfJbt, String aSimulationName)
	{
		Boolean b_Error = false;
		
		IMediator mediator = null;
		String str_XpathRequest, str_DialogBoxRet;
		
		Simulation o_Sim = getSimByName(aSimulationName);
		
		switch(str_TxtOfJbt)
	    {
	        case "Mediator"://------------------------------------------------------------------------------------
	        	
	        	Object[] o_listBound = {"XML DataSource", "JSON DataSource", "SQL DataSource"};
	        	
	        	/*str_DialogBoxRet = (String)JOptionPane.showInputDialog(new JFrame(),"","Customized Dialog",
	        	                    JOptionPane.PLAIN_MESSAGE,null,o_listBound,"XML DataSource");*/
	        	
	        	if(o_Sim.theOnlySimMediator==null)
	        	{
	        	mediator = new MyMediator(); 
	        	
	        	o_Sim.theOnlySimMediator = mediator;
	        	
	        	mediator.setGBSimulation(o_Sim);//ptet a supprimer on vera apres
	        	
	    		str_XpathRequest = IHM_MainMenu.o_txtFieldRequest.toString();//
	    		mediator.setXpathRequest(str_XpathRequest);
	        	}
	        	else
	        	{
	        		System.out.println("Error : Mediator is already created");  
	    			JOptionPane.showMessageDialog(new Frame(), "Mediator is already created","Warning Dialog",JOptionPane.WARNING_MESSAGE);
	        		b_Error = true;
	        	}
	        	break;
	    		//------------------------------------------------------------------------------------
	        	
	        	
	        	
	        case "Wrapper"://------------------------------------------------------------------------------------
	        	
	        	boolean b_Cancelclicked ;
	        	
	        	Object[] o_WrapperType = {"XML Wrapper", "JSON Wrapper", "SQL Wrapper"};
	        	
	        	str_DialogBoxRet = (String)JOptionPane.showInputDialog(new JFrame(),"","Wrapper Dialog",
	        	                    JOptionPane.PLAIN_MESSAGE,null,o_WrapperType,"XML Wrapper");
	        	
	        	if ((str_DialogBoxRet != null) && (str_DialogBoxRet.length() > 0)) 
	        	{
	        		b_Cancelclicked = false;
	        	}
	        	else
	        	{
	        		b_Cancelclicked = true ;
	        	}
	        	
	        	if(o_Sim.theOnlySimMediator!=null && b_Cancelclicked==false)
	    		{
		    		if(str_DialogBoxRet =="XML Wrapper")
		    		{
		        		WrapperXML 	interrogatorWrapperXML 	= new WrapperXML(o_Sim.theOnlySimMediator);
		        		o_Sim.AllSimWrapperXML.add(interrogatorWrapperXML);
		    		}
		    		if(str_DialogBoxRet =="JSON Wrapper")
		    		{
		    			WrapperJSON interrogatorWrapperJSON 	= new WrapperJSON(o_Sim.theOnlySimMediator);
		    			o_Sim.AllSimWrapperJSON.add(interrogatorWrapperJSON);
		    		}
		    		if(str_DialogBoxRet =="SQL Wrapper")
		    		{
		    			WrapperSQL 	interrogatorWrapperSQL 	= new WrapperSQL(o_Sim.theOnlySimMediator);
		    			o_Sim.AllSimWrapperSQL.add(interrogatorWrapperSQL);	
		    		}
	    		}
	    		else
	    		{	
	    			if(b_Cancelclicked==false)
	    			{
	    				System.out.println("Error : No Mediator Found!");  
	    				JOptionPane.showMessageDialog(new Frame(), "Create a mediator first","Warning Dialog",JOptionPane.WARNING_MESSAGE);
	    			}
	    			b_Error = true;
	    		}
	        	break;//------------------------------------------------------------------------------------
	        	
	        	
	        case "DataSource"://------------------------------------------------------------------------------------
	        	
	        	Object[] o_DataSourceType = {"NETWORK XML Ressource","LOCAL XML Ressource", "NETWORK JSON Ressource", "LOCAL JSON Ressource", "SQL Ressource"};
	        	
	        	str_DialogBoxRet = (String)JOptionPane.showInputDialog(new JFrame(),"","Ressource Dialog",
	        	                    JOptionPane.PLAIN_MESSAGE,null,o_DataSourceType,"NETWORK XML Ressource");
	        	
	        	if ((str_DialogBoxRet != null) && (str_DialogBoxRet.length() > 0)) 
	        	{
	        		b_Cancelclicked = false;
	        	}
	        	else
	        	{
	        		b_Cancelclicked = true ;
	        	}
	        	
	        	
	        	//NETWORK XML------------------------------------------------------------------------------------
	        	if(str_DialogBoxRet == "NETWORK XML Ressource"  && b_Cancelclicked==false)
	        	{
	        		Boolean b_Ret=false; 
	        		String str_result =JOptionPane.showInputDialog(null, "Writte the XML ressource URL : ",
	        	            "URL Dialog", JOptionPane.PLAIN_MESSAGE);

	        		if(str_result!=null) 
	        		{

	    	        	  System.out.println("OK Button");
		        	      do 
			        	  {
		        	    	  if(str_result.isEmpty())
			                  {
		        	    		  System.out.println("\nUrl vide\n");
		        	    		  JOptionPane.showMessageDialog(new Frame(), "URL is empty, action canceled..",
		      	        	            "URL Dialog", JOptionPane.CANCEL_OPTION); 
		        	    		  b_Error = true; //in order to avoid creation of drop button data srce
		        	    		  break;
			                  }
		        	    	  
		        	    	  if (Outils.isValidURL(str_result)==false) 
			                  {
		        	    		  str_result = JOptionPane.showInputDialog("Invalid URL! Write a valid XML ressource URL : ");
			                  }
		        	    	  else 
			                  {
			                      b_Ret = true;
			                  }
			              }while (!b_Ret); 
		        	      
		        	      if(!str_result.isEmpty())
		        	      {
		        	    	  System.out.println("\n2 Url vide\n");
		        	    	  
			        	      System.out.println(str_result);
			        	      DataInfoXML o_dataInfoXMl = new DataInfoXML(MainTest._str_KeyWordSparator_+str_result);
			        	      o_Sim.AlldataXML.add(o_dataInfoXMl);  
		        	      }
	        		}
	        		else
	        		{
	        			System.out.println("Cancel Button");
		        	    b_Error = true;
	        		}
	        	}//NETWORK JSON------------------------------------------------------------------------------------
	        	else if( str_DialogBoxRet == "NETWORK JSON Ressource" && b_Cancelclicked==false)
	        	{
	        		Boolean b_Ret=false; 
	        		String str_result =JOptionPane.showInputDialog(null, "Writte the JSON ressource URL : ",
	        	            "URL Dialog", JOptionPane.PLAIN_MESSAGE);

	        		if(str_result!=null) 
	        		{
	    	        	  System.out.println("OK Button");
		        	      do 
			        	  {
		        	    	  if(str_result.isEmpty())
			                  {
		        	    		  System.out.println("\nUrl vide\n");
		        	    		  JOptionPane.showMessageDialog(new Frame(), "URL is empty, action canceled..",
		      	        	            "URL Dialog", JOptionPane.CANCEL_OPTION); 
		        	    		  b_Error = true; //in order to avoid creation of drop button data srce
		        	    		  break;
			                  }

		        	    	  
		        	    	  if (Outils.isValidURL(str_result)==false) 
			                  {
		        	    		  str_result = JOptionPane.showInputDialog("Invalid URL! Write a valid JSON ressource URL : ");
			                  } 
			                  else 
			                  {
			                      b_Ret = true;
			                  }
			              }while (!b_Ret); 	    
		        	      
		        	      if(!str_result.isEmpty())
		        	      {
		        	    	  System.out.println("\n2 Url vide\n");
		        	    	  
		        	    	  System.out.println(str_result);
			        	      DataInfoJSON o_dataInfoJSON = new DataInfoJSON(MainTest._str_KeyWordSparator_+str_result);
			        	      o_Sim.AlldataJSON.add(o_dataInfoJSON);
		        	      }
	        		}
	        		else
	        		{
	        			System.out.println("Cancel Button");
		        	    b_Error = true;
	        		}
	        	}//LOCAL XML------------------------------------------------------------------------------------
	        	else if(str_DialogBoxRet == "LOCAL XML Ressource"  && b_Cancelclicked==false)
	        	{

	        		JFileChooser o_Fchooser = IHM_MainMenu.createPersoFChooser("XML Ressource");
	        		int i_Result = o_Fchooser.showDialog(new Frame(), "OK");
	        		 
	        		switch (i_Result) 
	        		{
		        	    case JFileChooser.APPROVE_OPTION:
		        	      System.out.println("OK Button");
		        	      
		        	      System.out.println(o_Fchooser.getSelectedFile().getAbsolutePath());
		        	      DataInfoXML o_dataInfoXMl = new DataInfoXML(/*"repertoire.xml"*/o_Fchooser.getSelectedFile().getAbsolutePath());
		        	      o_Sim.AlldataXML.add(o_dataInfoXMl);  
		        	      break;
		        	      
		        	    case JFileChooser.CANCEL_OPTION:
		        	      System.out.println("Cancel Button");
		        	      b_Error = true;
		        	      break;
		        	      
		        	    case JFileChooser.ERROR_OPTION:
		        	      System.out.println("Error occured");
		        	      b_Error = true;
		        	      break;
	        		}
	        	}//LOCAL JSON------------------------------------------------------------------------------------
	        	else if( str_DialogBoxRet == "LOCAL JSON Ressource" && b_Cancelclicked==false)
	        	{
	        		JFileChooser o_Fchooser = IHM_MainMenu.createPersoFChooser("JSON Ressource");
	        		int i_Result = o_Fchooser.showDialog(new Frame(), "OK");
	        		 
	        		switch (i_Result) 
	        		{
		        	    case JFileChooser.APPROVE_OPTION:
		        	      System.out.println("OK Button");
		        	      
		        	      System.out.println(o_Fchooser.getSelectedFile().getAbsolutePath());
		        	      DataInfoJSON o_dataInfoJSON = new DataInfoJSON(o_Fchooser.getSelectedFile().getAbsolutePath());
		        	      o_Sim.AlldataJSON.add(o_dataInfoJSON);  
		        	      break;
		        	      
		        	    case JFileChooser.CANCEL_OPTION:
		        	      System.out.println("Cancel Button");
		        	      b_Error = true;
		        	      break;
		        	      
		        	    case JFileChooser.ERROR_OPTION:
		        	      System.out.println("Error occured");
		        	      b_Error = true;
		        	      break;
	        		}
	        	}//SQL RESSOURCE------------------------------------------------------------------------------------
	        	else if( str_DialogBoxRet == "SQL Ressource" && b_Cancelclicked==false)
	        	{
	        		/*JOptionPane.showMessageDialog(new Frame(), "NO IMPLEMENTED YET...",
  	        	            "CONSTRUCTION Dialog", JOptionPane.CANCEL_OPTION); 
	        		
	        		b_Error = true;// to avoid button data srce creation*/
	        		
	        			
	        		  JPasswordField aPassField = new JPasswordField("");
	        		  JTextField aLoginField = new JTextField("root");	
	        		  JTextField aDataBaseField = new JTextField("lafleur");
	        	      JTextField aURLField = new JTextField("jdbc:mysql://127.0.0.1:3306/");
	        	      JTextField aDriverField = new JTextField("com.mysql.jdbc.Driver");
	        	      
	        	      GridLayout o_GLayout = new GridLayout(3,2);
	        	      o_GLayout.setHgap(10);
	        	      
	        	      JPanel myPanel = new JPanel();
	        	      myPanel.setLayout(o_GLayout);
	        	      
	        	      myPanel.add(new JLabel("DataBase name :"));
	        	      myPanel.add(aDataBaseField);
	        	             	      
	        	      myPanel.add(new JLabel("Driver :"));
	        	      myPanel.add(aDriverField);
	        	      
	        	      myPanel.add(new JLabel("Login :"));
	        	      myPanel.add(aLoginField);
	        	      
	        	      myPanel.add(new JLabel("Password:"));
	        	      myPanel.add(aPassField);
	        	      
	        	      myPanel.add(new JLabel("URl :"));
	        	      myPanel.add(aURLField);

	        	      int result = JOptionPane.showConfirmDialog(null, myPanel, 
	        	               "Enter Connection Information", JOptionPane.OK_CANCEL_OPTION);
	        	      
	        	      if (result == JOptionPane.OK_OPTION) 
	        	      {
	        	    	  System.out.println("OK Button Connection");
	        	         //System.out.println("\nLogin : " + aLoginField.getText()+"\n");
	        	         //System.out.println("\nPassword :"+ aPassField.getText()+"\n");
	        	         //System.out.println("\nDataBase: " + aDataBaseField.getText()+"\n");
	        	         //System.out.println("\nDriver: " + aDriverField.getText()+"\n");
	        	         //System.out.println("\nURL: " + aURLField.getText()+"\n");
	        	         
	        	    	  System.out.println("BLAHHHH "+aURLField.getText());
	        	         
	        	         DataInfoSQL o_dataInfoSQL = new DataInfoSQL(aPassField.getText(), aLoginField.getText(),
	        	        		 aDataBaseField.getText(), aURLField.getText(), aDriverField.getText());
		        	      o_Sim.AlldataSQL.add(o_dataInfoSQL);    
	        	      }
	        	      else if(result == JOptionPane.CANCEL_OPTION)
	        	      {
	        	    	  System.out.println("Cancel Button");
	        	    	  b_Error = true;
	        	      }

	        	}
	        	else
	        	{
	        		b_Error = true;
	        	}
	        	
	        	
	        	break;
	        	//------------------------------------------------------------------------------------
   	
	        default:
	        	break;
	    }
		
		
		return b_Error;
	}
	
	
	public String execSimulationQuery()
	{
		String str_Result="";
		
		for(WrapperXML o_Wrapper : AllSimWrapperXML )
		{
			for(DataInfoXML o_data : AlldataXML)
			{
				o_Wrapper.fixeSource(o_data.AbsolutePath); //"repertoire.xml"
				str_Result += "\n---------------------------------------------------------------------------------------\n"
						+"Result of file\n"+ o_data.AbsolutePath.toString()+" :\n"+this.str_GraphicResult
						+"\n---------------------------------------------------------------------------------------\n";
			}
		}
		
		for(WrapperJSON o_Wrapper : AllSimWrapperJSON )
		{
			for(DataInfoJSON o_data : AlldataJSON)
			{
				o_Wrapper.fixeSource(o_data.AbsolutePath); //"Test.json"
				str_Result += "\n---------------------------------------------------------------------------------------\n"
						+"Result of file\n"+ o_data.AbsolutePath.toString()+" :\n"+this.str_GraphicResult
						+"\n---------------------------------------------------------------------------------------\n";
			}
		}
		
		for(WrapperSQL o_Wrapper : AllSimWrapperSQL )
		{
			for(DataInfoSQL o_data : AlldataSQL)
			{
				if(o_data==null)
				{
					System.out.println("THERE IS A PROBLEME MAN!!");
				}
				if(o_data.str_aPasswd==null)
				{
					System.out.println("champ");
				}
				if(o_data.str_Login==null)
				{
					System.out.println("champ");
				}
				if(o_data.str_DataBase==null)
				{
					System.out.println("champ");
				}
				if(o_data.str_Driver==null)
				{
					System.out.println("champ");
				}
				if(o_data.str_URL==null)
				{
					System.out.println("champ");
				}
				
				
				o_Wrapper.fixeSource(o_data);
				str_Result += "\n---------------------------------------------------------------------------------------\n"
						+"Result \n from URL:"+ o_data.str_URL.toString()+o_data.str_DataBase.toString()+" :\n"+this.str_GraphicResult
						+"\n---------------------------------------------------------------------------------------\n";
			}
		}
		
		return str_Result;
	}
}
