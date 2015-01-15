package ESGI.CinqAL.GabMirMoh.DND;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DropManager extends DropTargetAdapter 
{
	private DropTarget 	o_DropTarget;
    private JPanel 		o_JPanGlobal;
	
	public DropManager(JPanel o_AJPan) 
    {
		MyDropTargetListener(o_AJPan); 
    }

    public void MyDropTargetListener(JPanel o_AJPan) 
    {
    	o_JPanGlobal = o_AJPan; 
        o_DropTarget = new DropTarget(o_AJPan, DnDConstants.ACTION_COPY, this, true, null);  
    }

    @Override
    public void drop(DropTargetDropEvent o_AnEvent) 
    {
        try 
        {
            DropTarget o_DropTargetRecovery = (DropTarget) o_AnEvent.getSource();
            Component o_CompRecovery 		= (Component) o_DropTargetRecovery.getComponent();
            
            if(o_CompRecovery == null)
            	System.out.println("HOMIES WE'VE GOT A FUCKIN' PB!");
            
            Point o_DropMousePosition = o_CompRecovery.getMousePosition();           
            Transferable o_Trans 	  = o_AnEvent.getTransferable();

            if (o_AnEvent.isDataFlavorSupported(DataFlavor.imageFlavor)) 
            {
            	String str_TxtOfJbt   = null;
            	
            	if(o_AnEvent.isDataFlavorSupported(DataFlavor.stringFlavor))
            	{
            		str_TxtOfJbt 	  = (String)o_Trans.getTransferData(DataFlavor.stringFlavor);
            	}
            	
            	
            	Icon o_Icon = (Icon) o_Trans.getTransferData(DataFlavor.imageFlavor);        
                
                if (o_Icon != null) {

                	JButton o_JbtDND = new JButton(str_TxtOfJbt);
                	
                	o_JbtDND.setIcon(o_Icon);
                	o_JbtDND.setIconTextGap(0);
                	o_JbtDND.setHorizontalTextPosition(JButton.CENTER);
                	o_JbtDND.setVerticalTextPosition(JButton.BOTTOM);
                	o_JbtDND.setPreferredSize(new Dimension(50, 50));
                	
                	o_JPanGlobal.add(o_JbtDND);
                                 
                	o_JPanGlobal.revalidate();
                	o_JPanGlobal.repaint();
                    
                	o_AnEvent.dropComplete(true);
                    //o_JbtDND.setBounds(o_DropMousePosition.x,o_DropMousePosition.y,jb.getWidth(),jb.getHeight());
                	o_JbtDND.setBounds(o_DropMousePosition.x,o_DropMousePosition.y,50,50);                                 
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
}
