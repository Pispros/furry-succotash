package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDAO;

public class AddUserForm {
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	
	private boolean status ;
	private String statusMessage;
	private Utilisateur utilisateur;
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	
	public AddUserForm(HttpServletRequest request) {
		this.status = false;
		this.request = request;
		this.erreurs = new HashMap<>();
	}
	
	public boolean ajouter() {
		
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);
		
		utilisateur = new Utilisateur(nom, prenom, login, password);
		
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		validerPasswords();
		
		if(erreurs.isEmpty()) {
			UtilisateurDAO userDAO = new UtilisateurDAO();
			status = userDAO.ajouter(utilisateur);
			if(status) {
				statusMessage  = "Ajout effectu� avec succ�s";
				
				return true;
			}
		}
		
		statusMessage = "Echec de l'ajout ";
		return false;
	}
	
	private String getParameter(String parametre) {
		
		String valeur = request.getParameter(parametre);
		
		if(valeur == null || valeur.trim().isEmpty()) {
			return null;
		}
		return valeur.trim();
	}
	
	private void validerChamps(String ...champs) {
		
		for (String champ : champs) {
			if(getParameter(champ) == null) {
				
				erreurs.put(champ, "Vous devez renseigner ce champ");
			}
		}
	}
	
	private void validerPasswords() {
		
		String password = getParameter(CHAMP_PASSWORD);
		String passwordBis  = getParameter(CHAMP_PASSWORD_BIS);
		
		if(password != null && !password.equals(passwordBis)) {
			erreurs.put(CHAMP_PASSWORD,"Les mots de passe ne sont pas conformes");
			erreurs.put(CHAMP_PASSWORD_BIS,"Les mots de passe ne sont pas conformes");
		}
	}

	public boolean getStatus() {
		return status;
	}


	public String getStatusMessage() {
		return statusMessage;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public Map<String, String> getErreurs() {
		return erreurs;
	}
	

}
