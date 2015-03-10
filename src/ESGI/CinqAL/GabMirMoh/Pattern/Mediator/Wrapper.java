package ESGI.CinqAL.GabMirMoh.Pattern.Mediator;

import ESGI.CinqAL.GabMirMoh.InfoData.DataInfoSQL;


public abstract class Wrapper 
{
	IMediator mediator;
	public abstract void fixeSource(String anURL);
	public abstract void fixeSource(DataInfoSQL aDataInfoSQL);
	
	String str_WrapperType,str_XPathRequeste, str_URL,str_XmlReturn ;
}
