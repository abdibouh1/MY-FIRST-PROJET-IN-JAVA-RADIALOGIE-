
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CONTROER_WHAT_ADMIN_DO {
	
	
    public void  creation_du_medecin(ActionEvent e) throws IOException {
   	 Stage stage3 = new Stage();
  	  Parent root = FXMLLoader.load(getClass().getResource("ADDMEDECIN.fxml"));
        
        Scene scene = new Scene(root);
        stage3.setScene(scene);
        stage3.setTitle("WELCOME ADMINISTRATOP");
        stage3.getIcons().add(new Image("img/icon.png"));
        stage3.show();
        ((Node)(e.getSource())).getScene().getWindow().hide();
        
        
   }
	
    public void geree_medecin(ActionEvent e) throws IOException {
      	 Stage stage3 = new Stage();
     	  Parent root = FXMLLoader.load(getClass().getResource("gerer_medecin.fxml"));
           
           Scene scene = new Scene(root);
           stage3.setScene(scene);
           stage3.setTitle("WELCOME ADMINISTRATOP");
           stage3.getIcons().add(new Image("img/icon.png"));
           stage3.show();
           ((Node)(e.getSource())).getScene().getWindow().hide();
      }

  
     
   public void  creation_du_secretaire(ActionEvent e) throws IOException {
      	 Stage stage3 = new Stage();
     	  Parent root = FXMLLoader.load(getClass().getResource("CREATION_SECRETAIRE.fxml"));
           
           Scene scene = new Scene(root);
           stage3.setScene(scene);
           stage3.setTitle("WELCOME ADMINISTRATOP");
           stage3.getIcons().add(new Image("img/icon.png"));
           stage3.show();
           ((Node)(e.getSource())).getScene().getWindow().hide();
      }
   	
       public void gereer_secretaire(ActionEvent e) throws IOException {
         	 Stage stage3 = new Stage();
        	  Parent root = FXMLLoader.load(getClass().getResource("gerer_seecretaiire.fxml"));
              
              Scene scene = new Scene(root);
              stage3.setScene(scene);
              stage3.setTitle("WELCOME ADMINISTRATOP");
              stage3.getIcons().add(new Image("img/icon.png"));
              stage3.show();
              ((Node)(e.getSource())).getScene().getWindow().hide();
         }

       
    
    
    
       
       
       
       
       
       public void  creation_du_contable(ActionEvent e) throws IOException {
         	 Stage stage3 = new Stage();
        	  Parent root = FXMLLoader.load(getClass().getResource("CREATION_contable.fxml"));
              
              Scene scene = new Scene(root);
              stage3.setScene(scene);
              stage3.setTitle("WELCOME ADMINISTRATOP");
              stage3.getIcons().add(new Image("img/icon.png"));
              stage3.show();
              ((Node)(e.getSource())).getScene().getWindow().hide();
         }
      	
          public void gereer_cotable(ActionEvent e) throws IOException {
            	 Stage stage3 = new Stage();
           	  Parent root = FXMLLoader.load(getClass().getResource("gerer_contablee.fxml"));
                 
                 Scene scene = new Scene(root);
                 stage3.setScene(scene);
                 stage3.setTitle("WELCOME ADMINISTRATOP");
                 stage3.getIcons().add(new Image("img/icon.png"));
                 stage3.show();
                 ((Node)(e.getSource())).getScene().getWindow().hide();
            }

          

          
          
          
       
          public void deconecter(ActionEvent e) throws IOException {
         	 Stage stage3 = new Stage();
        	  Parent root = FXMLLoader.load(getClass().getResource("LOGIN_ADMINISTRATOR.fxml"));
              
              Scene scene = new Scene(root);
              stage3.setScene(scene);
              stage3.setTitle("WELCOME ADMINISTRATOP");
              stage3.getIcons().add(new Image("img/icon.png"));
              stage3.show();
              ((Node)(e.getSource())).getScene().getWindow().hide();
         }

           
       
       
       
       
       
       
          
          public void  creation_du_employer(ActionEvent e) throws IOException {
            	 Stage stage3 = new Stage();
           	  Parent root = FXMLLoader.load(getClass().getResource("creatuin_emplyer.fxml"));
                 
                 Scene scene = new Scene(root);
                 stage3.setScene(scene);
                 stage3.setTitle("WELCOME ADMINISTRATOP");
                 stage3.getIcons().add(new Image("img/icon.png"));
                 stage3.show();
                 ((Node)(e.getSource())).getScene().getWindow().hide();
            }
         	
  public void gereer_emplyer(ActionEvent e) throws IOException {
               	 Stage stage3 = new Stage();
              	  Parent root = FXMLLoader.load(getClass().getResource("GERER__EMPLYER.fxml"));
                    
                    Scene scene = new Scene(root);
                    stage3.setScene(scene);
                    stage3.setTitle("WELCOME ADMINISTRATOP");
                    stage3.getIcons().add(new Image("img/icon.png"));
                    stage3.show();
                    ((Node)(e.getSource())).getScene().getWindow().hide();
               }

             
          
          
          
      
       
    
}
