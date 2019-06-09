package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WHAT_THE_SECRETAIRE_DO {
	
	
	
	
	
	
	
	
	 @FXML
	    public void Page_dAccueil (ActionEvent e) throws IOException {
	    	 	
	    		 Stage stage = new Stage();
	        	 Parent root = FXMLLoader.load(getClass().getResource("add_new_patient.fxml"));
	             Scene scene = new Scene(root);
	             stage.setScene(scene);
	             stage.setTitle("Radiology");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();

          



	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	

	 
	
	
	
	
	
	
	
		
	 @FXML
	    public void Page_dAccul (ActionEvent e) throws IOException {
	    	 	
	    		 Stage stage = new Stage();
	        	 Parent root = FXMLLoader.load(getClass().getResource("add_new_pointment.fxml"));
	             Scene scene = new Scene(root);
	             stage.setScene(scene);
	             stage.setTitle("Radiology");
	             stage.getIcons().add(new Image("img/icon.png"));
	             stage.show();

          



	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	

	
	

}
