package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DiceProcess;
import model.Die;

/**
 * Servlet implementation class Process
 */
@WebServlet(description = "this does the process", urlPatterns= { "/Process" })
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
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
		
		
		
		//get input
		double overallWinnings = Double.parseDouble(request.getParameter("overallWinnings"));
		double updatedPurse = Double.parseDouble(request.getParameter("updatedPurse"));
		int currentRoll = Integer.parseInt(request.getParameter("currentRoll"));
		
		String[] single = request.getParameterValues("single");
		String[] triple = request.getParameterValues("triple");
		String[] big = request.getParameterValues("big");
		String[] small = request.getParameterValues("small");
		String[] field = request.getParameterValues("field");
		
		//initialize output
		String diceImage = "";
		String url = "roll.jsp";
		String msg = "";
		
		Die die1 = new Die();
		Die die2 = new Die();
		Die die3 = new Die();
		DiceProcess process = new DiceProcess(die1, die2, die3, updatedPurse, currentRoll);
		
		
		
		if(single!=null)
		{
			Double singleBet = Double.parseDouble(request.getParameter("betAmountSingle"));
			int dieValue = Integer.parseInt(request.getParameter("DieValue"));
			process.calculateSingleWinnings(singleBet, dieValue);	
			
		}
		if(triple!=null)
		{
			Double tripleBet = Double.parseDouble(request.getParameter("betAmountTriple"));
			process.calculateTripleWinnings(tripleBet);
		}
		
		if(big!=null)
		{
			Double bigBet = Double.parseDouble(request.getParameter("betAmountBig"));
			process.calculateBigWinnings(bigBet);
		}
		
		if(small!=null)
		{
			Double smallBet = Double.parseDouble(request.getParameter("betAmountSmall"));
			process.calculateSmallWinnings(smallBet);
		}
		
		if(field!=null)
		{
			Double fieldBet = Double.parseDouble(request.getParameter("betAmountField"));
			process.calculateFieldWinnings(fieldBet);
		}
	
		
		updatedPurse = process.calculateCurrentPurse();
		process.setDiceImage();
		diceImage = process.getDiceImage();
	
		double currentWinnings = process.getCurrentWinnings();
		overallWinnings += process.getCurrentWinnings();
		msg = process.printOutResult(overallWinnings);
		String playAgainMsg = "";
		if(updatedPurse>0)
		{
			playAgainMsg+= "<form action='Result' method='post'>";
			playAgainMsg+= "<input type='submit' value='Play Again' />";
		}
		
		
		request.setAttribute("diceImage", diceImage);
		request.setAttribute("msg", msg);
		request.setAttribute("updatedPurse", updatedPurse);
		request.setAttribute("currentRoll", currentRoll);
		request.setAttribute("overallWinnings", overallWinnings);
		request.setAttribute("currentWinnings", currentWinnings);
		request.setAttribute("playAgainMsg", playAgainMsg);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}
