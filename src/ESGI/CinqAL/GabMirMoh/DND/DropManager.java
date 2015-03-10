package ESGI.CinqAL.GabMirMoh.DND;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import ESGI.CinqAL.GabMirMoh.Main.Simulation;

public class DropManager extends DropTargetAdapter 
{
	private DropTarget 	o_DropTarget;
    private JPanel 		o_JPanGlobal;
    
    private String o_SimulationName;
	
	public DropManager(JPanel o_AJPan, String aSimulationName) 
    {
		o_SimulationName = aSimulationName;
		MyDropTargetListener(o_AJPan); 
    }

    public void MyDropTargetListener(JPanel o_AJPan) 
    {
    	o_JPanGlobal = o_AJPan; 
        o_DropTarget = new DropTarget(o_JPanGlobal, DnDConstants.ACTION_MOVE,this, true, null); 
    }

    /*public synchronized void dragEnter(DropTargetDragEvent dtde) {
    	System.out.println("Drag enter");
        
        // Check the data format and either accept or reject  it
        if (dtde.isDataFlavorSupported(DataFlavor.imageFlavor)) {
            dtde.acceptDrag(DnDConstants.ACTION_COPY);
        } else if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
        	dtde.acceptDrag(DnDConstants.ACTION_COPY);
        } else {
            dtde.rejectDrag();
        }
    }*/
    
    @Override
    public void drop(DropTargetDropEvent o_AnEvent) 
    {
        try 
        {
            DropTarget o_DropTargetRecovery = (DropTarget) o_AnEvent.getSource();
            Component o_CompRecovery 		= (Component) o_DropTargetRecovery.getComponent(); 
            
            if(o_CompRecovery == null)
            	System.out.println("Erreur drop");
            
            Point o_DropMousePosition = o_CompRecovery.getMousePosition();           
            Transferable o_Trans 	  = o_AnEvent.getTransferable();

            if (o_AnEvent.isDataFlavorSupported(DataFlavor.imageFlavor)) 
            {
            	String str_TxtOfJbt   = null;
            	boolean b_ErroReturned = false;
            	
            	if(o_AnEvent.isDataFlavorSupported(DataFlavor.stringFlavor))
            	{
            		str_TxtOfJbt 	  = (String)o_Trans.getTransferData(DataFlavor.stringFlavor);
            		
            		b_ErroReturned =Simulation.loadJButtonBehaviour(str_TxtOfJbt,o_SimulationName);
            		
            		
            	}
            	
            	if(b_ErroReturned==false)
            	{
            		Icon o_Icon = (Icon) o_Trans.getTransferData(DataFlavor.imageFlavor);        
                
	                if (o_Icon != null) 
	                {
	
	                	JButton o_JbtDND = new JButton(str_TxtOfJbt);
	                	
	                	o_JbtDND.setIcon(o_Icon);
	                	o_JbtDND.setIconTextGap(0);
	                	o_JbtDND.setHorizontalTextPosition(JButton.CENTER);
	                	o_JbtDND.setVerticalTextPosition(JButton.BOTTOM);
	                	o_JbtDND.setPreferredSize(new Dimension(50, 50));
	                	
	                	o_JPanGlobal.add(o_JbtDND);
	                                 
	                	o_JPanGlobal.revalidate();
	                	o_JPanGlobal.repaint();
	                    
	                	
	                	//////o_AnEvent.acceptDrop(DnDConstants.ACTION_MOVE);
	                	
	                	
	                	o_AnEvent.dropComplete(true);
	                	o_JbtDND.setBounds(o_DropMousePosition.x,o_DropMousePosition.y,50,50); 
	                	
	                	
	                	//A FINIR POUR REDEPLACER UN COMPOSANT AP UN DROP
	                	//test(o_JbtDND);
	                	//o_JPanGlobal.repaint();
	                	
	                }
            	}
            } 
            else 
            { 	
            	o_AnEvent.rejectDrop();
            }
        } 
        catch (Exception o_Ex) 
        {
        	o_Ex.printStackTrace();
            o_AnEvent.rejectDrop();
        }
    }
    
    public void test(JButton o_JbtDND)
    {
    	//for (ActionListener listener : o_JbtDND.getActionListeners())
    		//o_JbtDND.removeActionListener(listener);
    	
    	System.out.println("anDYtESTdRAGandDrop:");    	
    	DragManager  o_DragListenerX = new DragManager();
        
    	DragSource 	 o_DragSrcX = new DragSource();
        o_DragSrcX.createDefaultDragGestureRecognizer(o_JbtDND, DnDConstants.ACTION_MOVE, o_DragListenerX);
    	
    	//--------------------------------------------------------------
    	
    	o_JbtDND.setTransferHandler(new TransferHandler("test"));
    	
    	o_JbtDND.addMouseListener(new MouseAdapter() 
    	{
    		
    		public void eventMouseClicked(MouseEvent AnEvent)
    		{
    			JComponent o_myJbtDND = (JComponent)AnEvent.getSource();
    			TransferHandler o_Trans = o_myJbtDND.getTransferHandler();
    			o_Trans.exportAsDrag(o_myJbtDND, AnEvent, TransferHandler.MOVE);
    		}
		});
    	
    } 
}
