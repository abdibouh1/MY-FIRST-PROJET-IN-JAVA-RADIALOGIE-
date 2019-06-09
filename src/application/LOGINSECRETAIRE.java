package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.DAO_LOGIN_ADMIN;
import DAO.DOLOGINSECRETAIR;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LOGINSECRETAIRE 


{
	
   @FXML 
    private TextField  USST;
    
     @FXML 
    private TextField PASST;
     
     @FXML
     Label connecter_ou_pas;
     @FXML
     Label R3;
     
     Type_of_job_conroler tc;
  
    
     @FXML
    public void CreeCompt (ActionEvent e) throws IOException {
    	 	
    	 Stage stage3 = new Stage();
      	  Parent root = FXMLLoader.load(getClass().getResource("SINGUPSECRETAIRE.fxml"));
            
            Scene scene = new Scene(root);
            stage3.setScene(scene);
            stage3.show();
            ((Node)(e.getSource())).getScene().getWindow().hide();
       
     }	
    
    	 
    
    @FXML
    private void Seconnecter(ActionEvent event) throws IOException {
        
        String Email =USST.getText();
        String Pass = PASST.getText();
        
        DOLOGINSECRETAIR DAO =new DOLOGINSECRETAIR();
      
      
      boolean test =DAO.seconnecter(Email,Pass);
      
      if(test==true){
   	  Stage stage2 = new Stage();
    	  Parent root = FXMLLoader.load(getClass().getResource("WHAT__THE SECRETARY_DO.fxml"));
          
         Scene scene = new Scene(root);
         stage2.setTitle("welcome administrotor");
         stage2.getIcons().add(new Image("img/icon.png"));
         stage2.setScene(scene);
         stage2.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
      
    	 
      }
      
          
      
      else
    	  
          R3.setText("user or email not correct");
    	  
     
    }
    
    public void  AccueilTypeCompt(ActionEvent e) throws IOException {
    	 Stage stage3 = new Stage();
   	  Parent root = FXMLLoader.load(getClass().getResource("First_interface.fxml"));
         
         Scene scene = new Scene(root);
         stage3.setScene(scene);
         stage3.show();
         ((Node)(e.getSource())).getScene().getWindow().hide();
    }
    
    
    
     


}
