package application;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import DAO.Connexion;
import DAO.DAO_LOGIN_ADMIN;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;




public class Controleur_Login_Administrateur implements Initializable {
    
   
    @FXML 
    private TextField  txt_LOGIN;
    
     @FXML 
    private TextField txt_PASS;
     
   
     @FXML
     Label R1;
     
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
 		
 		return txt_LOGIN.getText().equals("");
 		
 			
 		}
     
     


 	public boolean passvide() {
 		
 		return txt_PASS.getText().equals("");
 		
 			
 		}
 	
    
    @FXML
    private void Seconnecter(ActionEvent event) throws IOException {
        
        String Email =txt_LOGIN.getText();
        String Pass = txt_PASS.getText();
        
        DAO_LOGIN_ADMIN DAO =new DAO_LOGIN_ADMIN();
      
      
      boolean test =DAO.seconnecter(Email,Pass);
      
      
      
      if(test==true){
    	
    	  R1.setText("");
   	     Stage stage2 = new Stage();
    	  Parent root = FXMLLoader.load(getClass().getResource("whaaaaat_admiiiin____dooooo.fxml"));
          
         Scene scene = new Scene(root);
         stage2.setScene(scene);
         stage2.show();
         ((Node)(event.getSource())).getScene().getWindow().hide();
      
    	  
      }
      
          
      
      else
    	  
          R1.setText("user or email not correct");
    
     
    }
    
    public void  AccueilTypeCompt(ActionEvent e) throws IOException {
    	 Stage stage3 = new Stage();
   	  Parent root = FXMLLoader.load(getClass().getResource("First_interface.fxml"));
         
         Scene scene = new Scene(root);
         stage3.setScene(scene);
         stage3.setTitle("welcome administrotor");
         stage3.getIcons().add(new Image("img/icon.png"));
         stage3.show();
         ((Node)(e.getSource())).getScene().getWindow().hide();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
