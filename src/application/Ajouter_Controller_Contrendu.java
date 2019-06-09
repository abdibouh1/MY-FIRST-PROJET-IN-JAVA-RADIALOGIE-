package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.Connexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.sql.DATE;

public class Ajouter_Controller_Contrendu implements Initializable {

	@FXML
	private ComboBox<Integer> cin_combobox;

	@FXML
	private ComboBox<String> nom_medcine_combobox;

	@FXML
	private ComboBox<String> nom_examn_combobox;

	@FXML
	private TextField description;
	@FXML
	private  Label globletest;
	public void Ajouter() {
			
			
		
		
		
		
		
		

		int Cin = cin_combobox.getValue();
		
		String nom_medcine = nom_medcine_combobox.getValue();
		String nom_exemen = nom_examn_combobox.getValue();
		String Description = description.getText();
		LocalDate d = LocalDate.now();
		String date = d.toString();
		
		
		
		
		try {
			String sql = "INSERT INTO CONTARENDU(CIN,NOM_MEDECIN,NOM_EXAMEN,DATE_CONTRENDU,DESCRIPTION ) VALUES(?,?,?,?,?)";
			Connection conn = Connexion.getConnexion();
			PreparedStatement preparStat = null;
            
			preparStat = conn.prepareStatement(sql);

			preparStat.setInt(1, Cin);
			preparStat.setString(2, nom_medcine);
			preparStat.setString(3, nom_exemen);
			preparStat.setString(4, date);
			preparStat.setString(5, Description);
			preparStat.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ObservableList<Integer> CINS = FXCollections.observableArrayList();
			Connection conn = Connexion.getConnexion();
			PreparedStatement preparStat = null;
			ResultSet r = null;

			String sql = "SELECT * from PATIENT";
			preparStat = conn.prepareStatement(sql);
			r = preparStat.executeQuery();

			while (r.next()) {
				CINS.add(r.getInt("CIN"));

			}
			cin_combobox.setItems(CINS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ObservableList<String> namesM = FXCollections.observableArrayList();
			Connection conn = Connexion.getConnexion();
			PreparedStatement preparStat = null;
			ResultSet r = null;

			String sql = "SELECT * from Medeecin";
			preparStat = conn.prepareStatement(sql);
			r = preparStat.executeQuery();

			while (r.next()) {
				namesM.add(r.getString("NOM"));

			}
			nom_medcine_combobox.setItems(namesM);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ObservableList<String> namesa = FXCollections.observableArrayList();
			Connection conn = Connexion.getConnexion();
			PreparedStatement preparStat = null;
			ResultSet r = null;

			String sql = "SELECT * from EXEMEN";
			preparStat = conn.prepareStatement(sql);
			r = preparStat.executeQuery();

			while (r.next()) {
				namesa.add(r.getString("NOM"));

			}
			nom_examn_combobox.setItems(namesa);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
