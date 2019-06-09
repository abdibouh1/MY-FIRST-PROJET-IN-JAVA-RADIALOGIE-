package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.Connexion;
import DAO.DAO_CREATION_EXAMEN;
import DAO.Dao_creation_du_salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Creation_du_slle  implements Initializable {
	
	
	
	
	@FXML
	private TextField numero_salle;

	
	
	@FXML
	private ComboBox<String> etat_sale;
	
	@FXML
	private ComboBox<String> tcknicien_sale;	

	
	@FXML
	private ComboBox<String> exam_of_sall;	
	
	
	

	public void BtnEnvoyer() throws SQLException {
		
		
		
		
		
		
		
		
		
			
			
			
			
		Slle Slle = new Slle();
			
			String numsle = numero_salle.getText();
			String etat = etat_sale.getValue();
			String  ecknicien = tcknicien_sale.getValue(); 
			String exam = exam_of_sall.getValue();
			
			int sle = Integer.parseInt(numsle);
			Slle.setEtat(etat);
			Slle.setNumsalle(sle);
			Slle.setExam(exam);
			Slle.setTecknicien(ecknicien);
	         
			int status = Dao_creation_du_salle.Ajouter(Slle);
			
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

	
	
	
	
	
	 @FXML
	    public void Page_dAccueil (ActionEvent e) throws IOException {
	    	 	
	    		 Stage stage = new Stage();
	        	 Parent root = FXMLLoader.load(getClass().getResource("WHAT_THE_ADMINISTRATOR_DO.fxml"));
	             Scene scene = new Scene(root);
	             stage.setScene(scene);
	             stage.setTitle("welcome doctor");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();
	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	

	

	
	
	
	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			try {
				
				String sttate[] = 
	                   { "able", "unable" }; 
				
			   
			     ObservableList<String> names = FXCollections.observableArrayList();
			     names.addAll(sttate);
			     etat_sale.setItems(names);
				
			
				
				
				
				
				String exm = "SELECT * from EMPLYEEYER";
				Connection conn = Connexion.getConnexion();
				PreparedStatement preparStat;

				ResultSet r;
				preparStat = conn.prepareStatement(exm);
				r = preparStat.executeQuery();
				ObservableList<String> nomemployer = FXCollections.observableArrayList();

				while (r.next()) {
					nomemployer.add(r.getString("NOM"));

				}
				tcknicien_sale.setItems(nomemployer);
                
				
				
				String exmm = "SELECT * from EXEMEN";
				Connection connn = Connexion.getConnexion();
				PreparedStatement preparStatt;

				ResultSet t;
				preparStatt = connn.prepareStatement(exmm);
				t = preparStatt.executeQuery();
				ObservableList<String> namesaa = FXCollections.observableArrayList();

				while (t.next()) {
					namesaa.add(t.getString("NOM"));

				}
				exam_of_sall.setItems(namesaa);
                
				
				
				
				
				
				
				
			} catch (Exception e) {

			}
		}


	
	
	
	
	

	
	

}
