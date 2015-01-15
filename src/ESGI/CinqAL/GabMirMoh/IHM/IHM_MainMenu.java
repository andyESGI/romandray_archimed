package ESGI.CinqAL.GabMirMoh.IHM;
import ESGI.CinqAL.GabMirMoh.DND.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import ESGI.CinqAL.GabMirMoh.DND.DropManager;
 
public class IHM_MainMenu extends JFrame implements ActionListener
{	
	//TransferHandler o_th_ForDrop;
	
	public static final String _str_FILE_	= "File";
	public static final String _str_OPTION_	= "Option";
	
	public static final String _str_OPEN_	= "Open New Scenario"; 
	public static final String _str_SAVE_	= "Save Current Simulation"; 
	public static final String _str_IMPORT_	= "Import Current Simulation"; 
	public static final String _str_EXPORT_	= "Export Current Simulation"; 	
	public static final String _str_EXIT_	= "Exit";
	public static final String _str_ABOUT_	= "About"; 
	
	public static final int _int_width_ 		= 550;
	public static final int _int_height_ 		= 550;
	 
	 
	public JPanel o_JPanFather = new JPanel ();
	 
 
	public static void main(String[] args)
	{
		 IHM_MainMenu o_Gui = new IHM_MainMenu();
		 
		 //o_Gui.setDefaultLookAndFeelDecorated(); 
		 
		 o_Gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 o_Gui.setSize( _int_width_, _int_height_ );
		 o_Gui.setVisible(true);
	}
	 
	 public IHM_MainMenu()
	 {
		 super("ARCHIMED PROJECT");
		 
		 o_JPanFather.setBackground(Color.BLACK); 
		 
		 CreateJMenu();
		 
		 getContentPane().add(CreateDNDObjectToolBar(), BorderLayout.WEST);
		 getContentPane().add(CreateRequestToolBar(), BorderLayout.NORTH);		 
		 getContentPane().add(o_JPanFather,BorderLayout.CENTER);
		 
		 	 
		 /*JPanel o_JPanResult = new JPanel();
		 o_JPanResult.setBackground(Color.YELLOW);	 
		 o_JPanResult.setSize(400, 50);
		 o_JPanResult.setPreferredSize(new Dimension(400, 50));
		 o_JPanFather.add(o_JPanResult,BorderLayout.SOUTH);	 */ 
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
	 
	  public JToolBar CreateRequestToolBar() 
	  {
		  JToolBar o_JtoolbRequest = new JToolBar();
	      
		  JLabel o_lblRequest = new JLabel("Enter your request : ");
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
	  }
	  
	  public JToolBar CreateDNDObjectToolBar() 
	  {
		  JToolBar o_JtoolbDND = new JToolBar(null, JToolBar.VERTICAL);
		  ImageIcon o_Icon; 
		  /*JButton o_JbtDND; *//*DnDButton o_JbtDND;*/ 
		   
		  //--------------------------------------
		  
	      //o_JbtDND = new DnDButton("Wrapper");
		  JButton o_JbtDND1 = new JButton("Wrapper");
	      o_Icon = new ImageIcon(new ImageIcon("C:\\Users\\amirabel\\workspace\\RomAndRay_Archimed"
	      		+ "\\src\\images\\Wrapper.jpg" ).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	      o_JbtDND1.setIcon(o_Icon);
	      o_JbtDND1.setIconTextGap(NORMAL);
	      //o_JbtDND1.setPreferredSize(new Dimension(100, 140));
	      o_JbtDND1.setHorizontalTextPosition(JButton.CENTER);
	      o_JbtDND1.setVerticalTextPosition(JButton.BOTTOM);
	      o_JbtDND1.setRequestFocusEnabled(false);
	      o_JtoolbDND.add(o_JbtDND1);
	      
	      //--------------------------------------
	      
	      //o_JbtDND = new DnDButton("Mediator");
	      JButton o_JbtDND2 = new JButton("Mediator");
	      o_Icon = new ImageIcon(new ImageIcon("C:\\Users\\amirabel\\workspace\\RomAndRay_Archimed"
	      		+ "\\src\\images\\Mediator.png" ).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	      o_JbtDND2.setIcon(o_Icon);
	      o_JbtDND2.setIconTextGap(NORMAL);
	      //o_JbtDND2.setPreferredSize(new Dimension(100, 140));
	      o_JbtDND2.setHorizontalTextPosition(JButton.CENTER);
	      o_JbtDND2.setVerticalTextPosition(JButton.BOTTOM);
	      o_JbtDND2.setRequestFocusEnabled(false);
	      o_JtoolbDND.add(o_JbtDND2);
	      
	      //--------------------------------------
	      
	      //o_JbtDND = new DnDButton("DataSource");
	      JButton o_JbtDND3 = new JButton("DataSource");
	      o_Icon = new ImageIcon(new ImageIcon("C:\\Users\\amirabel\\workspace\\RomAndRay_Archimed"
	      		+ "\\src\\images\\DataSource.jpg" ).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
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
        	new DropManager(o_JPanDropAim); 
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
	        	new DropManager(o_JPanDropAim); 
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
	 
	 public void actionPerformed(ActionEvent AnEvent) 
	 {
	        String str_ActionCmd = AnEvent.getActionCommand(); 
 
	        switch(str_ActionCmd.toString())
	        {
		        case _str_EXIT_:
		        	System.exit(0);
		        	break;
		        case _str_OPEN_:
		        	System.out.println("Open"); 
		        	o_JPanFather.add(TabbedPane("NewScenario"),BorderLayout.CENTER);		        
		        break;
		        case _str_SAVE_:
		        	System.out.println("Save");
		        break;
		        case _str_IMPORT_:
		        	System.out.println("Import");
		        break;
		        case _str_EXPORT_:
		        	System.out.println("Export");
		        break;
		        case _str_ABOUT_:
		        	System.out.println("ESGI - 5ème année d'Architecture des Logiciels "
		        			+ "\nRomain Gabel, Mirabel Andy, Mohktar Rahmani Rayane,");
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
	 
//	 public void setNullTH() 
//	 {
//         if (nullItem.isSelected()) {
//             area.setTransferHandler(null);
//         } else {
//             area.setTransferHandler(th);
//         }
//     }
}

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

