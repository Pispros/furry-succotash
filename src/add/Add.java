package add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.AddUserForm;

/**
 * Servlet implementation class Add
 */
@WebServlet({"/add","/users/add"})
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_UTILISATEUR="/WEB-INF/ajoutUtilisateur.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
    	Object form = session.getAttribute("form");
    	
    	if( form != null) {
    		session.removeAttribute("form");
    	}
    	
    	request.setAttribute("form", form);
    	
    	//response.sendRedirect(request.getContextPath() + "/users/add");
		getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddUserForm form = new AddUserForm(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("form", form);
		
		if(form.ajouter()) {
			String url = request.getContextPath() +"/list" + "?message="+ form.getStatusMessage();
			
			response.sendRedirect(url);
		}
		else {
			response.sendRedirect(request.getContextPath() +"/users/add");
		}
//		System.out.println(form.ajouter());
		

		


	}

}
