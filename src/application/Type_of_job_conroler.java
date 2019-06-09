package application;


	
	
	import java.io.IOException;
	import java.net.URL;
	import java.util.ResourceBundle;

	import javafx.event.ActionEvent;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;


	public class Type_of_job_conroler implements Initializable {

		
		
		public void Administrateur(ActionEvent e) throws IOException
		{
			
			 Stage stage = new Stage();
	   	     Parent root = FXMLLoader.load(getClass().getResource("LOGIN_ADMINISTRATOR.fxml"));
	         
	         Scene scene = new Scene(root);
	         stage.setScene(scene);
	   
	         stage.show();
	         ((Node)(e.getSource())).getScene().getWindow().hide();
	         
	       
		}
		
		public void Secretaire(ActionEvent e) throws IOException 
		{
			
			 Stage stage = new Stage();
	  	     Parent root = FXMLLoader.load(getClass().getResource("LOGINSECRETAIRE.fxml"));
	        
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	       
	        stage.show();
	        ((Node)(e.getSource())).getScene().getWindow().hide();
	        
		}
		
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

		public void Medecin(ActionEvent e) throws IOException {
			
			 Stage stage = new Stage();
			 
	 	     Parent root = FXMLLoader.load(getClass().getResource("LLogin_MEDCIN_.fxml"));
	       
	       Scene scene = new Scene(root);
	       stage.setScene(scene);
	      
	       stage.show();
	       ((Node)(e.getSource())).getScene().getWindow().hide();
		}

	
	
	

}
