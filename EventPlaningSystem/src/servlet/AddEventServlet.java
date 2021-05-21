package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.Format;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.Event;
import service.EventServiceImp;
import service.IEventService;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		Event event = new Event();			
		event.setEventName(request.getParameter("eventName"));		
		event.setEventDate(request.getParameter("eventDate"));
		event.setStartTime(request.getParameter("eventTime"));
		event.setVenue(request.getParameter("location"));
		event.setMaxPrticipants(Integer.parseInt(request.getParameter("maxParticipants")));
		
		IEventService iEventService = new EventServiceImp();
		iEventService.addEvent(event);
		
		request.setAttribute("event", event);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsps/ListEvents.jsp");
		dispatcher.forward(request, response);
	}

}
