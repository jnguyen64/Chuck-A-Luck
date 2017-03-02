<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% String msg = (String) request.getAttribute("msg"); %>
     <% String genericMsg = (String) request.getAttribute("genericMsg"); %>
      <% double updatedPurse =  (double)request.getAttribute("updatedPurse"); %>
    <% int currentRoll =  (int)request.getAttribute("currentRoll"); %>
    <% double overallWinnings = (double)request.getAttribute("overallWinnings"); %>
    <% String playAgain = (String) request.getAttribute("playAgain"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Title</title>
</head>
<body>
<h1>MIST4630 Chuck-a-Luck - Result Page</h1>
<h5><%= genericMsg %></h5>
<%= msg %>
	<input type="hidden" name="currentPurse" value="<%= updatedPurse %>">
	<input type="hidden" name="currentRoll" value="<%= currentRoll %>">
	<input type="hidden" name="overallWinnings" value="<%= overallWinnings %>">
	</form>

</body>
</html>