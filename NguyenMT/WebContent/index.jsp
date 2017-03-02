<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
 <% double currentPurse = 1000.00; %>
 <% int currentRoll = 1; %>
 <% double overallWinnings = 0; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIST4630 Chuck-A-Luck Game</title>
</head>
<body>
	<h1>MIST4630 Chuck-A-Luck Game</h1>
	<h3>Place a bet and try your luck!</h3>
	<div class="diceImage">
	<img src="images/Dice-5.png">
	<img src="images/Dice-3.png">
	<img src="images/Dice-1.png"></div> 
	<h5>You start with a stake of $1,000.00</h5>
	<p><form action="PlaceBet" method="post">
    <input type="submit" value="Play" />

	<input type="hidden" name="currentPurse" value="<%= currentPurse %>">
	<input type="hidden" name="currentRoll" value="<%= currentRoll %>">
	<input type="hidden" name="overallWinnings" value="<%= overallWinnings %>">
	</form></p>
</body>
</html>