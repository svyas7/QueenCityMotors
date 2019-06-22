<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.uncc.sharat.model.DetailedCarViewData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="carImages.css">
<link rel="stylesheet" href="viewDetailedInventoryTable.css">
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
<head>
<meta charset="ISO-8859-1">
<title>More about this vehicle</title>
</head>
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
<img class = "one" src="resources/<%=DetailedCarViewData.VIN+".jpg"%>">
		
<table class="carDataTable">
<thead>
<tr>
<th colspan="2">More Information About The Car</th>
</tr>
</thead>
<tfoot>
<tr>
<td colspan="2">
</td>
</tr>
</tfoot>
<tbody>
<tr>
<td>Year</td>
<td><%=DetailedCarViewData.Year%></td>
</tr>
<tr>
<td>Make</td>
<td><%=DetailedCarViewData.Make%></td>
</tr>
<tr>
<td>Model</td>
<td><%=DetailedCarViewData.Model%></td>
</tr>
<tr>
<td>Status</td>
<td><%=DetailedCarViewData.Status%></td>
</tr>
<tr>
<td>Mileage</td>
<td><%=DetailedCarViewData.Mileage%></td>
</tr>
<tr>
<td>Price</td>
<td><%=DetailedCarViewData.Price%></td>
</tr>
<tr>
<td>Color</td>
<td><%=DetailedCarViewData.Color%></td>
</tr>
<tr>
<td>Description</td>
<td><%=DetailedCarViewData.Description%></td>
</tr>
</tbody>
</table>
	
	
</body>
</html>