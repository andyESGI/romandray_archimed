package ESGI.CinqAL.GabMirMoh.Pattern.Mediator;

import ESGI.CinqAL.GabMirMoh.Main.Simulation;


public interface IMediator 
{
	//------------ForIHMPart---------------------------
	public Simulation getGBSimulation();	
	public void setGBSimulation(Simulation aSimulation);
	//-------------------------------------------------
	
	public String getXpathRequest();
	public void setXpathRequest(String aRequest);
	
	public void fixeWrapperXML(WrapperXML aWrapperXML);
	public void fixeWrapperJSON(WrapperJSON aWrapperJSON);
	public void fixeWrapperSQL(WrapperSQL aWrapperSQL);
		
	public void interrogate(String aTraductorLanguage , String aXmlresult);
}