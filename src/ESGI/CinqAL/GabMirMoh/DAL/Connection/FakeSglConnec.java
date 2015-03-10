package ESGI.CinqAL.GabMirMoh.DAL.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

//fake singleton class
public class FakeSglConnec 
{   
    private static FakeSglConnec o_FsglDBConnection;
    
    private static String str_myPasswd;
    private static String str_myLogin;
    
    private static String str_DataBase;
    private static String str_URL;
    private static String str_Driver;
    
    public Connection o_myConnObj;
    private Statement o_MyStatement;
   

    public FakeSglConnec()
    {
    	//....
    }
 
    private FakeSglConnec(String aPass, String aLogin, String aDataBase, String aURL, String aDriver) 
    {
    	str_myLogin = aLogin; //"Login";
        str_myPasswd = aPass; //"password";
        
        str_DataBase = aDataBase;
        str_URL= aURL;//"jdbc:mysql://localhost:3306/"; //aUrl;
        str_Driver = aDriver;//"com.mysql.jdbc.Driver";
         
        String str_URLfull = str_URL+str_DataBase;
        
        try 
        {
            Class.forName(str_Driver).newInstance();
            try
            {
            	System.out.println(str_URLfull + "    " +str_myLogin+ "    "+ str_myPasswd );
            	this.o_myConnObj = (Connection)DriverManager.getConnection(str_URLfull,str_myLogin,str_myPasswd);//"jdbc:mysql://localhost:3306/"
            }
            catch(SQLException sql_ex)
            {
            	sql_ex.printStackTrace();
            }
        }
        catch (Exception sql_ex) 
        {
        	System.out.println("Connection Echec!");
        	sql_ex.printStackTrace();
        }
    }

    public static FakeSglConnec getFsglConnec() 
    {
        if ( o_FsglDBConnection == null ) 
        {
        	o_FsglDBConnection = 
        			new FakeSglConnec(str_myPasswd, str_myLogin,str_DataBase, str_URL, str_Driver);
        }
        return o_FsglDBConnection;
    }
    
    public static FakeSglConnec getFsglConnec(String aPass, String aLogin, String aDataBase, String aURL, String aDriver) 
    {
        if ( o_FsglDBConnection == null ) 
        {
        	str_myLogin = aLogin; //"Login"; //andy-andy //root
            str_myPasswd = aPass; //"password"; //Mirabel_Esgi //
            
            str_DataBase = aDataBase;
            str_URL= aURL;//"jdbc:mysql://localhost:3306/"; //aUrl;
            str_Driver = aDriver; //"com.mysql.jdbc.Driver";
        	
        	o_FsglDBConnection = 
        			new FakeSglConnec(str_myPasswd, str_myLogin,str_DataBase, str_URL, str_Driver);
        }
        return o_FsglDBConnection;
    }
    //----------------------------------------------------------------------
    
    
    public ResultSet query(String aRequest) throws SQLException
    {
    	o_FsglDBConnection = getFsglConnec();
    	
    	o_MyStatement = o_FsglDBConnection.o_myConnObj.createStatement();
        if(o_MyStatement==null)
        	System.out.println("Request Faillure");
    	
    	ResultSet o_result = o_MyStatement.executeQuery(aRequest);
        return o_result;
    }

    public int insert(String aInRequest) throws SQLException 
    {
    	o_MyStatement = o_FsglDBConnection.o_myConnObj.createStatement();
        int i_result = o_MyStatement.executeUpdate(aInRequest);
        return i_result;
    } 
}