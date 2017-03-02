package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RollServlet
 */
@WebServlet("/Result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
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
		double overallWinnings = Double.parseDouble(request.getParameter("overallWinnings"));
		double updatedPurse = Double.parseDouble(request.getParameter("updatedPurse"));
		int currentRoll = Integer.parseInt(request.getParameter("currentRoll"));
		double currentWinnings = Double.parseDouble(request.getParameter("currentWinnings"));
		String playAgain = request.getParameter("playAgain");
		String url = "quit.jsp";
		String msg = "";
		String genericMsg = "";
		genericMsg += "Final Purse: $" + updatedPurse + "<br>";
		genericMsg += "Number of Rolls: " + currentRoll + "<br>";
		if(currentWinnings>0){
			genericMsg += "Congratulations! You're a winner. Please come again.";
		}
		else {
			genericMsg += "You're a loser.";
		}
		
		currentRoll++;
		if(updatedPurse>0 && playAgain.equals("true"))
		{
			msg += "<form action='PlaceBet' method='post'>";
			msg += "<input type='submit' value='GO GO GO' />";
		}
		else
		{
			genericMsg += "<br> Thanks for playing!";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("currentRoll", currentRoll);
		request.setAttribute("overallWinnings", overallWinnings);
		request.setAttribute("genericMsg", genericMsg);
		request.setAttribute("updatedPurse", updatedPurse);
		request.setAttribute("playAgain", playAgain);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}
