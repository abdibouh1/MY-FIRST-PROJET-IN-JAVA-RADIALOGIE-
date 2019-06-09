package application;

public class examen {
	
	private String nom;
	private String etat;
	private int salle;
	public examen(String nom, String etat, int salle) {
		super();
		this.nom = nom;
		this.etat = etat;
		this.salle = salle;
	}
	
	public examen() {
		
		
		
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}
	
	
	
	

}
