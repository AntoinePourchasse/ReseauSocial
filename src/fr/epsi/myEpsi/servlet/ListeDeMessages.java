package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.IMessageService;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.MessageService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class ListeDesMessages
 */
@WebServlet("/ListeDesMessages")
public class ListeDeMessages extends HttpServlet {
	IMessageService service = new MessageService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeDeMessages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService US = new UserService();
		User user = US.getUserById((String) request.getSession().getAttribute("idUser"));
		List<Message> messages = service.getListOfMessages(user);
		
		request.setAttribute("messages", messages);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ListeDesMessages.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
