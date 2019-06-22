<%@ page import ="java.util.*" %>
<%@ page import="com.uncc.sharat.database.DBManager" %>
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
	out.println("<a href=/CarDealership/ViewInventory>View Inventory<br><br>");
    out.println("<a href=/CarDealership/addToInventory.jsp>Add A Car Inventory<br><br>");
    out.println("<a href=/CarDealership/removeCar.jsp>Remove A Car From Inventory<br><br>");
    out.println("<a href=/CarDealership/AboutUs>About Us<br><br>");
    
%>
</body>
</html>