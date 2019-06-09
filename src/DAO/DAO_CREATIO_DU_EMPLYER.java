package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.EMPLYER;
import application.MEDECIN;

public class DAO_CREATIO_DU_EMPLYER {
	
	
	
	
	
	
	
	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
		public static int Ajouter(EMPLYER EMPLYER) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			String requet="select * from  EMPLYEEYER where EMAIL =?";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setString(1, EMPLYER.getEmail());
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO  EMPLYEEYER(NOM,PRENOM,EMAIL,PASSWORD,ID,ADRESS) VALUES(?,?,?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, EMPLYER.getNom());
			preparStat.setString(2, EMPLYER.getPrenom());
			preparStat.setString(3, EMPLYER.getEmail());
			preparStat.setString(4, EMPLYER.getPassword());
			preparStat.setInt(5, EMPLYER.getId());
			preparStat.setString(6, EMPLYER.getAdress());
			
			
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
		







		
public static int Supprimer(EMPLYER EMPLYER) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "DELETE FROM EMPLYEEYER WHERE EMAIL=?";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			
			preparStat.setString(1, EMPLYER.getEmail());
			
			
			preparStat.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
			st = 0;
			return st;

		}
		        	
		st=2;
		return st;

}
	
	
	










public static int Modifier(EMPLYER EMPLYER) throws SQLException {
			int st = 1; 
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "UPDATE EMPLYEEYER SET NOM=?,PRENOM=?,PASSWORD=?,ID=?,ADRESS=? WHERE EMAIL=?";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			
			preparStat.setString(1, EMPLYER.getNom());
			preparStat.setString(2, EMPLYER.getPrenom());
			preparStat.setString(6, EMPLYER.getEmail());
			preparStat.setString(3, EMPLYER.getPassword());
			preparStat.setInt(4, EMPLYER.getId());
			preparStat.setString(5, EMPLYER.getAdress());
			
			
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
