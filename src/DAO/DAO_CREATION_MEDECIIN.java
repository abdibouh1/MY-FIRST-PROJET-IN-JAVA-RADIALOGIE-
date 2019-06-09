package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Adminstrateur_model;
import application.MEDECIN;

public class DAO_CREATION_MEDECIIN {
	
	

	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
	public static int Ajouter(MEDECIN MEDECIN) throws SQLException {
			int st = 1; 
			Connection cnx=Connexion.getConnexion();
			
			String requet="select * from MEDEECIN  where EMAIL =? ";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setString(1, MEDECIN.getEmail());
		
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		              
		            }
		            else {
		            	
		String Requete = "INSERT INTO MEDEECIN  (NOM,PRENOM,EMAIL,PASSWORD,ID,ADRESS) VALUES(?,?,?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, MEDECIN.getNom());
			preparStat.setString(2, MEDECIN.getPrenom());
			preparStat.setString(3, MEDECIN.getEmail());
			preparStat.setString(4, MEDECIN.getPassword());
			preparStat.setInt(5, MEDECIN.getId());
			preparStat.setString(6, MEDECIN.getAdress());
		    preparStat.executeQuery();

		}
		catch (SQLException ex) {
			ex.printStackTrace();
			st = 0;
			return st;

		}
		        	}
		st=2;
		return st;

}
public static int Modifier(MEDECIN MEDECIN) throws SQLException {
			int st = 1; 
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "UPDATE MEDEECIN SET NOM=?,PRENOM=?,PASSWORD=?,ID=?,ADRESS=? WHERE EMAIL=?";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			
			preparStat.setString(1, MEDECIN.getNom());
			preparStat.setString(2, MEDECIN.getPrenom());
			preparStat.setString(6, MEDECIN.getEmail());
			preparStat.setString(3, MEDECIN.getPassword());
			preparStat.setInt(4, MEDECIN.getId());
			preparStat.setString(5, MEDECIN.getAdress());
			
			
			preparStat.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
			st = 0;
			return st;

		}
		        	
		st=2;
		return st;

}
		
public static int Supprimer(MEDECIN selectedMedcine) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "DELETE FROM MEDEECIN WHERE EMAIL=?";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			
			preparStat.setString(1, selectedMedcine.getEmail());
			
			
			preparStat.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
			st = 0;
			return st;

		}
		        	
		st=2;
		return st;

}
	
	
	
	
	
	
	
	
	
	
	

}
