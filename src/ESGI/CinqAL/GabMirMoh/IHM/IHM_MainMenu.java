package ESGI.CinqAL.GabMirMoh.IHM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ESGI.CinqAL.GabMirMoh.DND.DragManager;
import ESGI.CinqAL.GabMirMoh.DND.DropManager;
import ESGI.CinqAL.GabMirMoh.Function.SerializDeserializ;
import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoXML;
import ESGI.CinqAL.GabMirMoh.Main.Simulation;
 
public class IHM_MainMenu extends JFrame implements ActionListener
{	
	//protected Picture icone_SYC = new Picture();
	
	//TransferHandler o_th_ForDrop;
	//public static List<JTabbedPane> scenarioList ;
		
	public static final String _str_MEDIATOR_	= "Mediator"; 
	public static final String _str_WRAPPER_	= "Wrapper";
	public static final String _str_DATASOURCE_	= "DataSource";
	
	public static final String _str_FILE_	= "File";
	public static final String _str_OPTION_	= "Option";
	
	public static final String _str_OPEN_	= "Open New Scenario"; 
	public static final String _str_SAVE_	= "Save session"; 
	public static final String _str_LOAD_	= "Load Last session"; 
	public static final String _str_IMPORT_	= "Import Current Simulation"; 
	public static final String _str_EXPORT_	= "Export Current Simulation"; 	
	public static final String _str_EXIT_	= "Exit";
	public static final String _str_ABOUT_	= "About"; 
	
	public static final String _str_SUBMIT_	= "Submit";
	public static final String _str_DELETE_	= "Delete"; 
	
	public JPanel o_JPanFather = new JPanel ();
	 
	
	 public IHM_MainMenu()
	 {
		 super("ARCHIMED PROJECT");
		 
		 //icone_SYC.setFichierImage( Picture.createFichierImage("","AndyFootAntony92.jpg"));
		 //icone_SYC.setPreferredSize(new Dimension(50,46));
		 
		 this.setIconImage(new ImageIcon("yellowDevil.jpg").getImage());
		 
		 o_JPanFather.setBackground(Color.BLACK); 
		 
		 CreateJMenu();
		 
		 getContentPane().add(CreateDNDObjectToolBar(), BorderLayout.WEST);
		 getContentPane().add(CreateRequestToolBar(), BorderLayout.NORTH);		 
		 getContentPane().add(o_JPanFather,BorderLayout.CENTER);
		 
		 
		 Simulation.AllSimulation = new ArrayList<Simulation>();
	 }
	 
	 public void CreateJMenu()
	 {
		  JMenu o_MFile = new JMenu(_str_FILE_);
	 
		  JMenuItem o_MFile_ItmOpen = new JMenuItem(_str_OPEN_);
		  o_MFile_ItmOpen.addActionListener(this);
		  o_MFile.add(o_MFile_ItmOpen);
	 
		  JMenuItem o_MFile_ItmSave = new JMenuItem(_str_SAVE_);
		  o_MFile_ItmSave.addActionListener(this);
		  o_MFile.add(o_MFile_ItmSave);
		  
		  JMenuItem o_MFile_ItmLoad = new JMenuItem(_str_LOAD_);
		  o_MFile_ItmLoad.addActionListener(this);
		  o_MFile.add(o_MFile_ItmLoad);
		  
		  JMenuItem o_MFile_ItmImport = new JMenuItem(_str_IMPORT_);
		  o_MFile_ItmImport.addActionListener(this);
		  o_MFile.add(o_MFile_ItmImport);
		  
		  JMenuItem o_MFile_ItmExport = new JMenuItem(_str_EXPORT_);
		  o_MFile_ItmExport.addActionListener(this);
		  o_MFile.add(o_MFile_ItmExport);
	 
		  JMenuItem o_MFile_ItmExit = new JMenuItem(_str_EXIT_);
		  o_MFile_ItmExit.addActionListener(this);
		  o_MFile.add(o_MFile_ItmExit);
		  
		  //--------------------------------------
		  
		  JMenu o_MOption = new JMenu(_str_OPTION_);
		  
		  JMenuItem o_MOption_ItmAbout = new JMenuItem(_str_ABOUT_);
		  o_MOption_ItmAbout.addActionListener(this);
		  o_MOption.add(o_MOption_ItmAbout);
		  
		  //--------------------------------------
		  
		  JMenuBar o_Menu = new JMenuBar();
		  o_Menu.add(o_MFile);
		  o_Menu.add(o_MOption);
		  
		  setJMenuBar(o_Menu);	  
	 }
	 
