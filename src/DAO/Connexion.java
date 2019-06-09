package DAO;

import java.sql.Connection;

import java.sql.DriverManager;

public class Connexion{
	 /*  static String login="TEST";
	   static String mot_de_pass="test";
	   static String urlPilot="oracle.jdbc.OracleDriver";
	   static String  urlBase_de_donne="jdbc:oracle:thin:@localhost:1521:XE";
   
	*/	
	   static String login="SYSTEM";
	   static String mot_de_pass="ABDI";
	   static String urlPilot="oracle.jdbc.OracleDriver";
	   static String  urlBase_de_donne="jdbc:oracle:thin:@localhost:1521:ABDI";
    
   public static Connection getConnexion()
   {
	   
		Connection con = null;
	              
		try{
		
				 Class.forName(urlPilot);
				 con =DriverManager.getConnection(urlBase_de_donne,login,mot_de_pass);
				  				 
		    } catch(Exception ex){
                        System.out.println(" Pas de connection ");  
                        return null;
                    }
				
		   return con;
		
   }
   
}
