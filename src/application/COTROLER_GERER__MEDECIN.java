package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DAO.DAO_CREATION_MEDECIIN;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class COTROLER_GERER__MEDECIN implements Initializable {

	@FXML
	private Label EMT;
	@FXML
	private TextField IDTT;
	@FXML
	private TextField ADT;
	@FXML
	private TextField NAT;
	@FXML
	private TextField LNT;

	@FXML
	private PasswordField PAT;


	@FXML
	private Label test_nom;

	@FXML
	private Label test_prenom;

	@FXML
	private Label test_password;

	@FXML
	private Label test_id;

	
	@FXML
	private Label L177;
	

	@FXML
	private Label test_adress;
	
	
	
	@FXML
	private TableView<MEDECIN> table;
	@FXML
	private TableColumn<MEDECIN, Integer> id;
	@FXML
	private TableColumn<MEDECIN, String> nom;
	@FXML
	private TableColumn<MEDECIN, String> email;
	@FXML
	private TableColumn<MEDECIN, String> adresse;

	@FXML
	private TextField search;
	public ObservableList<MEDECIN> data = FXCollections.observableArrayList();
	public static Connection con = DAO.Connexion.getConnexion();
	public static PreparedStatement preparStat;

	FilteredList<MEDECIN> filter = new FilteredList<MEDECIN>(data, e -> true);
	
	
	
	
	
	
	public void	Test() {
		if (table.getSelectionModel().getSelectedItem() != null) {
			MEDECIN selectedMedcine = table.getSelectionModel().getSelectedItem();
			EMT.setText(selectedMedcine.getEmail());
			NAT.setText(selectedMedcine.getNom());
			LNT.setText(selectedMedcine.getPrenom());
			ADT.setText(selectedMedcine.getAdress());
			IDTT.setText(String.valueOf(selectedMedcine.getId()));
			PAT.setText(selectedMedcine.getPassword());
			
		}
	}
	
	

	public boolean Nom_Valid() {
		String nom = NAT.getText();
		if(
				nom.matches("[A-Za-z]*")
				) {
			test_nom.setText("");
		return true ;
		}
		else
			return false;
		
	}
	
	public boolean PasswordValide() {
		String passwordText = PAT.getText();
		if(
				passwordText.length()<8
				) 
		{
			test_password.setText("");	
		return false;
		}
		
		else 
			return true;
		
	}
	public boolean Prenom_Valid() {
		String Prenom = LNT.getText();
		if(
				Prenom.matches("[A-Z a-z]*")
				) {
			test_prenom.setText("");	
		return true;}
	else
			return false;
		
	}
	public boolean id_valide() {
		String iid = IDTT.getText();
		if(iid.matches("[0-9]*")) {
			test_id.setText("");
			return true;
			
		}
		return false;
		
		
	}
	
	public boolean VideNom() {
	
	return NAT.getText().equals("");
	
		
	}
	
	public boolean VidePrenom() {
		
		return LNT.getText().equals("");
		
			
		}
	
	public boolean emaivide() {
		
		return EMT.getText().equals("");
		
			
		}
	
	public boolean idvide() {
		
		return IDTT.getText().equals("");
		
			
		}
	
	public boolean passvid() {
		
		return PAT.getText().equals("");
		
			
		}
	
	public boolean adressvide() {
		
		return ADT.getText().equals("");
		
			
		}

	
	
	
	
	
	
	
	
	
	 @FXML
	    public void Page_dAccueil (ActionEvent e) throws IOException {
	    	 	
	    		 Stage stage = new Stage();
	        	 Parent root = FXMLLoader.load(getClass().getResource("WHAT_THE_ADMINISTRATOR_DO.fxml"));
	             Scene scene = new Scene(root);
	             stage.setScene(scene);
	             stage.show();
	             ((Node)(e.getSource())).getScene().getWindow().hide();
	    	
	    	 
	    }	
	
	
	
	
	
	
	
	
	
public void Save() throws SQLException {
       
	
	
	
	
	

	 if (VideNom()) {
		L177.setText("you have to full all");
	}
	
		else if (VidePrenom()) {
			L177.setText("you have to full all");
		}
	

	else if (idvide()) {
			L177.setText("you have to full all");
		}
	else if (passvid()) {
		L177.setText("you have to full all");
	} 
	 
	else if (emaivide()) {
		L177.setText("you have to full all");
	}
	
	
	
	else if (adressvide()) {
		L177.setText("you have to full all");
	}
	
	

	
	
	else if (!Nom_Valid()) {
		
	test_nom.setText("name  not valid");	
		
	}
	
	else if(!Prenom_Valid()) {
		test_prenom.setText("last name  not valid");
	}
	
	
	else if(!id_valide()) {
		test_id.setText("the id is nuber");
		}
	
 else if(!PasswordValide()) {
		
	 test_password.setText("you have to use 8 characters ");
	}
	
	
	

	
	
	
	
	else {
	
	
	
	
	
	
	
	
		MEDECIN MEDECIN = new MEDECIN();
        String nom = NAT.getText();
		String prenom = LNT.getText();
		String email = EMT.getText();
		String MotPasse = PAT.getText();
		String adress = ADT.getText();
		String iId = IDTT.getText();
		int IIId=Integer.parseInt(iId);
		
		MEDECIN.setNom(nom);
		MEDECIN.setPrenom(prenom);
		MEDECIN.setEmail(email);
		MEDECIN.setAdress(adress);
		MEDECIN.setId(IIId);
		MEDECIN.setPassword(MotPasse);
		
		
			int status = DAO_CREATION_MEDECIIN.Modifier(MEDECIN);
			if (status == 2) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ubdate of medcin");
				alert.setHeaderText("Information");
				alert.setContentText("we saved the modification");
				alert.showAndWait();
				updateTable();
					
			} else if(status == 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ubdate of medcin");
				alert.setHeaderText("Information");
				alert.setContentText(" we did not save  ");
				alert.showAndWait();

			}
			
			
			
			
			
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ubdate of medcin");
				alert.setHeaderText("Information");
				alert.setContentText("this account is slready exist");
				alert.showAndWait();
				}	
			
			
			
	}
	}
	public void SupprimerButtonAction(ActionEvent e) throws IOException, SQLException {
		if (table.getSelectionModel().getSelectedItem() != null) {
			MEDECIN selectedMedcine = table.getSelectionModel().getSelectedItem();
			
			
			
			EMT.setText(selectedMedcine.getEmail());
			NAT.setText(selectedMedcine.getNom());
			LNT.setText(selectedMedcine.getPrenom());
			ADT.setText(selectedMedcine.getAdress());
			IDTT.setText(String.valueOf(selectedMedcine.getId()));
			PAT.setText(selectedMedcine.getPassword());
			
			
			
			
			int status = DAO_CREATION_MEDECIIN.Supprimer(selectedMedcine);
			if (status == 2) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("delete mdecin");
				alert.setHeaderText("Information");
				alert.setContentText("we deleted an medecin");
				alert.showAndWait();
				updateTable();
					
			} else if(status == 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("L'ajout D'un administrator");
				alert.setHeaderText("Information");
				alert.setContentText(" we could not delete the medecin");
				alert.showAndWait();

			}
		
		}
	}
	
	public void ModifierButtonAction(ActionEvent e) throws IOException {

		if (table.getSelectionModel().getSelectedItem() != null) {
			MEDECIN selectedMedcine = table.getSelectionModel().getSelectedItem();
			EMT.setText(selectedMedcine.getEmail());
			NAT.setText(selectedMedcine.getNom());
			LNT.setText(selectedMedcine.getPrenom());
			ADT.setText(selectedMedcine.getAdress());
			IDTT.setText(String.valueOf(selectedMedcine.getId()));
			PAT.setText(selectedMedcine.getPassword());
			
		}
	
			
	}

	@FXML
	private void search(KeyEvent event) {

		search.textProperty().addListener((observableValue, oldValue, newValue) -> {
			filter.setPredicate((java.util.function.Predicate<? super MEDECIN>) (MEDECIN medcine) -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (medcine.getNom().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (medcine.getEmail().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}

				return false;
			});
		});
		SortedList<MEDECIN> sortedData = new SortedList<>(filter);
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		table.setItems(sortedData);
	}
	
	public void updateTable() {

		for (int i = 0; i < table.getItems().size(); i++) {
			table.getItems().clear();
		}

		try {
			String requete = "SELECT * FROM MEDEECIN";
			preparStat = con.prepareStatement(requete);
			ResultSet rs = preparStat.executeQuery();
			while (rs.next()) {
				data.add(new MEDECIN(rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("EMAIL"),
						rs.getString("PASSWORD"), rs.getInt("ID"), rs.getString("ADRESS")));
				table.setItems(data);
				nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
				id.setCellValueFactory(new PropertyValueFactory<>("id"));
				adresse.setCellValueFactory(new PropertyValueFactory<>("adress"));
				email.setCellValueFactory(new PropertyValueFactory<>("Email"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Test();
		try {

			String requete = "SELECT * FROM MEDEECIN";
			preparStat = con.prepareStatement(requete);
			ResultSet rs = preparStat.executeQuery();
			while (rs.next()) {
				data.add(new MEDECIN(rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("EMAIL"),
						rs.getString("PASSWORD"), rs.getInt("ID"), rs.getString("ADRESS")));
				table.setItems(data);
				nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
				id.setCellValueFactory(new PropertyValueFactory<>("id"));
				adresse.setCellValueFactory(new PropertyValueFactory<>("adress"));
				email.setCellValueFactory(new PropertyValueFactory<>("Email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
