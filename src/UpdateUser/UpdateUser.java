package UpdateUser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDAO;;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDAO userDAO = new UtilisateurDAO();
		String id = request.getParameter("id");
		if( id != null) {
			Utilisateur utilisateur = userDAO.get(Integer.parseInt(id));
			System.out.println("Utilisateur "+ utilisateur);
			if(utilisateur != null) {
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher("/WEB-INF/modifier.jsp").forward(request, response);
			}
		}
		response.sendRedirect(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDAO userDAO = new UtilisateurDAO();
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		
		if( id != null && id.matches("[0-9]+")) {
			
			Utilisateur utilisateur = new Utilisateur(Integer.parseInt(id), nom, prenom, login, password);
			userDAO.modifier(utilisateur);			
		}
		response.sendRedirect(request.getContextPath()+"/list");
		

	}

}
