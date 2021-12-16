package beans;

public class Utilisateur {

	private String  nom ,prenom ,login ,password;
	private int id ;
	
	
	public  Utilisateur() {
		
	}

	public Utilisateur(int id ,String nom, String prenom, String login, String password) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public Utilisateur(String nom, String prenom, String login, String password) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
				+ ", id=" + id + "]";
	} 
	 
	
	
	
	
}
