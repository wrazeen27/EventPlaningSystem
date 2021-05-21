package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import service.EventServiceImp;
import service.IEventService;

/**
 * Servlet implementation class GetEventServlet
 */
@WebServlet("/GetEventServlet")

public class GetEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEventServlet() {
        super();
        
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
		
		String eventID = request.getParameter("EventID");
		IEventService iEventService = new EventServiceImp();
		Event event = iEventService.getEventByID(eventID);
		
		request.setAttribute("event", event);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsps/getEvent.jsp");
		dispatcher.forward(request, response);

		
	}

}
