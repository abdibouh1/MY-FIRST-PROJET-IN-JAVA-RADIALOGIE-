package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.MEDECIN;
import application.seretairemodel;

public class DAO_CREATION_DU_SECRETAIRE {
	
	
	
	
	
	

	

	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
	public static int Ajouter(seretairemodel seretairemodel) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			String requet="select * from SECRETAIRE  where EMAIL =? ";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setString(1, seretairemodel.getEmail());
		
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO SECRETAIRE  (NOM,PRENOM,EMAIL,PASSWORD,ID,ADRESS) VALUES(?,?,?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, seretairemodel.getNom());
			preparStat.setString(2, seretairemodel.getPrenom());
			preparStat.setString(3, seretairemodel.getEmail());
			preparStat.setString(4, seretairemodel.getPassword());
			preparStat.setInt(5, seretairemodel.getId());
			preparStat.setString(6, seretairemodel.getAdress());
			
			
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
		public static int Modifier(seretairemodel seretairemodel) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "UPDATE SECRETAIRE SET NOM=?,PRENOM=?,PASSWORD=?,ID=?,ADRESS=? WHERE EMAIL=?";
				
		try {
			
			preparStat = cnx.prepareStatement(Requete);
			
			preparStat.setString(1, seretairemodel.getNom());
			preparStat.setString(2, seretairemodel.getPrenom());
			preparStat.setString(6, seretairemodel.getEmail());
			preparStat.setString(3, seretairemodel.getPassword());
			preparStat.setInt(4, seretairemodel.getId());
			preparStat.setString(5, seretairemodel.getAdress());
			
			
			preparStat.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
			st = 0;
			return st;

		}
		        	
		st=2;
		return st;

}
		
		public static int Supprimer(seretairemodel seretairemodel) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			
		            	
		String Requete = "DELETE FROM SECRETAIRE WHERE EMAIL=?";
				
		try {
			
			preparStat = cnx.prepareStatement(Requete);
			
			preparStat.setString(1, seretairemodel.getEmail());
			
			
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
