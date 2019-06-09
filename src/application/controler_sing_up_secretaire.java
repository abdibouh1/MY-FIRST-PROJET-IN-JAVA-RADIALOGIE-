package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_CREATION_DU_SECRETAIRE;
import DAO.DAO_CREATION_MEDECIIN;
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

public class controler_sing_up_secretaire {
	
	
	
	
	
	
	@FXML
	private TextField text_secretaire_nom;
	@FXML
	private TextField text_secretaire_prenom;
	@FXML
	private TextField text_secretaire_email;
	@FXML
	private TextField text_secretaire_id;
	@FXML
	private TextField text_secretaire_adress;
	
	@FXML
	private PasswordField text_secretaire_password;
	@FXML
	 Label test_secretaire_nom;
	@FXML
	 Label test_secretaire_prenom;
	@FXML
	 Label test_secretaire_email;
	@FXML
	 Label test_secretaire_id;
	@FXML
	 Label test_secretaire_adress;
	@FXML
	 Label test_secretaire_password;
	 @FXML
	 Label test_secretaire_globale;
	
	public void BtnAnnuler() throws IOException {
		text_secretaire_nom.setText("");
		text_secretaire_prenom.setText("");
		text_secretaire_email.setText("");
	
		text_secretaire_adress.setText("");
		text_secretaire_id.setText("");
		text_secretaire_password.setText("");
		
		test_secretaire_nom.setText("");
		test_secretaire_prenom.setText("");
		test_secretaire_password.setText("");
		test_secretaire_email.setText("");
		test_secretaire_id.setText("");
		test_secretaire_adress.setText("");
		test_secretaire_globale.setText("");
	}

	public boolean Nom_Valid() {
		String nom = text_secretaire_nom.getText();
		if(
				nom.matches("[A-Za-z]*")
				) {
			test_secretaire_nom.setText("");
		return true ;
		}
		else
			return false;
		
	}
	
	public boolean PasswordValide() {
		String passwordText = text_secretaire_password.getText();
		if(
				passwordText.length()<8
				) 
		{
			test_secretaire_password.setText("");	
		return false;
		}
		
		else 
			return true;
		
	}
	public boolean Prenom_Valid() {
		String Prenom = text_secretaire_prenom.getText();
		if(
				Prenom.matches("[A-Z a-z]*")
				) {
			test_secretaire_prenom.setText("");	
		return true;}
	else
			return false;
		
	}
	public boolean id_valide() {
		String iid = text_secretaire_id.getText();
		if(iid.matches("[0-9]*")) {
			test_secretaire_id.setText("");
			return true;
			
		}
		return false;
		
		
	}
	public boolean Email_Valid() {
		
		Pattern PatEmail = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		
		Matcher matcher =PatEmail.matcher(text_secretaire_email.getText()) ;
		if(matcher.find() && matcher.group().equals(text_secretaire_email.getText()))
			{test_secretaire_email.setText("");
			return true;}
			else 
				return false;
	}
	
	public boolean VideNom() {
	
	return text_secretaire_nom.getText().equals("");
	
		
	}
	
	public boolean VidePrenom() {
		
		return text_secretaire_prenom.getText().equals("");
		
			
		}
	
	public boolean emaivide() {
		
		return text_secretaire_email.getText().equals("");
		
			
		}
	
	public boolean idvide() {
		
		return text_secretaire_id.getText().equals("");
		
			
		}
	
	public boolean passvid() {
		
		return text_secretaire_password.getText().equals("");
		
			
		}
	
	public boolean adressvide() {
		
		return text_secretaire_adress.getText().equals("");
		
			
		}
	public void BtnEnvoyer() throws SQLException {
		
		
		
		
		

		 if (VideNom()) {
			 test_secretaire_globale.setText("you have to full all");
		}
		
			else if (VidePrenom()) {
				test_secretaire_globale.setText("you have to full all");
			}
		

		else if (idvide()) {
			test_secretaire_globale.setText("you have to full all");
			}
		else if (passvid()) {
			test_secretaire_globale.setText("you have to full all");
		} 
		 
		else if (emaivide()) {
			test_secretaire_globale.setText("you have to full all");
		}
		
		
		
		else if (adressvide()) {
			test_secretaire_globale.setText("you have to full all");
		}
		
		
	
		
		
		else if (!Nom_Valid()) {
			
			test_secretaire_nom.setText("name  not valid");	
			
		}
		
		else if(!Prenom_Valid()) {
			test_secretaire_prenom.setText("last name  not valid");
		}
		
		
		else if(!id_valide()) {
			test_secretaire_id.setText("the id is nuber");
			
		}
		
	  else if(!PasswordValide()) {
			
		  test_secretaire_password.setText("you have to use 8 charracters ");
		}
		
		else if(!Email_Valid()) {
			test_secretaire_email.setText("Email not valid");
		}
		
		
	
		
		
		
		
		else {
			
			
			
			
			seretairemodel seretairemodel = new seretairemodel();
			
			String nom = text_secretaire_nom.getText();
			String prenom = text_secretaire_prenom.getText();
			String email = text_secretaire_email.getText();
			String MotPasse = text_secretaire_password.getText();
			String adress = text_secretaire_adress.getText();
			String id = text_secretaire_id.getText();
			int Id=Integer.parseInt(id);
			
			
			
			seretairemodel.setNom(nom);
			seretairemodel.setPrenom(prenom);
			seretairemodel.setEmail(email);
			seretairemodel.setAdress(adress);
			seretairemodel.setId(Id);
			seretairemodel.setPassword(MotPasse);
		
	
			int status = DAO_CREATION_DU_SECRETAIRE.Ajouter(seretairemodel);
			
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
	             stage.setTitle("welcome administrotor");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();
	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	

	

	
	
	
	
	

}
