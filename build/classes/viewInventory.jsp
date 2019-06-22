<%@ page import="java.util.*"%>
<%@ page import="com.uncc.sharat.database.DBManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
  margin-top: 1px;
  margin-right: 2px;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}

.button2 {
  background-color: white; 
  color: black; 
  border: 2px solid #008CBA;
}

.button2:hover {
  background-color: #008CBA;
  color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>View Inventory</title>
<body>
	<h1>
    <h1 style="background-color:purple;">
    <img src="resources/crown-clipart.png" alt="Flowers in Chania" width="100" height="80">
    <font color="gold">Available Options for Employees</font>
    <button onclick="location.href = 'index.html';" class="button button1"><i class="fa fa-home"></i>Home</button>
    <% 
    	String userType=null;
    	if(System.getProperty("dealership-user-type").equalsIgnoreCase("EMPLOYEE"))
    		userType = "employee.jsp";
    	else
    		userType = "customer.jsp";    			
    %>
<button onclick="location.href = '<%=userType%>';"class="button button2"><i class="fa fa-bars"></i>Menu</button>
</h1>
</h1>
	<%
			DBManager manager = new DBManager();
			String [][] table = manager.getQueryResult("select * from cardealership.inventory;");
	%>
	<form method="post" action="/CarDealership/DetailedCarView">
	<table>
		<link href="tableStyle.css" rel="stylesheet" type="text/css">
		<thead style="font-weight:bold;">
			<tr bgcolor="339FFF">
				<th>Get More Info</th>
				<th>VIN</th>
				<th>Make</th>
				<th>Model</th>
				<th>Year</th>
				<th>Status</th>
				<th>Mileage</th>
				<th>Price</th>			
				<th>Color</th>
				<th>Car Type</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i=1;i<table.length;i++){ %>
			<tr>
					<td><input type="radio" name="carSelector" value=<%="\""+table[i][0]+"\""%>></td>
					<td><%=table[i][0]%></td>
					<td><%=table[i][1]%></td>
					<td><%=table[i][2]%></td>
					<td><%=table[i][3]%></td>
					<td><%=table[i][4]%></td>
					<td><%=table[i][5]%></td>
					<td><%=table[i][6]%></td>
					<td><%=table[i][8]%></td>
					<td><%=table[i][9]%></td>
					<td><%=table[i][10]%></td>
			</tr>
			<% } //end loop %>
		</tbody>
	</table>
	 <input type="submit" value="Submit">
	</form>
</body>
</html>