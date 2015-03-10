package ESGI.CinqAL.GabMirMoh.DND;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JButton;

public class DragManager implements DragGestureListener  
{
    @Override
    public void dragGestureRecognized(DragGestureEvent o_AnEvent) 
    {
    	//JLabel o_JLbl = (JLabel) event.getComponent();
        //final Icon o_Ico = o_JLbl.getIcon();
        
        Object o_Obj =(Object) o_AnEvent.getComponent();
        
        if (!(o_Obj instanceof JButton)) 
        {
        	try 
        	{
				throw new Exception();
			} 
        	catch (Exception e) 
        	{
				e.printStackTrace();
			}   
        }
        
        JButton 	 o_JbtDND 		 = (JButton) o_Obj;
        final Icon 	 _o_Icon_ 		 = o_JbtDND.getIcon();
        final String _str_TxtOfJbt_  = o_JbtDND.getText();		

        Transferable o_Trans = new Transferable() 
        {
            @Override
            public DataFlavor[] getTransferDataFlavors() 
            {
                return new DataFlavor[]{DataFlavor.imageFlavor,DataFlavor.stringFlavor};
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor o_AFlavor) 
            {
                if (!isDataFlavorSupported(o_AFlavor)) 
                {
                    return false;
                }
                return true;
            }

            @Override
            public Object getTransferData(DataFlavor o_AFlavor) throws UnsupportedFlavorException, IOException 
            {
                if(o_AFlavor == DataFlavor.imageFlavor)
                {
                	return _o_Icon_;
                }
                if(o_AFlavor == DataFlavor.stringFlavor)
                {
                	return _str_TxtOfJbt_;
                }
                return null;       	
            }
        };
        o_AnEvent.startDrag(null, o_Trans);  
    }
    
    /*public int getSourceActions(JComponent c) {
		return TransferHandler.MOVE;
	}*/
}