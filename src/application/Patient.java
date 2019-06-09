package application;

import java.util.Date;

public class Patient {
	
	
	String nom ;
	String prenom;
	Integer CIN;
	String date_ofbirth;
	Integer phonenumber;
	String adress;
	public Patient(String nom, String prenom, Integer cIN, String date_ofbirth, Integer phonenumber, String adress) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.date_ofbirth = date_ofbirth;
		this.phonenumber = phonenumber;
		this.adress = adress;
	}
	
	public Patient() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Integer getCIN() {
		return CIN;
	}
	public void setCIN(Integer cIN) {
		CIN = cIN;
	}
	public String getDate_ofbirth() {
		return date_ofbirth;
	}
	
	public void setDate_ofbirth(String date_ofbirth) {
		this.date_ofbirth = date_ofbirth;
	}
	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getPhonenumber() {
		return phonenumber;
	}
	
	
	
	
	
	
	
	
	
}
