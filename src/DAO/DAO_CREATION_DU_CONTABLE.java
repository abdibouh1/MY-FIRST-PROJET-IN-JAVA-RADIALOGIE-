package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.EMPLYER;
import application.MEDECIN;
import application.comptable;

public class DAO_CREATION_DU_CONTABLE {
	
	
	
	
	
	
	

	
	
	
	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
		public static int Ajouter(comptable comptable) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			String requet="select * from  COOMPTABLE where EMAIL =?";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setString(1, comptable.getEmail());
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO  COOMPTABLE(NOM,PRENOM,EMAIL,PASSWORD,ID,ADRESS) VALUES(?,?,?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, comptable.getNom());
			preparStat.setString(2, comptable.getPrenom());
			preparStat.setString(3, comptable.getEmail());
			preparStat.setString(4, comptable.getPassword());
			preparStat.setInt(5, comptable.getId());
			preparStat.setString(6, comptable.getAdress());
			
			
			preparStat.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
			st = 0;
			return st;

		}
		        	}
		st=2;
		return st;
	}
	
		
		
		
		
		
		


		
public static int Supprimer(comptable COOMPTABLE) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "DELETE FROM COOMPTABLE WHERE EMAIL=?";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			
			preparStat.setString(1, COOMPTABLE.getEmail());
			
			
			preparStat.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
			st = 0;
			return st;

		}
		        	
		st=2;
		return st;

}
	
	
	










public static int Modifier(comptable COOMPTABLE) throws SQLException {
			int st = 1; 
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "UPDATE COOMPTABLE SET NOM=?,PRENOM=?,PASSWORD=?,ID=?,ADRESS=? WHERE EMAIL=?";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			
			preparStat.setString(1, COOMPTABLE.getNom());
			preparStat.setString(2, COOMPTABLE.getPrenom());
			preparStat.setString(6, COOMPTABLE.getEmail());
			preparStat.setString(3, COOMPTABLE.getPassword());
			preparStat.setInt(4, COOMPTABLE.getId());
			preparStat.setString(5, COOMPTABLE.getAdress());
			
			
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
