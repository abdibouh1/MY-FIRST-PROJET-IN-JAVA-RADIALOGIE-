package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Controleur_Login_Administrateur;
import application.LOGIN_MEDECIN_CONTROLER;

public class DAO_LOGIN_MEDECIN {
	
	
	
  public boolean seconnecter(String Login ,String Password){
        
        Connection cnx=Connexion.getConnexion();
        
        PreparedStatement prepa ;
        
        String requet="select * from MEDEECIN where EMAIL =? and PASSWORD=?";
        
        try {
            
            prepa=cnx.prepareStatement(requet);
            prepa.setString(1, Login);
            prepa.setString(2, Password);
            
            ResultSet rs = prepa.executeQuery();
            
            if(rs.next()){
                
                return true;
                
            }
            else
                 return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(LOGIN_MEDECIN_CONTROLER.class.getName()).log(Level.SEVERE, null, ex);
            
             return false;
        }
       
     
    }
	
	

}
