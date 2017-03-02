<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%	String msg = (String) request.getAttribute("msg"); %>
  <% String diceImage = (String) request.getAttribute("diceImage"); %>
  <% double currentPurse =  (double)request.getAttribute("updatedPurse"); %>
  <% int currentRoll =  (int)request.getAttribute("currentRoll"); %>
  <% double overallWinnings = (double)request.getAttribute("overallWinnings"); %>
  <% double currentWinnings = (double)request.getAttribute("currentWinnings"); %>
  <% String playAgainMsg = (String) request.getAttribute("playAgainMsg"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roll Results</title>
</head>
<body>
<h1>MIST4630 Chuck-a-Luck - Roll Results</h1>
<h5> Current Purse: $<%= currentPurse %> </h5>
<h5> Current Roll: <%= currentRoll %></h5>
<%= diceImage %>
<%= msg %>
<%= playAgainMsg %>

	<input type="hidden" name="updatedPurse" value="<%= currentPurse %>">
	<input type="hidden" name="currentRoll" value="<%= currentRoll %>">
	<input type="hidden" name="overallWinnings" value="<%= overallWinnings %>">
	<input type="hidden" name="currentWinnings" value="<%= currentWinnings %>">
	<input type="hidden" name="playAgain" value="true">
	</form>
	
	<br><br>
<form action="Result" method ="post">
    <input type="submit" value="Quit" />
<input type="hidden" name="updatedPurse" value="<%= currentPurse %>">
<input type="hidden" name="currentRoll" value="<%= currentRoll %>">
<input type="hidden" name="overallWinnings" value="<%= overallWinnings %>">
<input type="hidden" name="currentWinnings" value="<%= currentWinnings %>">
<input type="hidden" name="playAgain" value="false">
</form>

</body>
</html>