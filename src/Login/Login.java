package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import forms.LoginForm;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", urlPatterns = { "/login","","/logout" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Connexion="/WEB-INF/Login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		getServletContext().getRequestDispatcher(Connexion).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		
		
		LoginForm form= new LoginForm(request);
		
		if (form.authentifier()) {
			
			response.sendRedirect(request.getContextPath()+"/list");
			
		}
		else {
			request.setAttribute("login", form.getLogin());
			getServletContext().getRequestDispatcher(Connexion).forward(request,response);
		}
			
		
		
		  
		
		
	}

}
