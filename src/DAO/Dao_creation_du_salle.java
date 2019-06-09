package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.seretairemodel;

public class Dao_creation_du_salle {
	
	
	
	
	
	
	
	
	

	

	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
	public static int Ajouter(application.Slle Slle) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			String requet="select * from SLLE  where NUMEROSALLLE =? ";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setInt(1, Slle.getNumsalle());
		
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO SLLE  (NUMEROSALLLE,ETET,TECNICIEN,EXAMEN) VALUES(?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setInt(1, Slle.getNumsalle());
			preparStat.setString(2,Slle.getEtat());
			preparStat.setString(3, Slle.getTecknicien());
			preparStat.setString(4, Slle.getExam());
	
			
			
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
