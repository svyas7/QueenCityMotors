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
<head>
<meta charset="ISO-8859-1">
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
	<form method="post" action="/CarDealership/ViewInventory">
	  VIN:<br>
	  <input type="text" name="vin" value="" required>
	  <br>
	  Make:<br>
	  <input type="text" name="make" value="" required>
	  <br>
	  Model:<br>
	  <input type="text" name="model" value="" required>
	  <br>
	  Year:<br>
	  <input type="number" name="year" value="" required>
	  <br>
	  Status:<br>
		  <select name="carStatus">
		    <option value="new">New</option>
		    <option value="used">Used</option>
		  </select>
	  <br>
	  Mileage:<br>
	  <input type="number" name="mileage" value="" required>
	  <br>
	  Price:<br>
	  <input type="number" name="price" value="" required>
	  <br>
	  Salesman ID:<br>
	  <input type="number" name="salesmanID" value="" required>
	  <br>
	  Color:<br>
	  <input type="text" name="color" value="" required>
	  <br>
	  Car Type:<br>
	  		<select name="carType">
			    <option value="sedan">Sedan</option>
			    <option value="suv">SUV</option>
			    <option value="convertible">Convertible</option>
			    <option value="pickup">Pick-Up Truck</option>
			    <option value="coupe">Coupe</option>
			    <option value="cabriolet">Cabriolet</option>
		  	</select>
	  <br>
	  Description:<br>
	  <input type="text" name="description" value="" required>
	  <br>
	  <br><br>
	   <input type="hidden" name="reqType" value="addInventory" required>
  <input type="submit" value="Submit">
</form> 
</body>
</html>