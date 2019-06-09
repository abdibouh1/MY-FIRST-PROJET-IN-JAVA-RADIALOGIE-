package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Patient;
import application.rendevou;
import javafx.scene.control.ComboBox;

public class DAO_creation_du_rendevous {
	
	
	
	
	
	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	public static ResultSet r;
		public static int Ajouter(rendevou rendevou) throws SQLException {
			int st = 1; 
			Connection cnx=Connexion.getConnexion();
			
			String requet="SELECT * from  RENDEVOUS where CIN =?";
		     String req = "SELECT * from PATIENT";   	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setInt(1, rendevou.getCin());
		    ResultSet rs = preparStat.executeQuery();
		    ResultSet r = preparStat.executeQuery();           
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO  RENDEVOUS(NOM,PRENOM,CIN,PHNUMBER,DATEBIRTH,EXAM,TIME) VALUES(?,?,?,?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, rendevou.getNom() );
			preparStat.setString(2, rendevou.getPrenom());
			preparStat.setInt(3, rendevou.getCin());
			preparStat.setInt(4,rendevou.getPhonnenumber() );
			preparStat.setString(5, rendevou.getDaterendevous());
			preparStat.setString(6, rendevou.getExam());
			preparStat.setString(7, rendevou.getTimme());
			
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
