package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.seretairemodel;

public class DAO_CREATION_EXAMEN {

	

	
	
	

	

	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
	public static int Ajouter(application.examen examen) throws SQLException {
			int st = 1; /* 1 compte deja exist , 0 l ajou non efectue , 2 good job*/
			Connection cnx=Connexion.getConnexion();
			
			String requet="select * from EXEMEN  where NOM =? ";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setString(1, examen.getNom());
		
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO EXEMEN  (NOM,ETATT,SALLE) VALUES(?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, examen.getNom());
			preparStat.setString(2,examen.getEtat() );
			preparStat.setInt(3, examen.getSalle());
	
			
			
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
	

}
