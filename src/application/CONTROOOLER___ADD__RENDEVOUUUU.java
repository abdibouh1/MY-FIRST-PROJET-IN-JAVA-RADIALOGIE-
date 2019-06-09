package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTimePicker;

import DAO.Connexion;
import DAO.DAO_ajouter_patient;
import DAO.DAO_creation_du_rendevous;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CONTROOOLER___ADD__RENDEVOUUUU implements Initializable {

	@FXML
	private TextField nom_text_rendevou;
	@FXML
	private TextField prenom_text_rendevou;
	@FXML
	private TextField cin_text_rendevou;
	@FXML
	private DatePicker dateappointment_text;
	@FXML
	private TextField phnumber_text_rendevou;
	@FXML
	private ComboBox<String> selectdoctor_text_rendevou;
	@FXML
	private JFXTimePicker time_text_rendevou;

	@FXML
	Label nom_test_redevous;

	@FXML
	Label prenom_test_redevous;
	@FXML
	Label cin_test_redevous;
	@FXML
	Label phnumber_test_redevous;
	@FXML
	Label date_test_redevous;
	@FXML
	Label date_test_redevous1;
	@FXML
	Label globale;
	@FXML
	Label time_test_redevous;

	public void BtnAnnuler() throws IOException {
		nom_text_rendevou.setText("");
		prenom_text_rendevou.setText("");
		cin_text_rendevou.setText("");

		dateappointment_text.setValue(null);
		phnumber_text_rendevou.setText("");

		time_text_rendevou.setValue(null);
		nom_test_redevous.setText("");
		prenom_test_redevous.setText("");
		cin_test_redevous.setText("");
		phnumber_test_redevous.setText("");
		date_test_redevous.setText("");
		time_test_redevous.setText("");
		globale.setText("");
	}

	public boolean Nom_Valid() {
		String nom = nom_text_rendevou.getText();
		if (nom.matches("[A-Za-z]*")) {
			nom_test_redevous.setText("");
			return true;
		} else
			return false;

	}

	public boolean Prenom_Valid() {
		String Prenom = prenom_text_rendevou.getText();
		if (Prenom.matches("[A-Z a-z]*")) {
			prenom_test_redevous.setText("");
			return true;
		} else
			return false;

	}

	public boolean id_valide() {
		String iid = cin_text_rendevou.getText();
		if (iid.matches("[0-9]*")) {
			cin_test_redevous.setText("");
			return true;

		}
		return false;

	}

	public boolean phonevaiiiide() {
		String passwordText = phnumber_text_rendevou.getText();
		if (passwordText.length() < 8) {
			phnumber_test_redevous.setText("");
			return false;
		}

		else
			return true;

	}

	public boolean thecinisvalide() {
		String passwordText = phnumber_text_rendevou.getText();
		if (passwordText.length() < 8) {

			return false;
		}

		else
			phnumber_test_redevous.setText("");
		return true;

	}

	public boolean cinvalideissupde8() {
		String passwordText = cin_text_rendevou.getText();
		if (passwordText.length() < 8) {

			return false;
		}

		else
			cin_test_redevous.setText("");
		return true;

	}

	public boolean phonevalide() {
		String iid = phnumber_text_rendevou.getText();
		if (iid.matches("[0-9]*")) {
			phnumber_test_redevous.setText("");
			return true;

		}
		return false;

	}

	public boolean VideNom() {
		globale.setText("");
		return nom_text_rendevou.getText().equals("");

	}

	public boolean VidePrenom() {
		globale.setText("");
		return prenom_text_rendevou.getText().equals("");

	}

	public boolean cinvide() {
		globale.setText("");
		return cin_text_rendevou.getText().equals("");

	}

	public boolean isValidDate() {
		if (dateappointment_text.getValue() != null) {
			LocalDate date = dateappointment_text.getValue();
			LocalDate d = LocalDate.now();
			if (date.compareTo(d) > 0)
				return true;
		}
		return false;
	}

	public boolean phonenumbervide() {
		globale.setText("");
		return phnumber_text_rendevou.getText().equals("");

	}

	public void BtnEnvoyer() throws SQLException {

		if (VideNom()) {
			globale.setText("you have to full all");
		}

		else if (VidePrenom()) {
			globale.setText("you have to full all");
		}

		else if (cinvide()) {
			globale.setText("you have to full all");
		}

		else if (phonenumbervide()) {
			globale.setText("you have to full all");
		}

		else if (!Nom_Valid()) {

			nom_test_redevous.setText("name  not valid");

		}

		else if (!Prenom_Valid()) {
			prenom_test_redevous.setText("last name  not valid");
		}

		else if (!id_valide()) {
			cin_test_redevous.setText("the cin is not correct");

		}

		else if (!cinvalideissupde8()) {
			cin_test_redevous.setText("the cin is not correct");

		}

		else if (!phonevalide()) {
			phnumber_test_redevous.setText("the phonne nuber is not correct");

		}

		else if (!thecinisvalide()) {
			phnumber_test_redevous.setText("the phonne nuber is not correct");

		}

		else if (!isValidDate()) {
			date_test_redevous1.setText("the date is not correct");
		}

		else {

			rendevou Patient = new rendevou();

			String nom = nom_text_rendevou.getText();

			String prenom = prenom_text_rendevou.getText();

			String exam = selectdoctor_text_rendevou.getValue();
			String phonenumbe = phnumber_text_rendevou.getText();
			int phonenumber = Integer.parseInt(phonenumbe);

			String id = cin_text_rendevou.getText();
			int Id = Integer.parseInt(id);

			String brdat = dateappointment_text.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String tiime = (time_text_rendevou.getValue() != null ? time_text_rendevou.getValue().toString() : "");
			Patient.setNom(nom);
			Patient.setPrenom(prenom);
			Patient.setDaterendevous(brdat);
			Patient.setCin(Id);
			Patient.setPhonnenumber(phonenumber);

			Patient.setExam(exam);
			Patient.setTimme(tiime);

			int status = DAO_creation_du_rendevous.Ajouter(Patient);

			if (status == 2) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ADD sectretary");
				alert.setHeaderText("Information");
				alert.setContentText("WE hsve ADDED A sectretary ");
				alert.showAndWait();

			} else if (status == 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD DOCTOR");
				alert.setHeaderText("Information");
				alert.setContentText("WE COULD NOT add a sectretary ");
				alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ADD sectretary");
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
		stage.setTitle("welcome secretary");
        stage.getIcons().add(new Image("img/icon.png"));
		stage.show();

		((Node) (e.getSource())).getScene().getWindow().hide();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			String exm = "SELECT * from MEDEECIN";
			Connection conn = Connexion.getConnexion();
			PreparedStatement preparStat;

			ResultSet r;
			preparStat = conn.prepareStatement(exm);
			r = preparStat.executeQuery();
			ObservableList<String> names = FXCollections.observableArrayList();

			while (r.next()) {
				names.add(r.getString("NOM"));
                       }
			selectdoctor_text_rendevou.setItems(names);

		} catch (Exception e) {

		}
	}

}
