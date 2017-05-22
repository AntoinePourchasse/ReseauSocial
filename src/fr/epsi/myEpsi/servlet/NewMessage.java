package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.service.MessageService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class NewMessage
 */
@WebServlet("/NewMessage")
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMessage() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/WEB-INF/NewMessage.jsp" ).forward( request, response );
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int status = 0;
		status = Integer.parseInt(request.getParameter("chooseone"));
		UserService US = new UserService();
		MessageService MS = new MessageService();
		Message message = new Message();
		message.setId((long) MS.nextId());
		message.setTitle(request.getParameter("titre"));
		message.setContent(request.getParameter("contenu"));
		message.setCreationDate(new Timestamp(System.currentTimeMillis()));
		message.setStatus(Status.values()[status]);
		message.setAuthor(US.getUserById((String) request.getSession().getAttribute("idUser")));
		MS.addMessage(message);
		
		//request.setAttribute("idUser", message.getAuthor().getId());
        this.getServletContext().getRequestDispatcher( "/listemessages" ).forward( request, response );
		doGet(request, response);
	}

}
