package application;

public class rendevou {
	
	private String nom;
	private String prenom;
	private  int cin;
	private int phonnenumber;
	private String daterendevous;
	private String exam;
	private String timme;
	public rendevou(String nom, String prenom, int cin, int phonnenumber, String daterendevous, String exam,
			String timme) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.phonnenumber = phonnenumber;
		this.daterendevous = daterendevous;
		this.exam = exam;
		this.timme = timme;
	}
	
	
	public rendevou() {
		
		
		
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
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public int getPhonnenumber() {
		return phonnenumber;
	}
	public void setPhonnenumber(int phonnenumber) {
		this.phonnenumber = phonnenumber;
	}
	public String getDaterendevous() {
		return daterendevous;
	}
	public void setDaterendevous(String daterendevous) {
		this.daterendevous = daterendevous;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public String getTimme() {
		return timme;
	}
	public void setTimme(String timme) {
		this.timme = timme;
	}
	
	
	
	
	
	

}
