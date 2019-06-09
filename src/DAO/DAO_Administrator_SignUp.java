package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Adminstrateur_model;


public class DAO_Administrator_SignUp {

	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
		public static int Ajouter(Adminstrateur_model administrator) throws SQLException {
			int st = 1; 
			Connection cnx=Connexion.getConnexion();
			
			String requet="SELECT * from  ADMINSTRATEUR where EMAIL =?";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setString(1, administrator.getEmail());
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO  ADMINSTRATEUR(NOM,PRENOM,EMAIL,PASSWORD,ID,ADRESS) VALUES(?,?,?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, administrator.getNom());
			preparStat.setString(2, administrator.getPrenom());
			preparStat.setString(3, administrator.getEmail());
			preparStat.setString(4, administrator.getPassword());
			preparStat.setInt(5, administrator.getId());
			preparStat.setString(6, administrator.getAdress());
			
			
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
