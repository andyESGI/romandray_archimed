package ESGI.CinqAL.GabMirMoh.Main;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import ESGI.CinqAL.GabMirMoh.IHM.IHM_MainMenu;

public class MainTest
{	
	public static final String _str_METAL_	= "javax.swing.plaf.metal.MetalLookAndFeel"; 
	public static final String _str_WINDOW_ = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String _str_NIMBUS_ = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String _str_CLASSIC_ = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
	public static final String _str_CDEMOTIF_ ="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	
	public static final String _str_KeyWordSparator_="NETWORK###";
	
	public static List ListOfStyle ;
	
	public static final int _int_width_ 		= 550;
	public static final int _int_height_ 		= 550;
	
	public static IHM_MainMenu o_Gui;
	

	public static void main(String[] args) //throws IOException 
	{	
		ListOfStyle = Arrays.asList(_str_METAL_ , _str_WINDOW_, _str_NIMBUS_, _str_CLASSIC_, _str_CDEMOTIF_);
			
		try 
		{
			for (UIManager.LookAndFeelInfo o_LookAndFeelInfo : UIManager.getInstalledLookAndFeels()) 
			{
				if ("Nimbus".equals(o_LookAndFeelInfo.getName())) 
				{
					UIManager.put("nimbusBase", new Color(0, 58, 23));
					UIManager.put("nimbusBlueGrey", new Color(57, 105, 138));
	                UIManager.put("FormattedTextField.background", Color.blue);
	                UIManager.put("control", new ColorUIResource(57, 105, 138));
	                //UIManager.put("textForeground", new ColorUIResource(255, 255, 255));
	                //UIManager.put("Menu.foreground", new ColorUIResource(255, 255, 255));
	                
	                UIManager.put("OptionPane.foreground", Color.blue);
	                
			        UIManager.setLookAndFeel(ListOfStyle.get(2).toString()/*o_LookAndFeelInfo.getClassName()*/);
			        break;
			    }
			}
		} 
		catch (Exception e) 
		{
			try 
			{
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
		
		//------------------------------------------------------------
		o_Gui = new IHM_MainMenu();
		
		 //o_Gui.setDefaultLookAndFeelDecorated(); 
		 
		 o_Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 o_Gui.setSize( _int_width_, _int_height_ );
		 o_Gui.setVisible(true);
		 
		//------------------------------------------------------------
		 
		/*String str_XpathRequest = "";
		
		IMediator mediator = new MyMediator();
		
		str_XpathRequest = "/repertoire/personne";
		mediator.setXpathRequest(str_XpathRequest);
		WrapperXML 	interrogatorWrapperXML 	= new WrapperXML(mediator);
		interrogatorWrapperXML.fixeSource("repertoire.xml");
		
		str_XpathRequest = "/company/employees";
		mediator.setXpathRequest(str_XpathRequest);
		WrapperJSON interrogatorWrapperJSON = new WrapperJSON(mediator);
		interrogatorWrapperJSON.fixeSource("Test.json");
		
		str_XpathRequest = "";
		mediator.setXpathRequest(str_XpathRequest);
		WrapperSQL 	interrogatorWrapperSQL 	= new WrapperSQL(mediator);
		interrogatorWrapperSQL.fixeSource(null); */
	}
}

