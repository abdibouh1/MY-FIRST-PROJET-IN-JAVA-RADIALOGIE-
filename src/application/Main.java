package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.layout.BorderPane;
//import java.io.IOException;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("First_interface.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Radiology");
			primaryStage.getIcons().add(new Image("img/icon.png"));
			primaryStage.show();
		      	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
