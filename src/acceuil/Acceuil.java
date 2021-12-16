



package acceuil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDAO;

/**
 * Servlet implementation class Acceuil
 */
@WebServlet(name = "acceuil", urlPatterns = { "/acceuil","/list" })

public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LIST_USERS = "/WEB-INF/index.jsp";       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session =request.getSession();
		
    	Object form = session.getAttribute("form");
    	
    	boolean status = false;
    	
    	if( form != null) {
    		session.removeAttribute("form");
    		status = true;
    	}
    	UtilisateurDAO userDAO = new UtilisateurDAO();
		request.setAttribute("status", status);
		request.setAttribute("utilisateurs",userDAO.Lister()); 
		getServletContext().getRequestDispatcher(VUE_LIST_USERS).forward(request,response);
	}

	
	

}

