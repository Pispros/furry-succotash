package forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDAO;

public class LoginForm {
	
	private HttpServletRequest request;
	private String login="";
	private static final String CHAMP_LOGIN="login";
	private static final String CHAMP_PASSWORD="password";
	
	public LoginForm(HttpServletRequest request) {
		this.request=request;
		
	}

	public boolean authentifier() {
		UtilisateurDAO userDAO = new UtilisateurDAO();
		 login=request.getParameter(CHAMP_LOGIN);
		String password=request.getParameter(CHAMP_PASSWORD);
		
		Utilisateur utilisateur = null;
		
		HttpSession session=request.getSession();
		
		if ("admin".equals(login) && "passer".equals(password)) 
		
		{
			utilisateur=new Utilisateur("ADMIN","ADMIN","ADMIN","ADMIN");
			session.setAttribute("utilisateur", utilisateur);
			
		}
		else 
		{
			utilisateur = userDAO.getByLogin(login);
			System.out.println(password);
			 System.out.println(utilisateur);
			if ( utilisateur!=null && password != null && !password.equals(utilisateur.getPassword()))
			{
				utilisateur=null;
			}
		}

	
		 
		if (utilisateur!=null) {
			session.setAttribute("utilisateur", utilisateur);
			return true;
		}
		
		return false;
		
		
	}
	public String getLogin() {
		return this.login;
	
	
}
}
