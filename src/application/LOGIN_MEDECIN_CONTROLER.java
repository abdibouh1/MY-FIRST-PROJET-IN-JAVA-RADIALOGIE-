package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.DAO_LOGIN_ADMIN;
import DAO.DAO_LOGIN_MEDECIN;
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

public class LOGIN_MEDECIN_CONTROLER {
	

	
	
	
	  
	  @FXML 
    private TextField  UST;
    
     @FXML 
    private TextField PAST;
     
    @FXML
     Label connecter_ou_pas;
     @FXML
     Label R2;
     
     Type_of_job_conroler tc;
  
   
     @FXML
    public void CreeCompt (ActionEvent e) throws IOException {
    	 	
    	 Stage stage3 = new Stage();
      	  Parent root = FXMLLoader.load(getClass().getResource("SIN_UP_ADMINISTRATOR.fxml"));
            
            Scene scene = new Scene(root);
            stage3.setScene(scene);
            stage3.show();
            ((Node)(e.getSource())).getScene().getWindow().hide();
       }	
    
     
     
     

  	public boolean emaivide() {
  		
  		return UST.getText().equals("");
  		
  			
  		}
      
      


  	public boolean passvide() {
  		
  		return PAST.getText().equals("");
  		
  			
  		}
    	 
    
    @FXML
    private void Seconnecter(ActionEvent event) throws IOException {
        
        String Email =UST.getText();
        String Pass = PAST.getText();
        
        DAO_LOGIN_MEDECIN DAO =new DAO_LOGIN_MEDECIN();
      
      
      boolean test =DAO.seconnecter(Email,Pass);
      
      

      
      
       if(test==true){
   	  Stage stage2 = new Stage();
    	  Parent root = FXMLLoader.load(getClass().getResource("ADD_ROO_CONTRENDU.fxml"));
          
         Scene scene = new Scene(root);
         stage2.setScene(scene);
         stage2.setTitle("welcome doctor");
         stage2.getIcons().add(new Image("img/icon.png"));
         stage2.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
      
    	System.out.println("welcom");  
      }
      
          
        else {
        	

           
         
    	       R2.setText("user name or password not correct");
    	  }
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
