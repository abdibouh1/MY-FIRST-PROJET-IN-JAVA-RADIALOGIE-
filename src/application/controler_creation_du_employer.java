package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_CREATION_DU_SECRETAIRE;
import DAO.DAO_CREATIO_DU_EMPLYER;
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
import javafx.stage.Stage;

public class controler_creation_du_employer {
	
	
	
	
	
	

	@FXML
	private TextField TEXT_EMPYER_nom;
	@FXML
	private TextField TEXT_EMPYER_prenom;
	@FXML
	private TextField TEXT_EMPYER_email;
	@FXML
	private TextField TEXT_EMPYER_id;
	@FXML
	private TextField TEXT_EMPYER_adress;
	
	@FXML
	private PasswordField TEXT_EMPYER_password;
	@FXML
	 Label test_emlyer_nom;
	@FXML
	 Label test_emlyer_prenom;
	@FXML
	 Label test_emlyer_email;
	@FXML
	 Label test_emlyer_id;
	@FXML
	 Label test_emlyer_adress;
	@FXML
	 Label test_emlyer_password;
	 @FXML
	 Label test_emlyer_globale;
	
	public void BtnAnnuler() throws IOException {
		TEXT_EMPYER_nom.setText("");
		TEXT_EMPYER_prenom.setText("");
		TEXT_EMPYER_email.setText("");
	
		TEXT_EMPYER_adress.setText("");
		TEXT_EMPYER_id.setText("");
		TEXT_EMPYER_password.setText("");
		
		test_emlyer_nom.setText("");
		test_emlyer_prenom.setText("");
		test_emlyer_password.setText("");
		test_emlyer_email.setText("");
		test_emlyer_id.setText("");
		test_emlyer_adress.setText("");
		test_emlyer_globale.setText("");
	}

	public boolean Nom_Valid() {
		String nom = TEXT_EMPYER_nom.getText();
		if(
				nom.matches("[A-Za-z]*")
				) {
			test_emlyer_nom.setText("");
		return true ;
		}
		else
			return false;
		
	}
	
	public boolean PasswordValide() {
		String passwordText = TEXT_EMPYER_password.getText();
		if(
				passwordText.length()<8
				) 
		{
			TEXT_EMPYER_password.setText("");	
		return false;
		}
		
		else 
			return true;
		
	}
	public boolean Prenom_Valid() {
		String Prenom =TEXT_EMPYER_prenom.getText();
		if(
				Prenom.matches("[A-Z a-z]*")
				) {
			test_emlyer_prenom.setText("");	
		return true;}
	else
			return false;
		
	}
	public boolean id_valide() {
		String iid = TEXT_EMPYER_id.getText();
		if(iid.matches("[0-9]*")) {
			test_emlyer_id.setText("");
			return true;
			
		}
		return false;
		
		
	}
	public boolean Email_Valid() {
		
		Pattern PatEmail = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		
		Matcher matcher =PatEmail.matcher(TEXT_EMPYER_email.getText()) ;
		if(matcher.find() && matcher.group().equals(TEXT_EMPYER_email.getText()))
			{test_emlyer_email.setText("");
			return true;}
			else 
				return false;
	}
	
	public boolean VideNom() {
	
	return TEXT_EMPYER_nom.getText().equals("");
	
		
	}
	
	public boolean VidePrenom() {
		
		return TEXT_EMPYER_prenom.getText().equals("");
		
			
		}
	
	public boolean emaivide() {
		
		return TEXT_EMPYER_email.getText().equals("");
		
			
		}
	
	public boolean idvide() {
		
		return TEXT_EMPYER_id.getText().equals("");
		
			
		}
	
	public boolean passvid() {
		
		return TEXT_EMPYER_password.getText().equals("");
		
			
		}
	
	public boolean adressvide() {
		
		return  TEXT_EMPYER_adress.getText().equals("");
		
			
		}
	public void BtnEnvoyer() throws SQLException {
		
		
		
		
		

		 if (VideNom()) {
			 test_emlyer_globale.setText("you have to full all");
		}
		
			else if (VidePrenom()) {
				test_emlyer_globale.setText("you have to full all");
			}
		

		else if (idvide()) {
			test_emlyer_globale.setText("you have to full all");
			}
		else if (passvid()) {
			test_emlyer_globale.setText("you have to full all");
		} 
		 
		else if (emaivide()) {
			test_emlyer_globale.setText("you have to full all");
		}
		
		
		
		else if (adressvide()) {
			test_emlyer_globale.setText("you have to full all");
		}
		
		
	
		
		
		else if (!Nom_Valid()) {
			
			test_emlyer_nom.setText("name  not valid");	
			
		}
		
		else if(!Prenom_Valid()) {
			test_emlyer_prenom.setText("last name  not valid");
		}
		
		
		else if(!id_valide()) {
			test_emlyer_id.setText("the id is nuber");
			
		}
		
	  else if(!PasswordValide()) {
			
		  test_emlyer_password.setText("you have to use 8 characters ");
		}
		
		else if(!Email_Valid()) {
			test_emlyer_email.setText("Email not valid");
		}
		
		
	
		
		
		
		
		else {
			
			
			
			
			EMPLYER EMPLYER = new EMPLYER();
			
			String nom = TEXT_EMPYER_nom.getText();
			String prenom = TEXT_EMPYER_prenom.getText();
			String email = TEXT_EMPYER_email.getText();
			String MotPasse = TEXT_EMPYER_password.getText();
			String adress = TEXT_EMPYER_adress.getText();
			String id = TEXT_EMPYER_id.getText();
			int Id=Integer.parseInt(id);
			
			
			
			EMPLYER.setNom(nom);
			EMPLYER.setPrenom(prenom);
			EMPLYER.setEmail(email);
			EMPLYER.setAdress(adress);
			EMPLYER.setId(Id);
			EMPLYER.setPassword(MotPasse);
		
	
			int status = DAO_CREATIO_DU_EMPLYER.Ajouter(EMPLYER);
			
			if (status == 2) {
				if (status == 2) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("ADD emplyee");
					alert.setHeaderText("Information");
					alert.setContentText("WE hsve ADDED A emplyee ");
					alert.showAndWait();
						
				} else if(status == 0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ADD DOCTOR");
					alert.setHeaderText("Information");
					alert.setContentText("WE COULD NOT add a emplyee ");
					alert.showAndWait();

				}
				else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ADD emplyee");
					alert.setHeaderText("Information");
					alert.setContentText("this account is slready exist");
					alert.showAndWait();
					}		
				
			}
		}

	}
	
	
	
	
	 @FXML
	    public void Page_dAccueil (ActionEvent e) throws IOException {
	    	 	
	    		 Stage stage = new Stage();
	        	 Parent root = FXMLLoader.load(getClass().getResource("WHAT_THE_ADMINISTRATOR_DO.fxml"));
	             Scene scene = new Scene(root);
	             stage.setScene(scene);
	             stage.setTitle("welcome administrotor");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();
	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	

	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
