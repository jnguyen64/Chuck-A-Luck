<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <% double updatedPurse =  (double)request.getAttribute("updatedPurse"); %>
    <% int currentRoll =  (int)request.getAttribute("currentRoll"); %>
    <% double overallWinnings = (double)request.getAttribute("overallWinnings"); %>
     <% //double currentPurse =  (double)request.getAttribute("currentPurse"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIST4630 Chuck-a-Luck - Bet Page</title>
</head>
<body>
<h1>MIST4630 Chuck-a-Luck - Bet Page</h1>
<h5> Current Purse: $ <%= updatedPurse %> </h5>
<h5> Current Roll: <%= currentRoll %></h5>

<form action="Process" method="post">
<table>
<tr> 
<td><input type="checkbox" name="single" value="Single">Single </td>
<td>
	<select name="DieValue">
		<option value ="1">1</option>
		<option value ="2">2</option>
		<option value ="3">3</option>
		<option value ="4">4</option>
		<option value ="5">5</option>
		<option value ="6">6</option>
	</select>
</td>
<td><p>Bet Amount:</p><input type="text" name="betAmountSingle" > </td>
<td><p>1 die, 1 to 1; 2 dice, 2 to 1; 3 dice, 10 to 1</p></td>
</tr>	

<tr> 
<td><input type="checkbox" name="triple" value="Triple">Any Triple </td>
<td>
	<p> Any of the triples </p>
</td>
<td><p>Bet Amount:</p><input type="text" name="betAmountTriple" > </td>
<td><p>30 to 1</p></td>
</tr>	

<tr> 
<td><input type="checkbox" name="big" value="Big">Big </td>
<td>
	<p> Sum of Dice 11 or higher (except triple) </p>
</td>
<td><p>Bet Amount:</p><input type="text" name="betAmountBig" > </td>
<td><p>1 to 1</p></td>
</tr>	

<tr> 
<td><input type="checkbox" name="small" value="Small">Small </td>
<td>
	<p> Sum of Dice 10 or lower (except triple) </p>
</td>
<td><p>Bet Amount:</p><input type="text" name="betAmountSmall" > </td>
<td><p>1 to 1</p></td>
</tr>	

<tr> 
<td><input type="checkbox" name="field" value="Field">Field </td>
<td>
	<p> Sum outside the range of 8 to 12 </p>
</td>
<td><p>Bet Amount:</p><input type="text" name="betAmountField" > </td>
<td><p>1 to 1</p></td>
</tr>	

</table>
<input type="hidden" name="updatedPurse" value="<%= updatedPurse %>">
<input type="hidden" name="currentRoll" value="<%= currentRoll %>">
<input type="hidden" name="overallWinnings" value="<%= overallWinnings %>">
<input type="submit" value="Place Bet">
</form>
</body>
</html>