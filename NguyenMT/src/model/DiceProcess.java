package model;

public class DiceProcess {
	public Die dice1;
	public Die dice2;
	public Die dice3;
	public String msg = "";
	public String diceImage = "";
	public String endMsg = "";
	public double currentWinnings = 0;
	public double overallWinnings = 0;
	public double currentPurse = 1000;
	public int currentRoll = 0;
	public int roll1;
	public int roll2;
	public int roll3;
public DiceProcess()
{
	
}
	
public DiceProcess(Die die1, Die die2, Die die3, double currentPurse1, int currentRoll1)
{
	dice1 = die1;
	dice2 = die2;
	dice3 = die3;
	roll1 = die1.getValue();
	roll2 = die2.getValue();
	roll3 = die3.getValue();
	currentPurse = currentPurse1;
	currentRoll = currentRoll1;
}

public void setDiceImage()
{
	diceImage += "<div class='diceImage'>"+ 
	"<img src='images/Dice-" + dice1.getValue() + ".png'>" +
	"<img src='images/Dice-" + dice2.getValue() + ".png'>" +
	"<img src='images/Dice-" + dice3.getValue() + ".png'></div>";
}

public String getDiceImage()
{
	return diceImage;
}

public void calculateSingleWinnings(double singleBet, int diceValue)
{
	double singleWinnings = 0;
	if(roll1 == diceValue && roll2 == diceValue && roll3 == diceValue)
	{
		singleWinnings = singleBet*10;
		msg += "Single Bet - Winner - Winnings: " + singleWinnings + "<br>";
	}
	else if((roll1 == diceValue && roll2 == diceValue) || (roll1 == diceValue && roll3 == diceValue) ||
			(roll2 == diceValue && roll3 == diceValue))
	{
		singleWinnings = singleBet*2;
		msg += "Single Bet - Winner - Winnings: " + singleWinnings + "<br>";
	}
	else if (roll1 == diceValue || roll2 == diceValue || roll3 == diceValue){
		singleWinnings = singleBet;
		msg += "Single Bet - Winner - Winnings: " + singleWinnings + "<br>";
	}
	else 
	{
		msg += "Single Bet - Loser - Losses: " + -singleBet + "<br>";
		singleWinnings -= singleBet;
	}
	currentWinnings += singleWinnings;
	currentPurse += singleWinnings;
	
}

public void calculateTripleWinnings(double tripleBet)
{
	double tripleWinnings = 0;
		if(roll1 == roll2 && roll2 == roll3)
		{
			tripleWinnings = tripleBet*30;
			msg += "Triple Bet - Winner - Winnings: " + tripleWinnings + "<br>";
		}
		else 
		{
			msg += "Triple Bet - Loser - Losses: " + -tripleBet + "<br>";
			tripleWinnings -= tripleBet;
		}
		currentWinnings += tripleWinnings;	
		currentPurse += tripleWinnings;
}

public void calculateBigWinnings(double bigBet)
{
	double bigWinnings = 0;
	if((roll1+roll2+roll3) >= 11 && !(roll1 == roll2  && roll2 == roll3))
	{
		bigWinnings = bigBet;
		msg += "Big Bet - Winner - Winnings: " + bigWinnings + "<br>";
	}
	else 
	{
		msg += "Big Bet - Loser - Losses: " + -bigBet + "<br>";
		bigWinnings -= bigBet;
	}
	currentWinnings += bigWinnings;
	currentPurse += bigWinnings;
}

public void calculateSmallWinnings(double smallBet)
{
	double smallWinnings = 0;
	if((roll1+roll2+roll3) < 11 && !(roll1 == roll2 && roll2 == roll3))
	{
		smallWinnings = smallBet;
		msg += "Small Bet - Winner - Winnings: " + smallWinnings + "<br>";
	}
	else 
	{
		msg += "Small Bet - Loser - Losses: " + -smallBet + "<br>";
		smallWinnings -=smallBet;
	}
	currentWinnings += smallWinnings;
	currentPurse += smallWinnings;
}

public void calculateFieldWinnings(double fieldBet)
{
	double fieldWinnings = 0;
	if((roll1+roll2+roll3) < 8 || (roll1+roll2+roll3) > 12)
	{
		fieldWinnings = fieldBet;
		msg += "Field Bet - Winner - Winnings: " + fieldWinnings + "<br>";
	}
	else
	{
		msg += "Field Bet - Loser - Losses: " + -fieldBet + "<br>";
		fieldWinnings -= fieldBet;
	}
	currentWinnings += fieldWinnings;
	currentPurse += fieldWinnings;
}

public double calculateCurrentPurse()
{

	return currentPurse;
}

public double getCurrentWinnings()
{
	return currentWinnings;
}

public String printOutQuit()
{
	endMsg += "Final Purse: $" + currentPurse + "<br>";
	endMsg += "Number of Rolls: " + currentRoll + "<br>";
	if(currentWinnings >0)
	{
		endMsg += "Congratulations! You're a winner. Please come again.";
	}
	else
	{
		endMsg += "You're a loser.";
	}
	if(currentPurse>0)
	{
		endMsg += "<form action='roll.jsp'> <button type='submit' name='action' value='Submit'>Play Again/>";
		endMsg += "<input type='hidden' name='currentPurse' value='<%= currentPurse %>'>" +
				"<input type='hidden' name='currentPurse' value='<%= currentPurse %>'>" +
				"<input type='hidden' name='currentRoll' value='<%= currentRoll %>'>" +
				"<input type='hidden' name='overallWinnings' value='<%= overallWinnings %>'>";
		endMsg += "</form>";
	}
	
	endMsg+= "<form action='quit.jsp'> <input type='submit' name='action' value='Submit'>Quit/>";
	endMsg+= "<input type='hidden' name='currentPurse' value='<%= currentPurse %>'>" +
	"<input type='hidden' name='currentPurse' value='<%= currentPurse %>'>" +
	"<input type='hidden' name='currentRoll' value='<%= currentRoll %>'>" +
	"<input type='hidden' name='overallWinnings' value='<%= overallWinnings %>'>" +
	"</form>";
	
	
	return endMsg;
}


public String printOutResult(double overallWinnings)
{ 
	
	msg+= "Total winnings for this roll: " + currentWinnings +"<br>";
	msg+= "Total winnings overall: " + overallWinnings;
	msg += "<input type='hidden' name='currentPurse' value='<%= currentPurse %>'>" +
"<input type='hidden' name='currentPurse' value='<%= currentPurse %>'>" +
"<input type='hidden' name='currentRoll' value='<%= currentRoll %>'>" +
"<input type='hidden' name='overallWinnings' value='<%= overallWinnings %>'>";
	return msg;
}
}
