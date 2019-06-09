package application;

public class MEDECIN {
	
	
	
	

	private String Nom;
	private String Prenom;
	private String Email;
	private String password;
	private int id;
	private String adress;
	
	public MEDECIN(String nom, String prenom, String email, String password, int id, String adress) {
		super();
		Nom = nom;
		Prenom = prenom;
		Email = email;
		this.password = password;
		this.id = id;
		this.adress = adress;
	}
	public MEDECIN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return Nom;
	
		}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	

	
	
	
	
	

}
