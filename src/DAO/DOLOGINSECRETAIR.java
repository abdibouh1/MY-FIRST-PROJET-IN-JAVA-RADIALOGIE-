package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Controleur_Login_Administrateur;

public class DOLOGINSECRETAIR {
	

	
	
    public boolean seconnecter(String Login ,String Password){
        
        Connection cnx=Connexion.getConnexion();
        
        PreparedStatement prepa ;
        
        String requet="select * from SECRETAIRE where EMAIL =? and PASSWORD=?";
        
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
            Logger.getLogger(Controleur_Login_Administrateur.class.getName()).log(Level.SEVERE, null, ex);
            
             return false;
        }
       
     
    }
	


}
