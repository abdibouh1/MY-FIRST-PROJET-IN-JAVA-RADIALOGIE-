package application;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_CREATION_DU_SECRETAIRE;
import DAO.DAO_ajouter_patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class contriler_creation_du_patient {
	
	

	@FXML
	private TextField nom_text_patient;
	@FXML
	private TextField prenom_text_patient;
	@FXML
	private TextField cin_text_patient;
	@FXML
	private  DatePicker datebirth_text_patient;
	@FXML
	private TextField phnumber_text_patient;
	
	@FXML
	private TextField adress_text_patient;
	
	@FXML
	 Label nom_test_patient;

	@FXML
	 Label prenom_test_patient;
	@FXML
	 Label cin_test_patient;
	@FXML
	 Label datebirth_test_patient;
	@FXML
	 Label phnumber_test_patient;
	@FXML
	 Label adress_test_patient;
	@FXML
	 Label globale_test_patient1;
	

	
	
	
	
	
	

	public void BtnAnnuler() throws IOException {
		nom_text_patient.setText("");
		prenom_text_patient.setText("");
		cin_text_patient.setText("");
	
		datebirth_text_patient.setValue(null);
		phnumber_text_patient.setText("");
		adress_text_patient.setText("");
		
		nom_test_patient.setText("");
		prenom_test_patient.setText("");
		cin_test_patient.setText("");
		datebirth_test_patient.setText("");
		phnumber_test_patient.setText("");
		adress_test_patient.setText("");
		globale_test_patient1.setText("");
	}

	public boolean Nom_Valid() {
		String nom = nom_text_patient.getText();
		if(
				nom.matches("[A-Za-z]*")
				) {
			nom_test_patient.setText("");
		return true ;
		}
		else
			return false;
		
	}
	
	
	public boolean Prenom_Valid() {
		String Prenom = prenom_text_patient.getText();
		if(
				Prenom.matches("[A-Z a-z]*")
				) {
			prenom_test_patient.setText("");	
		return true;}
	else
			return false;
		
	}
	public boolean id_valide() {
		String iid = cin_text_patient.getText();
		if(iid.matches("[0-9]*")) {
			cin_test_patient.setText("");
			return true;
			
		}
		return false;
		
		
	}
	
	
	public boolean phonevaiiiide() {
		String passwordText = phnumber_text_patient.getText();
		if(
				passwordText.length()<8
				) 
		{
			phnumber_test_patient.setText("");	
		return false;
		}
		
		else 
			return true;
		
	}
	
	
	
	
	
	
	
	
	

	public boolean thecinisvalide() {
		String passwordText = phnumber_text_patient.getText();
		if(
				passwordText.length()<8
				) 
		{
				
		return false;
		}
		
		else 
			phnumber_test_patient.setText("");
			return true;
		
	}
	
	
	
	
	
	

	public boolean cinvalideissupde8() {
		String passwordText = cin_text_patient.getText();
		if(
				passwordText.length()<8
				) 
		{
				
		return false;
		}
		
		else 
			cin_test_patient.setText("");
			return true;
		
	}
	

	
	
	
	
	public boolean phonevalide() {
		String iid = phnumber_text_patient.getText();
		if(iid.matches("[0-9]*")) {
			phnumber_test_patient.setText("");
			return true;
			
		}
		return false;
		
		
	}

	public boolean VideNom() {
		globale_test_patient1.setText("");
	return nom_text_patient.getText().equals("");
	
		
	}
	
	public boolean VidePrenom() {
		globale_test_patient1.setText("");
		return prenom_text_patient.getText().equals("");
		
			
		}
	
	public boolean cinvide() {
		globale_test_patient1.setText("");
		return cin_text_patient.getText().equals("");
		
			
		}
	
	

	

	   public static boolean isValidDate(String a) {
		   
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:ms");
	        dateFormat.setLenient(false);
	        try {
	            dateFormat.parse(a.trim());
	        } catch (ParseException pe) {
	            return false;
	        }
	        return true;
	    }
		
			
		
	
	public boolean idvide() {
		 String r= datebirth_text_patient.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return r.isEmpty();
		
			
		}
	
	
	public boolean phonenumbervide() {
		globale_test_patient1.setText("");
		return phnumber_text_patient.getText().equals("");
		
			
		}
	
	
	
	
	

	public boolean adressvide() {
		globale_test_patient1.setText("");
		return adress_text_patient.getText().equals("");
		
			
		}
	
	
	

	public boolean dateeevalode()  {
		 String r= datebirth_text_patient.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		 try {
			Date d = new SimpleDateFormat("dd/MM/yyyy").parse(r);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	return true;
		 
	}
	
		

	
	

	
	
	
	
	
	public void BtnEnvoyer() throws SQLException {
		
		
		
		
		

		 if (VideNom()) {
			 globale_test_patient1.setText("you have to full all");
		}
		
			else if (VidePrenom()) {
				globale_test_patient1.setText("you have to full all");
			}
		

		else if (cinvide()) {
			globale_test_patient1.setText("you have to full all");
		} 
		 
		else if (phonenumbervide()) {
			globale_test_patient1.setText("you have to full all");
		}
		
		
		
		else if (adressvide()) {
			globale_test_patient1.setText("you have to full all");
		}
		
		
	
		
		
		else if (!Nom_Valid()) {
			
			nom_test_patient.setText("name  not valid");	
			
		}
		
		else if(!Prenom_Valid()) {
			prenom_test_patient.setText("last name  not valid");
		}
		
		
		else if(!id_valide()) {
			cin_test_patient.setText("the cin is not correct");
			
		}
		
		 

		else if(!cinvalideissupde8()) {
			cin_test_patient.setText("the cin is not correct");
			
		}
		
		 else if(!phonevalide()) {
		  phnumber_test_patient.setText("the phonne nuber is not correct");	
       
		}
		
		

		 
	  else if(!thecinisvalide()) {
		  phnumber_test_patient.setText("the phonne nuber is not correct");	
       
		}
		
	 
		 
	
		
		
		
		else {
			
			
			
			
			Patient Patient = new Patient();
			
			String nom = nom_text_patient.getText();
			
			String prenom = prenom_text_patient.getText();
			String adress = adress_text_patient.getText();
			String phonenumbe = phnumber_text_patient.getText();
			int phonenumber=Integer.parseInt(phonenumbe);	
		
			String id = cin_text_patient.getText();
			int Id=Integer.parseInt(id);
			
			
		/*	String brdat = datebirth_text_patient.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date_ofbirth = null ;
			try {
				date_ofbirth = new SimpleDateFormat("dd/MM/yyyy").parse(brdat);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			String brdat = datebirth_text_patient.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			
			Patient.setNom(nom);
			Patient.setPrenom(prenom);
			Patient.setAdress(adress);
			Patient.setCIN(Id);
			Patient.setPhonenumber(phonenumber);
			Patient.setDate_ofbirth(brdat);
		    
	
			int status = DAO_ajouter_patient.Ajouter(Patient);
			
			if (status == 2) {
				
				
				
				
				
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ADD sectretary");
				alert.setHeaderText("Information");
				alert.setContentText("WE hsve ADDED A sectretary ");
				alert.showAndWait();
					
			} else if(status == 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD DOCTOR");
				alert.setHeaderText("Information");
				alert.setContentText("WE COULD NOT add a sectretary ");
				alert.showAndWait();

			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD sectretary");
				alert.setHeaderText("Information");
				alert.setContentText("this account is slready exist");
				alert.showAndWait();
				}		
			
				
				
				
				
				
				
			}

		}

	
	
	
	
	
	 @FXML
	    public void Page_dAccueil (ActionEvent e) throws IOException {
	    	 	
	    		 Stage stage = new Stage();
	        	 Parent root = FXMLLoader.load(getClass().getResource("WHAT_THE_ADMINISTRATOR_DO.fxml"));
	             Scene scene = new Scene(root);
	             stage.setScene(scene);
	             stage.setTitle("Radiology");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();

           



	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	

	 

	
	
	
	
	

	
	
	
	
	
	
	
	

}
