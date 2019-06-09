package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Adminstrateur_model;
import application.Patient;

public class DAO_ajouter_patient {
	
	
	
	
	
	

	public static Connection conn = Connexion.getConnexion();
	public static PreparedStatement preparStat;
	public static ResultSet rs;
	
		public static int Ajouter(Patient Patient) throws SQLException {
			int st = 1; 
			Connection cnx=Connexion.getConnexion();
			
			String requet="SELECT * from  PATIENT where CIN =?";
		        	
			preparStat=cnx.prepareStatement(requet);
			preparStat.setInt(1, Patient.getCIN());
		            ResultSet rs = preparStat.executeQuery();
		                
		            if(rs.next()){
			              
		                return st;
		            }
		            else {
		            	
		String Requete = "INSERT INTO  PATIENT(NOM,LASTNAME,DATEBIRTH,CIN,PHONENUMBER,ADRESS) VALUES(?,?,?,?,?,?)";
				
		try {
			
			preparStat = conn.prepareStatement(Requete);
			preparStat.setString(1, Patient.getNom());
			preparStat.setString(2, Patient.getPrenom());
			preparStat.setString(3, Patient.getDate_ofbirth());
			preparStat.setInt(4, Patient.getCIN());
			preparStat.setInt(5, Patient.getPhonenumber());
			preparStat.setString(6, Patient.getAdress());
			
			
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
