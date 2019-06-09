package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_CREATION_DU_CONTABLE;
import DAO.DAO_CREATION_DU_SECRETAIRE;
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

public class controler_creation_comptable {
	
	
	
	

	@FXML
	private TextField TEXT_comptable_nom;
	@FXML
	private TextField TEXT_comptable_prenom;
	@FXML
	private TextField TEXT_comptable_email;
	@FXML
	private TextField TEXT_comptable_id;
	@FXML
	private TextField TEXT_comptable_adress;
	
	@FXML
	private PasswordField TEXT_comptable_password;
	@FXML
	 Label test_comptable_nom;
	@FXML
	 Label test_comptable_prenom;
	@FXML
	 Label test_comptable_email;
	@FXML
	 Label test_comptable_id;
	@FXML
	 Label test_comptable_adress;
	@FXML
	 Label test_comptable_password;
	 @FXML
	 Label test_comptable_globale;
	
	public void BtnAnnuler() throws IOException {
		TEXT_comptable_nom.setText("");
		TEXT_comptable_prenom.setText("");
		TEXT_comptable_email.setText("");
	
		TEXT_comptable_adress.setText("");
		TEXT_comptable_id.setText("");
		TEXT_comptable_password.setText("");
		
		test_comptable_nom.setText("");
		test_comptable_prenom.setText("");
		test_comptable_password.setText("");
		test_comptable_email.setText("");
		test_comptable_id.setText("");
		test_comptable_adress.setText("");
		test_comptable_globale.setText("");
	}

	public boolean Nom_Valid() {
		String nom = TEXT_comptable_nom.getText();
		if(
				nom.matches("[A-Za-z]*")
				) {
			test_comptable_nom.setText("");
		return true ;
		}
		else
			return false;
		
	}
	
	public boolean PasswordValide() {
		String passwordText = TEXT_comptable_password.getText();
		if(
				passwordText.length()<8
				) 
		{
			test_comptable_password.setText("");	
		return false;
		}
		
		else 
			return true;
		
	}
	public boolean Prenom_Valid() {
		String Prenom = TEXT_comptable_prenom.getText();
		if(
				Prenom.matches("[A-Z a-z]*")
				) {
			test_comptable_prenom.setText("");	
		return true;}
	else
			return false;
		
	}
	public boolean id_valide() {
		String iid = TEXT_comptable_id.getText();
		if(iid.matches("[0-9]*")) {
			test_comptable_id.setText("");
			return true;
			
		}
		return false;
		
		
	}
	public boolean Email_Valid() {
		
		Pattern PatEmail = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		
		Matcher matcher =PatEmail.matcher(TEXT_comptable_email.getText()) ;
		if(matcher.find() && matcher.group().equals(TEXT_comptable_email.getText()))
			{test_comptable_email.setText("");
			return true;}
			else 
				return false;
	}
	
	public boolean VideNom() {
	
	return TEXT_comptable_nom.getText().equals("");
	
		
	}
	
	public boolean VidePrenom() {
		
		return TEXT_comptable_prenom.getText().equals("");
		
			
		}
	
	public boolean emaivide() {
		
		return TEXT_comptable_email.getText().equals("");
		
			
		}
	
	public boolean idvide() {
		
		return TEXT_comptable_id.getText().equals("");
		
			
		}
	
	public boolean passvid() {
		
		return TEXT_comptable_password.getText().equals("");
		
			
		}
	
	public boolean adressvide() {
		
		return TEXT_comptable_adress.getText().equals("");
		
			
		}
	public void BtnEnvoyer() throws SQLException {
		
		
		
		
		

		 if (VideNom()) {
			 test_comptable_globale.setText("you have to full all");
		}
		
			else if (VidePrenom()) {
				test_comptable_globale.setText("you have to full all");
			}
		

		else if (idvide()) {
			test_comptable_globale.setText("you have to full all");
			}
		else if (passvid()) {
			test_comptable_globale.setText("you have to full all");
		} 
		 
		else if (emaivide()) {
			test_comptable_globale.setText("you have to full all");
		}
		
		
		
		else if (adressvide()) {
			test_comptable_globale.setText("you have to full all");
		}
		
		
	
		
		
		else if (!Nom_Valid()) {
			
			test_comptable_nom.setText("name  not valid");	
			
		}
		
		else if(!Prenom_Valid()) {
			test_comptable_prenom.setText("last name  not valid");
		}
		
		
		else if(!id_valide()) {
			test_comptable_id.setText("the id not valid");
			
		}
		
	  else if(!PasswordValide()) {
			
		  test_comptable_password.setText("you have to entered 8 characters ");
		}
		
		else if(!Email_Valid()) {
			test_comptable_email.setText("Email not valid");
		}
		
		
	
		
		
		
		
		else {
			
			
			
			
			comptable comptable = new comptable();
			
			String nom = TEXT_comptable_nom.getText();
			String prenom = TEXT_comptable_prenom.getText();
			String email =TEXT_comptable_email.getText();
			String MotPasse = TEXT_comptable_password.getText();
			String adress = TEXT_comptable_adress.getText();
			String id =TEXT_comptable_id.getText();
			int Id=Integer.parseInt(id);
			
			
			
			comptable.setNom(nom);
			comptable.setPrenom(prenom);
			comptable.setEmail(email);
			comptable.setAdress(adress);
			comptable.setId(Id);
			comptable.setPassword(MotPasse);
		    
	
			int status = DAO_CREATION_DU_CONTABLE.Ajouter(comptable);
			
			if (status == 2) {
						
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ADD DOCTOR");
				alert.setHeaderText("Information");
				alert.setContentText("WE hsve ADDED A DOCTOR ");
				alert.showAndWait();
					
			} else if(status == 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD DOCTOR");
				alert.setHeaderText("Information");
				alert.setContentText("WE COULD NOT add a doctor ");
				alert.showAndWait();

			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD DOCTOR");
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
	             stage.setTitle("welcome ADMinistrator");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();
	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	

	

	
	
	
	
	

	
	
	
	
	
	
	
	

}