	 public static JTextField o_txtFieldRequest;
	 
	  public JToolBar CreateRequestToolBar() 
	  {
		  JToolBar o_JtoolbRequest = new JToolBar();
	      
		  JLabel o_lblRequest = new JLabel("Enter your request : ");
		  o_lblRequest.setRequestFocusEnabled(false);
		  
		  o_JtoolbRequest.add(o_lblRequest);
		  
		  o_txtFieldRequest = new JTextField(); 
		  o_txtFieldRequest.setPreferredSize(new Dimension(330,30));
		  o_txtFieldRequest.setRequestFocusEnabled(false);
		  o_JtoolbRequest.add(o_txtFieldRequest);
	      
	      JButton o_JbtRequest;
	      
	      o_JbtRequest = new JButton(_str_SUBMIT_);
	      o_JbtRequest.addActionListener(this);
	      o_JbtRequest.setRequestFocusEnabled(false);
	      o_JtoolbRequest.add(o_JbtRequest);
	        
	      o_JbtRequest = new JButton(_str_DELETE_);
	      o_JbtRequest.addActionListener(this);
	      o_JbtRequest.setRequestFocusEnabled(false);
	      o_JtoolbRequest.add(o_JbtRequest);

	      
	      
	      //--------Test--------------------------------------------------------------------------------------------
//	      ImageIcon o_Icon;
//	      JButton o_JbtDND = new JButton("Test");
//	      o_Icon = new ImageIcon(new ImageIcon("C:\\Users\\amirabel\\workspace\\RomAndRay_Archimed"
//		      		+ "\\src\\images\\Wrapper.jpg" ).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
//	      o_JbtDND.setIcon(o_Icon);
//	      o_JbtDND.setTransferHandler(new MyTransferHandler());
//	      o_JbtDND.addMouseListener(new MouseAdapter() 
//	    	{
//	    		public void eventMouseClicked(MouseEvent AnEvent)
//	    		{
//	    			JComponent o_myJbtDND = (JComponent)AnEvent.getSource();
//	    			TransferHandler o_Trans = o_myJbtDND.getTransferHandler();
//	    			o_Trans.exportAsDrag(o_myJbtDND, AnEvent, TransferHandler.MOVE);
//	    		}
//			});
//	    	o_JtoolbRequest.add(o_JbtDND);
	      //---------Test-------------------------------------------------------------------------------------------
	          
	      	      	      
	      o_JtoolbRequest.setFloatable(false);
	      return o_JtoolbRequest;      
	  }
	  
	  /*public JToolBar CreateSrceLocationToolBar() 
	  {
		  JToolBar o_JtoolbRequest = new JToolBar();
	      
		  JLabel o_lblRequest = new JLabel("DataSource URL : ");
		  o_lblRequest.setRequestFocusEnabled(false);
		  
		  o_JtoolbRequest.add(o_lblRequest);
		  
		  JTextField o_txtFieldRequest = new JTextField(); 
		  o_txtFieldRequest.setRequestFocusEnabled(false);
		  o_JtoolbRequest.add(o_txtFieldRequest);
	      
	      JButton o_JbtRequest;
	      
	      o_JbtRequest = new JButton("Submite");
	      o_JbtRequest.setRequestFocusEnabled(false);
	      o_JtoolbRequest.add(o_JbtRequest);
	        
	      o_JbtRequest = new JButton("Delete");
	      o_JbtRequest.setRequestFocusEnabled(false);
	      o_JtoolbRequest.add(o_JbtRequest);
     
	      o_JtoolbRequest.setFloatable(false);
	      return o_JtoolbRequest;      
	  }*/
	  
