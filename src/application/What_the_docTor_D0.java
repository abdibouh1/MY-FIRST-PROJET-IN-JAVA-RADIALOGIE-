package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class What_the_docTor_D0 {
	
	
	
	public void addroom(ActionEvent e) throws IOException 
	{
		
		 Stage stage = new Stage();
  	     Parent root = FXMLLoader.load(getClass().getResource("creation_du_salle.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
       
        stage.show();
        ((Node)(e.getSource())).getScene().getWindow().hide();
        
	}
   
	
	
	
	

	
	public void addconterendu(ActionEvent e) throws IOException 
	{
		
		 Stage stage = new Stage();
  	     Parent root = FXMLLoader.load(getClass().getResource("AJOUTER_UN_contrendu.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
       
        stage.show();
        ((Node)(e.getSource())).getScene().getWindow().hide();
        
	}
	
	
	
	
	

}
