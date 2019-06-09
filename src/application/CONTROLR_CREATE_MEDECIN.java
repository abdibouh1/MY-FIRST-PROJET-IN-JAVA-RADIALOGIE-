package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.Connexion;
import DAO.DAO_Administrator_SignUp;
import DAO.DAO_CREATION_MEDECIIN;
import DAO.DAO_LOGIN_ADMIN;
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

public class CONTROLR_CREATE_MEDECIN {
	
	
	 
	
	@FXML
	private TextField EMT;
	@FXML
	private TextField IDTT;
	@FXML
	private TextField ADT;
	@FXML
	private TextField NAT;
	@FXML
	private TextField LNT;
	
	@FXML
	private PasswordField PAT;
	@FXML
	 Label L11;
	@FXML
	 Label L12;
	
	@FXML
	 Label L13;
	@FXML
	 Label L14;
	
	@FXML
	 Label L15;

	
	@FXML
	 Label L16;

	@FXML
	 Label L17;
	
	public void BtnAnnuler() throws IOException   {
		NAT.setText("");
		LNT.setText("");
		EMT.setText("");
		PAT.setText("");
		IDTT.setText("");
		ADT.setText("");
		
		L11.setText("");
		L12.setText("");
		L13.setText("");
		L14.setText("");
		L15.setText("");
		L16.setText("");
		L17.setText("");
		
	}
	
	

	public boolean Nom_Valid() {
		String nom = NAT.getText();
		if(
				nom.matches("[A-Za-z]*")
				) {
			L11.setText("");
		return true ;
		}
		else
			return false;
		
	}
	
	public boolean PasswordValide() 
	{
		String passwordText = PAT.getText();
		if(
				passwordText.length()<8
				) 
		{
		L14.setText("");	
		return false;
		}
		
		else 
			return true;
		
	}
	public boolean Prenom_Valid() {
		String Prenom = LNT.getText();
		if(
				Prenom.matches("[A-Z a-z]*")
				) {
		L12.setText("");	
		return true;}
	else
			return false;
		
	}
	public boolean id_valide() {
		String iid = IDTT.getText();
		if(iid.matches("[0-9]*")) {
			L13.setText("");
			return true;
			
		}
		return false;
		
		
	}
	public boolean Email_Valid() {
		
		
		
		Pattern PatEmail = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		
		Matcher matcher =PatEmail.matcher(EMT.getText()) ;
		if(matcher.find() && matcher.group().equals(EMT.getText()))
			{
			L15.setText("");
			return true;
			}
			else 
				return false;
	}
	
	public boolean VideNom() {
	
	return NAT.getText().equals("");
	
		
	}
	
	public boolean VidePrenom() {
		
		return LNT.getText().equals("");
		
			
		}
	
	public boolean emaivide() {
		
		return EMT.getText().equals("");
		
			
		}
	
	public boolean idvide() {
		
		return IDTT.getText().equals("");
		
			
		}
	
	public boolean passvid() {
		
		return PAT.getText().equals("");
		
			
		}
	
	public boolean adressvide() {
		
		return ADT.getText().equals("");
		
			
		}
	public void BtnEnvoyer() throws SQLException {
		
		
		
		
		

		 if (VideNom()) {
			L17.setText("you have to full all");
		}
		
			else if (VidePrenom()) {
				L17.setText("you have to full all");
			}
		

		else if (idvide()) {
				L17.setText("you have to full all");
			}
		else if (passvid()) {
			L17.setText("you have to full all");
		} 
		 
		else if (emaivide()) {
			
			L17.setText("you have to full all");
		
		}
		
		
		
		else if (adressvide()) {
		
			L17.setText("you have to full all");
		}
		
		
	
		
		
		else if (!Nom_Valid()) {
			
		L11.setText("name  not valid");	
			
		}
		
		else if(!Prenom_Valid()) {
			L12.setText("last name  not valid");
		}
		
		
		else if(!id_valide()) {
			L13.setText("the id is nuber");
			
		}
		
	  else if(!PasswordValide()) {
			
			L14.setText("you have to use 8 charracters ");
		}
		
		else if(!Email_Valid()) {
			L15.setText("Email not valid");
		}
		
		
	
		
		
		
		
		else {
			
		
		
		
			MEDECIN MEDECIN = new MEDECIN();

		
		
		
		String nom = NAT.getText();
		String prenom = LNT.getText();
		String email = EMT.getText();
		String MotPasse = PAT.getText();
		String adress = ADT.getText();
		String iId = IDTT.getText();
		int IIId=Integer.parseInt(iId);
		
		
		
		
		
		
		
		
		
		
		 if (VideNom()) {
			L17.setText("you have to full all");
		}
		
			else if (VidePrenom()) {
				L17.setText("you have to full all");
			}
		

		else if (idvide()) {
				L17.setText("you have to full all");
			}
		else if (passvid()) {
			L17.setText("you have to full all");
		} 
		 
		else if (emaivide()) {
			L17.setText("you have to full all");
		}
		
		
		
		else if (adressvide()) {
			L17.setText("you have to full all");
		}
		
		
	
		
		
		else if (!Nom_Valid()) {
			
		L11.setText("name  not valid");	
			
		}
		
		else if(!Prenom_Valid()) {
			L12.setText("last name  not valid");
		}
		
		
		else if(!id_valide()) {
			L13.setText("the id is nuber");
			
		}
		
	  else if(!PasswordValide()) {
			
			L14.setText("you have to use 8 charracters ");
		}
		
		else if(!Email_Valid()) {
			L15.setText("Email not valid");
		}
		
	else {
			
		MEDECIN.setNom(nom);
		MEDECIN.setEmail(email);
		MEDECIN.setAdress(adress);
		MEDECIN.setPrenom(prenom);
		MEDECIN.setId(IIId);
		MEDECIN.setPassword(MotPasse);
		
		
			int status = DAO_CREATION_MEDECIIN.Ajouter(MEDECIN);
			
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
						
		}		}

	
	
	
	
	
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
