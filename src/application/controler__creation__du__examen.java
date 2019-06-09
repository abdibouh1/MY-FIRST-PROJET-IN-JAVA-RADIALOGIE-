package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.Connexion;
import DAO.DAO_CREATION_EXAMEN;
import DAO.DAO_CREATIO_DU_EMPLYER;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class controler__creation__du__examen implements Initializable {

	@FXML
	private TextField TEXT_exam_nom;

	@FXML
	private ComboBox<String> selectdoctor_text_etat;

	@FXML
	private ComboBox<String> selectdoctor_sale;

	public void BtnEnvoyer() throws SQLException {

		examen examen = new examen();

		String nom = TEXT_exam_nom.getText();
		String etat = selectdoctor_text_etat.getValue();
		String salle = selectdoctor_sale.getValue();
		int sle = Integer.parseInt(salle);
		examen.setEtat(etat);
		examen.setNom(nom);
		examen.setSalle(sle);

		int status = DAO_CREATION_EXAMEN.Ajouter(examen);

		if (status == 2) {
			if (status == 2) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ADD emplyee");
				alert.setHeaderText("Information");
				alert.setContentText("WE hsve ADDED A emplyee ");
				alert.showAndWait();

			} else if (status == 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD DOCTOR");
				alert.setHeaderText("Information");
				alert.setContentText("WE COULD NOT add a emplyee ");
				alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD emplyee");
				alert.setHeaderText("Information");
				alert.setContentText("this account is slready exist");
				alert.showAndWait();
			}

		}
	}

	@FXML
	public void Page_dAccueil(ActionEvent e) throws IOException {

		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("WHAT_THE_ADMINISTRATOR_DO.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("welcome doctor");
        stage.getIcons().add(new Image("img/icon.png"));
		stage.show();
		((Node) (e.getSource())).getScene().getWindow().hide();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {

			String sttate[] = { "able", "unable" };

			ObservableList<String> names = FXCollections.observableArrayList();
			names.addAll(sttate);
			selectdoctor_text_etat.setItems(names);

			String exm = "SELECT * from SLLE";
			Connection conn = Connexion.getConnexion();
			PreparedStatement preparStat;

			ResultSet r;
			preparStat = conn.prepareStatement(exm);
			r = preparStat.executeQuery();
			ObservableList<String> namesa = FXCollections.observableArrayList();

			while (r.next()) {
				namesa.add(r.getString("NUMEROSALLLE"));

			}
			selectdoctor_sale.setItems(namesa);

		} catch (Exception e) {

		}
	}

}
