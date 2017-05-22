package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class ListeDesUtilisateurs
 */
@WebServlet("/ListeDesUtilisateurs")
public class ListeDesUtilisateurs extends HttpServlet {
	IUserService service = new UserService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeDesUtilisateurs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User test = new User();
		test.setId("toto@titi.com");
		test.setPassword("tata");
		test.setAdministrator(false);
		//service.addUser(test);
		List<User> user = service.getListOfUsers();
		//List<User> user = new ArrayList<User>();
		//user.add(test);
		request.setAttribute("users", user);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ListeDesUtilisateurs.jsp" ).forward( request, response );
	}

}