	  public JToolBar CreateDNDObjectToolBar() 
	  {
		  JToolBar o_JtoolbDND = new JToolBar(null, JToolBar.VERTICAL);
		  ImageIcon o_Icon; 
		  /*JButton o_JbtDND; *//*DnDButton o_JbtDND;*/ 
		  
		  //--------------------------------------
	      
	      //o_JbtDND = new DnDButton("Mediator");
	      JButton o_JbtDND2 = new JButton(_str_MEDIATOR_);
	      o_JbtDND2.addActionListener(this);
	      
	      o_Icon = new ImageIcon(new ImageIcon(
	    		  "..\\RomAndRay_Archimed\\src\\images\\Mediator.png"//CléOuRelatif
	    		  //"C:\\Users\\amirabel\\workspace\\RomAndRay_Archimed\\src\\images\\Mediator.png"//AuTaff Eurosport 
	    		  //"D:\\ESGI_5AL\\Cour et TP XML 5AL\\RomAndRay_Archimed\\src\\images\\Mediator.png"//ChezMoi
	    		  ).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	      o_JbtDND2.setIcon(o_Icon);
	      o_JbtDND2.setIconTextGap(NORMAL);
	      //o_JbtDND2.setPreferredSize(new Dimension(100, 140));
	      o_JbtDND2.setHorizontalTextPosition(JButton.CENTER);
	      o_JbtDND2.setVerticalTextPosition(JButton.BOTTOM);
	      o_JbtDND2.setRequestFocusEnabled(false);
	      o_JtoolbDND.add(o_JbtDND2);
	      
		  //--------------------------------------
		  
	      //o_JbtDND = new DnDButton("Wrapper");
		  JButton o_JbtDND1 = new JButton(_str_WRAPPER_);
		  o_JbtDND1.addActionListener(this);
		  
	      o_Icon = new ImageIcon(new ImageIcon(
	    		  "..\\RomAndRay_Archimed\\src\\images\\Wrapper.jpg"//CléOuRelatif
	    		  //"C:\\Users\\amirabel\\workspace\\RomAndRay_Archimed\\src\\images\\Wrapper.jpg"//AuTaff Eurosport
	    		  //"D:\\ESGI_5AL\\Cour et TP XML 5AL\\RomAndRay_Archimed\\src\\images\\Wrapper.jpg"//ChezMoi
	    		  ).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	      o_JbtDND1.setIcon(o_Icon);
	      o_JbtDND1.setIconTextGap(NORMAL);
	      //o_JbtDND1.setPreferredSize(new Dimension(100, 140));
	      o_JbtDND1.setHorizontalTextPosition(JButton.CENTER);
	      o_JbtDND1.setVerticalTextPosition(JButton.BOTTOM);
	      o_JbtDND1.setRequestFocusEnabled(false);
	      o_JtoolbDND.add(o_JbtDND1);
	      	      
	      //--------------------------------------
	      
	      //o_JbtDND = new DnDButton("DataSource");
	      JButton o_JbtDND3 = new JButton(_str_DATASOURCE_);
	      o_JbtDND3.addActionListener(this);
	      
	      o_Icon = new ImageIcon(new ImageIcon(
	    		  "..\\RomAndRay_Archimed\\src\\images\\DataSource.jpg"//CléOuRelatif
	    		  //"C:\\Users\\amirabel\\workspace\\RomAndRay_Archimed\\src\\images\\DataSource.jpg"//AuTaff Eurosport
	    		  //"D:\\ESGI_5AL\\Cour et TP XML 5AL\\RomAndRay_Archimed\\src\\images\\DataSource.jpg"//ChezMoi  
	    		  ).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	      o_JbtDND3.setIcon(o_Icon);
	      o_JbtDND3.setIconTextGap(NORMAL);  
	      //o_JbtDND3.setPreferredSize(new Dimension(100, 140));
	      o_JbtDND3.setHorizontalTextPosition(JButton.CENTER);
	      o_JbtDND3.setVerticalTextPosition(JButton.BOTTOM);
		  o_JbtDND3.setRequestFocusEnabled(false);
	      o_JtoolbDND.add(o_JbtDND3);
	      
	      //--------------------------------------
	      
	      	/*MouseListener listener = new DragMouseAdapter();
	        o_JbtDND1.addMouseListener(listener);
	        o_JbtDND2.addMouseListener(listener);
	        o_JbtDND3.addMouseListener(listener);
	        
	        o_JbtDND1.setTransferHandler(new TransferHandler("icon"));
	        o_JbtDND2.setTransferHandler(new TransferHandler("icon"));
	        o_JbtDND3.setTransferHandler(new TransferHandler("icon"));*/

	        DragManager o_DragListener = new DragManager();
	        DragSource 	 o_DragSrc1 = new DragSource();
	        o_DragSrc1.createDefaultDragGestureRecognizer(o_JbtDND1, DnDConstants.ACTION_COPY, o_DragListener);

	        DragSource o_DragSrc2 = new DragSource();
	        o_DragSrc2.createDefaultDragGestureRecognizer(o_JbtDND2, DnDConstants.ACTION_COPY, o_DragListener);

	        DragSource o_DragSrc3 = new DragSource();
	        o_DragSrc3.createDefaultDragGestureRecognizer(o_JbtDND3, DnDConstants.ACTION_COPY, o_DragListener);
	             
	      
	      o_JtoolbDND.setFloatable(false);
	      return o_JtoolbDND;      
	  }
	  
	  
	  
	  public static JPanel o_JPanDropAim;
	  public static JTabbedPane o_JTabPan;	
	  //public static JButton jbtest;
	  ////public static JTextArea o_jtxtArea_test;
	  
	  
	  public JTabbedPane TabbedPane(String str_AScenario) 
	  {
		  /*str_AScenario = str_AScenario +" - "+ScenarioCount++;*/ //Obselete
		  	
		  	if(o_JTabPan == null)
	        {
		  	////setLayout(new BorderLayout());
	        //setBackground(Color.RED);
		  	
	        ////JPanel jp = new JPanel();
	        ////jp.setLayout(new BorderLayout());//jp.setBackground(Color.RED);
	        
	        	o_JTabPan = new JTabbedPane(); 
	                
	        ////o_jtxtArea_test = new JTextArea(""); //o_jtxtArea_test.setDragEnabled(true); MouseListener listener = new DragMouseAdapter(); o_jtxtArea_test.addMouseListener(listener);
	        
	        //o_jtxtArea_test.setTransferHandler(new TransferHandler("Text"));
	        ////o_th_ForDrop= o_jtxtArea_test.getTransferHandler();
	        
        	////o_jtxtArea_test.setDropMode(DropMode.INSERT);
        	
	        //tb.add(str_scenario, o_jtxtArea_test /*new JTextArea("")*/);	      
        	
	        o_JPanDropAim = new JPanel(); 
	        o_JPanDropAim.setLayout(null);
        	new DropManager(o_JPanDropAim,str_AScenario); 
        	o_JTabPan.add(str_AScenario, o_JPanDropAim /*new JTextArea("")*/);
        	
	        ////tb.setSize(400,200);
	        
	        ////jp.add(tb, BorderLayout.CENTER);
	        //add(jp, BorderLayout.SOUTH);	
	        }
	        else
	        {	
	        	//jbtest = new JButton();
	        	//jbtest.addActionListener(this);
	        	////o_jtxtArea_test = new JTextArea("");   //	o_jtxtArea_test.setDragEnabled(true); MouseListener listener = new DragMouseAdapter(); o_jtxtArea_test.addMouseListener(listener);
	        	////o_jtxtArea_test.setDropMode(DropMode.INSERT);
	        	
	        	//o_jtxtArea_test.setTransferHandler(new TransferHandler("Text"));
	        	////o_th_ForDrop= o_jtxtArea_test.getTransferHandler();	
	        	
	        	//tb.add(str_scenario, o_jtxtArea_test); //TextArea(""));
	        	
	        	o_JPanDropAim = new JPanel();
	        	o_JPanDropAim.setLayout(null); 
	        	new DropManager(o_JPanDropAim,str_AScenario); 
	        	o_JTabPan.add(str_AScenario, o_JPanDropAim /*new JTextArea("")*/);
	        }
	        
	        //this.getContentPane().add(TabbedPane(str_scenario),BorderLayout.SOUTH);
	        
	        o_JTabPan.setEnabled(true);
	        o_JTabPan.setSize(400, 400);
	        o_JTabPan.setPreferredSize(new Dimension(400, 400));
	        
	        return o_JTabPan; 
	 }
 
	 public void Delete()
	 {
		 
	 }
	 
	 //private static int ScenarioCount = 0;//Obselete
	 //private static ArrayList<Simulation> AllSimulation ;
	  
	 public void actionPerformed(ActionEvent AnEvent) 
	 {
	        String str_ActionCmd = AnEvent.getActionCommand(); 
 
	        switch(str_ActionCmd.toString())
	        {
		        case _str_EXIT_:
		        	System.out.println("Exit");
		        	System.exit(0);
		        	break;
		        case _str_OPEN_:
		        	System.out.println("Open"); 
		        	
		        	Simulation newSim = new Simulation();
		        	o_JPanFather.add(TabbedPane(newSim.str_SimulationName),BorderLayout.CENTER);	        	    	
		        break;
		        
		        case _str_SAVE_:
		        	System.out.println("Save");
		        	
		        	try 
		        	{
		        		int i_nb= Simulation.AllSimulation.size();
		        		if(i_nb>=1)
		        		{
				        	//Object[] simulation = new Object[Simulation.AllSimulation.size()]; 
				        	for(int i=0;i<Simulation.AllSimulation.size();i++)
				        	{
				        		Simulation.AllSimulation.get(i);
				        		SerializDeserializ.serialize(Simulation.AllSimulation.get(i), i+"Simulation.xml");
				        	}
		        		}
		            } 
		        	catch (Exception ex) 
		            {
		                ex.printStackTrace(); 
		            }
		        break;
		        
		        case _str_LOAD_:
		        	System.out.println("Load");
		        	
		        	Simulation o_SimL = null;
		        	
		        	JFileChooser o_Fchooser = IHM_MainMenu.createPersoFChooser("LOAD SIMULATION");
	        		int i_Result = o_Fchooser.showDialog(new Frame(), "OK");
	        		 
	        		if(i_Result==JFileChooser.APPROVE_OPTION) 
	        		{
	        			System.out.println("OK Button");
	        			System.out.println(o_Fchooser.getSelectedFile().getAbsolutePath());
		        	    if(o_Fchooser.getSelectedFile().getAbsolutePath().contains("Simulation.xml"))
		        	    {
		        			try 
				            {
		        				o_SimL = (Simulation) SerializDeserializ.deserialize(o_Fchooser.getSelectedFile().getAbsolutePath());
		        				o_JPanFather.add(TabbedPane(o_SimL.str_SimulationName),BorderLayout.CENTER);	
				            } 
				            catch (ClassNotFoundException | IOException e) 
				            {
				                e.printStackTrace();
				            } 	
		        	    }
		        	    else
		        	    {
		        	    	JOptionPane.showMessageDialog(new Frame(), "Load Faillure..",
	      	        	            "Load Dialog", JOptionPane.CANCEL_OPTION); 
		        	    }
	        		}
	        		else if(i_Result==JFileChooser.CANCEL_OPTION)
	        		{
	        			System.out.println("Cancel Button");
	        		}
	        		else
	        		{
		        	    System.out.println("Error occured");
	        		} 
		        break;
		        
		        case _str_IMPORT_:
		        	System.out.println("Import");
		        break;
		        
		        case _str_EXPORT_:
		        	System.out.println("Export");
		        break;
		        
		        case _str_ABOUT_:
		        	System.out.println("ESGI - 5ème année d'Architecture des Logiciels "
		        			+ "\nRomain Gabel, Mirabel Andy, Mohktar Rahmani Rayane\nCopyright ©2015");
		        	JOptionPane.showMessageDialog(this, "ESGI 2015 School Project \nDevelopped by last year student of Software Architecture : "
		        			+ "\nRomain Gabel, Mirabel Andy and Mohktar Rahmani Rayane\n\nCopyright ©2015","ARCHIMED PROJECT Informations",JOptionPane.INFORMATION_MESSAGE);
		        break;
		        
		        case _str_SUBMIT_:
		        	System.out.println("Submit");
		        	
		        	int i_nb= Simulation.AllSimulation.size();
		        	Object[] simulation = new Object[Simulation.AllSimulation.size()]; 
		        	System.out.println(simulation.length);
		        	for(int i=0;i<Simulation.AllSimulation.size();i++)
		        	{
		        		simulation[i]=Simulation.AllSimulation.get(i).str_SimulationName;
		        	}
		        	
		        	if(i_nb > 0)
		        	{
		        	String str_DialogBoxRet = (String)JOptionPane.showInputDialog(this,"Chose a simulation scenario for exec the query","XPATH Query Dialog",
		        	                    JOptionPane.PLAIN_MESSAGE,null/*new ImageIcon(getClass().getResource("arbre.gif"))*/,simulation,"No simulation selected");

			        	if ((str_DialogBoxRet != null) && (str_DialogBoxRet.length() > 0)) //str_DialogBoxRet!=JOptionPane.CLOSED_OPTION
			        	{  	 
			        		System.out.println(str_DialogBoxRet);
			        		
			        		Simulation o_Sim = Simulation.getSimByName(str_DialogBoxRet);
			        		if(o_Sim!=null)
			        		o_Sim.fixeRequest(o_txtFieldRequest.getText());
			        		
			        		String result = o_Sim.execSimulationQuery();
			        		
			        		//New Window Resultat:
			        		JOptionPane.showMessageDialog(this, result.toString(), "XPATH QUERY RESULT", JOptionPane.PLAIN_MESSAGE);
			        	}
		        	}
		        	else
		        	{
		        		JOptionPane.showMessageDialog(this, "Create or import a simulation scenario first","Warning Dialog",JOptionPane.WARNING_MESSAGE);
		        	}
		        	
		        break;
		        
		        case _str_DELETE_ :
		        	System.out.println("Delete");
		        	
		        	int i_nbr= Simulation.AllSimulation.size();
		        	Object[] simulation1 = new Object[Simulation.AllSimulation.size()]; 
		        	System.out.println(simulation1.length);
		        	for(int i=0;i<Simulation.AllSimulation.size();i++)
		        	{
		        		simulation1[i]=Simulation.AllSimulation.get(i).str_SimulationName;
		        	}
		        	
		        	if(i_nbr > 0)
		        	{
		        	String str_DialogBoxRet = (String)JOptionPane.showInputDialog(this,"Chose a simulation scenario to delete","Delete Dialog",
		        	                    JOptionPane.PLAIN_MESSAGE,null,simulation1,"No simulation selected");

			        	if ((str_DialogBoxRet != null) && (str_DialogBoxRet.length() > 0)) //str_DialogBoxRet!=JOptionPane.CLOSED_OPTION
			        	{  	 
			        		System.out.println(str_DialogBoxRet);
			        		
			        		Simulation o_Sim = Simulation.getSimByName(str_DialogBoxRet);
			        		o_JTabPan.remove(Simulation.AllSimulation.indexOf(o_Sim));
			        		
			        		if(o_Sim!=null) 
			        			Simulation.AllSimulation.remove(o_Sim);
			        			o_Sim = null;
		
			        	}
		        	}
		        	else
		        	{
		        		JOptionPane.showMessageDialog(this, "Create or import a simulation scenario first","Warning Dialog",JOptionPane.WARNING_MESSAGE);
		        	}
		        break;
		        
		        
		        case _str_MEDIATOR_ :
		        	System.out.println("MediatorBUTTON");
		        break; 
		        case _str_WRAPPER_ :
		        	System.out.println("WrapperButton");
		        break; 
		        case _str_DATASOURCE_ :
		        	System.out.println("DataSourceButton");
		        break; 
		        
		        default:
		        	break;
	        }
 
	        //if(AnEvent.getSource() == /*jbtest*/o_jtxtArea_test)
	       // {
	        	//System.out.println("Test");
	        //}  
	        //setNullTH();
	 } 
	 
	 public static JFileChooser createPersoFChooser(String typeXmlorJSON) 
	 {
		  JFileChooser o_Fchooser = new JFileChooser();
		  FileFilter[] filefilters = o_Fchooser.getChoosableFileFilters();
		  
		  for (int i = 0; i < filefilters.length; i++) 
		  {
			  o_Fchooser.removeChoosableFileFilter(filefilters[i]);
		  }
		  if(typeXmlorJSON == "XML Ressource")
		  o_Fchooser.addChoosableFileFilter(new FileNameExtensionFilter("XML files (.xml)", "xml"));
		  if(typeXmlorJSON == "JSON Ressource")
		  o_Fchooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON files (.json)","json"));
	  
		  return o_Fchooser;
	 } 
}



//getContentPane().add(CreateSrceLocationToolBar(),BorderLayout.SOUTH);

 
/*JPanel o_JPanResult = new JPanel();
o_JPanResult.setBackground(Color.YELLOW);	 
o_JPanResult.setSize(400, 50);
o_JPanResult.setPreferredSize(new Dimension(400, 50));
o_JPanFather.add(o_JPanResult,BorderLayout.SOUTH);	 */ 

//public void setNullTH() 
//{
//    if (nullItem.isSelected()) {
//        area.setTransferHandler(null);
//    } else {
//        area.setTransferHandler(th);
//    }
//}


//class DragMouseAdapter extends MouseAdapter 
//{
//    public void mousePressed(MouseEvent AnEvent) 
//    {
//        JComponent c = (JComponent) AnEvent.getSource();
//        TransferHandler handler = c.getTransferHandler();
//        handler.exportAsDrag(c, AnEvent, TransferHandler.COPY);
//    }
//    
////    private void formMousePressed(java.awt.event.MouseEvent AnEvent) 
////    {
////    	JComponent c = (JComponent) AnEvent.getSource();
////        c.setBounds(AnEvent.getX(), AnEvent.getY(), 100, 60);
////    }
////    
////    private void formMouseDragged(java.awt.event.MouseEvent AnEvent) 
////    {
////    	JComponent c = (JComponent) AnEvent.getSource();
////        c.setBounds(AnEvent.getX(), AnEvent.getY(), 100, 60);
////    }
////    private void formMouseReleased(java.awt.event.MouseEvent e) 
////    {
////    	JComponent c = (JComponent) AnEvent.getSource();
////        c.setBounds(AnEvent.getX(), AnEvent.getY(), 100, 60);
////    }
//}



//public class MyTransferHandler extends TransferHandler
//{
//	   public boolean canImport(TransferHandler.TransferSupport info) 
//	   {
//		   if (!info.isDataFlavorSupported(DataFlavor.imageFlavor )) 
//		   {
//			    return false;
//		   }
//		   return true;  	   
//	   }
//	   public boolean importData(TransferHandler.TransferSupport support)
//	   {
//		   if(!canImport(support))
//		     return false;
//		   Transferable data = support.getTransferable();
//		   ImageIcon myIcon = null;
//		   JButton o_JbtTrans; //= new JButton();
//		   try 
//		   {
//			   myIcon = (ImageIcon)data.getTransferData(DataFlavor.imageFlavor);
//		   } 
//		   catch (UnsupportedFlavorException e)
//		   {
//		     e.printStackTrace();
//		   } catch (IOException e) 
//		   {
//		     e.printStackTrace();
//		   }			 		
//		   o_JbtTrans = (JButton)support.getComponent();
//		   //o_JbtTrans.setText(str);
//		   o_JbtTrans.setIcon(myIcon);
//		   return true;
//	   }
//	   protected void exportDone(JComponent c, Transferable t, int action)
//	   {
//		   if(action == MOVE)
//			      ((JButton)c).setIcon(null);
//	   }
//	   protected Transferable createTransferable(JComponent c) 
//	   {
//		    JButton srce = (JButton) c;
//          Transferable rs = new ImageTransferable(srce.getIcon());
//          return rs;
//	   }
//	   public int getSourceActions(JComponent c) 
//	   {
//		   return MOVE;
//	   } 
//}

//public static class ImageTransferable implements Transferable 
//{
//	 BufferedImage image;
//	 
//	    public ImageTransferable(Icon icon) 
//	    {
//	      this.image = image;
//	    }
//	 
//	    public DataFlavor[] getTransferDataFlavors() 
//	    {
//	      return new DataFlavor[]{DataFlavor.imageFlavor, DataFlavor.stringFlavor};
//	    }
//	 
//	    public boolean isDataFlavorSupported(DataFlavor flavor) 
//	    {
//	      boolean result = false;
//	      for (DataFlavor f : getTransferDataFlavors()) 
//	      {
//	        result = (f.equals(flavor));
//	        if (result) 
//	        {
//	          break;
//	        }
//	      }
//	      return result;
//	    }
//	 
//	    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException 
//	    {
//	      if (flavor == DataFlavor.imageFlavor) 
//	      {
//	        return image;
//	      }
//	      else if (flavor == DataFlavor.stringFlavor) 
//	      {
//	        return "Sorry we can only export an image.";
//	      }
//	      throw new UnsupportedFlavorException(flavor);
//	    }
//}
//	   
