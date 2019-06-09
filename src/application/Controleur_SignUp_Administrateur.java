package application;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_Administrator_SignUp;
import DAO.DAO_CREATION_MEDECIIN;
//import DAO.DAO_Administrator_SignUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class Controleur_SignUp_Administrateur implements Initializable {
	
	@FXML
	private TextField emailTxt;
	@FXML
	private TextField id_Txt;
	@FXML
	private TextField adress_Txt;
	@FXML
	private TextField nomTxt;
	@FXML
	private TextField prenomTxt;
	
	@FXML
	private PasswordField passwordTxt;
	@FXML
	 Label L1;
	@FXML
	 Label L2;
	@FXML
	 Label L3;
	@FXML
	 Label L4;
	@FXML
	 Label L5;
	
	@FXML
	 Label L6;
	@FXML
	 Label L7;
	
	public void BtnAnnuler() throws IOException {
		nomTxt.setText("");
		prenomTxt.setText("");
		emailTxt.setText("");
		emailTxt.setText("");
		passwordTxt.setText("");
		
		
		L1.setText("");
		L2.setText("");
		L3.setText("");
		L4.setText("");
		L5.setText("");
		L6.setText("");
		L7.setText("");
	}
	

	public boolean Nom_Valid() {
		String nom = nomTxt.getText();
		if(
				nom.matches("[A-Za-z]*")
				) {
			L1.setText("");
		return true ;
		}
		else
			return false;
		
	}
	
	public boolean PasswordValide() {
		String passwordText = passwordTxt.getText();
		if(
				passwordText.length()<8
				) 
		{
		L4.setText("");	
		return false;
		}
		
		else 
			return true;
		
	}
	public boolean Prenom_Valid() {
		String Prenom = prenomTxt.getText();
		if(
				Prenom.matches("[A-Z a-z]*")
				) {
		L2.setText("");	
		return true;}
	else
			return false;
		
	}
	public boolean id_valide() {
		String iid = id_Txt.getText();
		if(iid.matches("[0-9]*")) {
			L3.setText("");
			return true;
			
		}
		return false;
		
		
	}
	public boolean Email_Valid() {
		
		Pattern PatEmail = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		
		Matcher matcher =PatEmail.matcher(emailTxt.getText()) ;
		if(matcher.find() && matcher.group().equals(emailTxt.getText()))
			{L5.setText("");
			return true;}
			else 
				return false;
	}
	
	public boolean VideNom() {
	
	return nomTxt.getText().equals("");
	
		
	}
	
	public boolean VidePrenom() {
		
		return prenomTxt.getText().equals("");
		
			
		}
	
	public boolean emaivide() {
		
		return emailTxt.getText().equals("");
		
			
		}
	
	public boolean idvide() {
		
		return id_Txt.getText().equals("");
		
			
		}
	
	public boolean passvid() {
		
		return passwordTxt.getText().equals("");
		
			
		}
	
	public boolean adressvide() {
		
		return adress_Txt.getText().equals("");
		
			
		}
public void BtnEnvoyer() throws SQLException {
		
		
		
		
		

		 if (VideNom()) {
			L7.setText("you have to full all");
		}
		
			else if (VidePrenom()) {
				L7.setText("you have to full all");
			}
		

		else if (idvide()) {
				L7.setText("you have to full all");
			}
		else if (passvid()) {
			L7.setText("you have to full all");
		} 
		 
		else if (emaivide()) {
			L7.setText("you have to full all");
		}
		
		
		
		else if (adressvide()) {
			L7.setText("you have to full all");
		}
		
		
	
		
		
		else if (!Nom_Valid()) {
			
		L1.setText("name  not valid");	
			
		}
		
		else if(!Prenom_Valid()) {
			L2.setText("last name  not valid");
		}
		
		
		else if(!id_valide()) {
			L3.setText("the id is nuber");
			
		}
		
	  else if(!PasswordValide()) {
			
			L4.setText("you have to use 8 charracters ");
		}
		
		else if(!Email_Valid()) {
			L5.setText("Email not valid");
		}
		
		
	
		
		
		
		
		else {
			
			
			
			
			Adminstrateur_model administrator = new Adminstrateur_model();
			
			String nom = nomTxt.getText();
			String prenom = prenomTxt.getText();
			String email = emailTxt.getText();
			String MotPasse = passwordTxt.getText();
			String adress = adress_Txt.getText();
			String id = id_Txt.getText();
			int Id=Integer.parseInt(id);
			
			
			
		administrator.setNom(nom);
		administrator.setPrenom(prenom);
		administrator.setEmail(email);
		administrator.setAdress(adress);
		administrator.setId(Id);
		administrator.setPassword(MotPasse);
		
		
			int status = DAO_Administrator_SignUp.Ajouter(administrator);
			
			if (status == 2) {
						
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ADD administrator");
				alert.setHeaderText("Information");
				alert.setContentText("WE hsve ADDED A sectretary ");
				alert.showAndWait();
					
			} else if(status == 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD administrator");
				alert.setHeaderText("Information");
				alert.setContentText("WE COULD NOT add a administrator ");
				alert.showAndWait();

			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD administrator");
				alert.setHeaderText("Information");
				alert.setContentText("this account is slready exist");
				alert.showAndWait();
				}		
					}
		

	}
	
	
	
	
	 @FXML
	    public void Page_dAccueil (ActionEvent e) throws IOException {
	    	 	
	    		 Stage stage = new Stage();
	        	 Parent root = FXMLLoader.load(getClass().getResource("LOGIN_ADMINISTRATOR.fxml"));
	             Scene scene = new Scene(root);
	             stage.setScene(scene);
	             stage.setTitle("welcome administrotor");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();
	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	}
	

}
