package application;

import java.sql.Date;

public class Apoitment {
	
	String nom ;
	String prenom;
	Integer CIN;
	Date date_rendevous;
	Integer phonenumber;
	String adress;
    String time;
    String exement;
	public Apoitment(String nom, String prenom, Integer cIN, Date date_rendevous, Integer phonenumber, String adress,
			String time, String exement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.date_rendevous = date_rendevous;
		this.phonenumber = phonenumber;
		this.adress = adress;
		this.time = time;
		this.exement = exement;
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
	public Date getDate_rendevous() {
		return date_rendevous;
	}
	public void setDate_rendevous(Date date_rendevous) {
		this.date_rendevous = date_rendevous;
	}
	public Integer getPhonenumber() {
		return phonenumber;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getExement() {
		return exement;
	}
	public void setExement(String exement) {
		this.exement = exement;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
