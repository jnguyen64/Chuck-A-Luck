package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlaceBet
 */
@WebServlet("/PlaceBet")
public class PlaceBetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceBetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     //double currentPurse =  Double.parseDouble(request.getParameter("currentPurse")); 
	     int currentRoll =  Integer.parseInt(request.getParameter("currentRoll")); 
	    double overallWinnings = Double.parseDouble(request.getParameter("overallWinnings")); 
	    double currentPurse =  Double.parseDouble(request.getParameter("currentPurse")); 
	    double updatedPurse = currentPurse;
	    String url = "GameSettings.jsp";
	  
	    request.setAttribute("updatedPurse", updatedPurse);
	    request.setAttribute("currentRoll", currentRoll);
	    request.setAttribute("overallWinnings", overallWinnings);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}
