import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uncc.sharat.database.DBManager;

@WebServlet(
        name = "viewinventoryservlet",
        urlPatterns = "/ViewInventory"
)

public class ViewInventoryServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String requestType = req.getParameter("reqType");
		if(requestType.equalsIgnoreCase("addInventory"))
			addCarToInventory(req);
		else
			removeCarFromInventory(req);
        RequestDispatcher view = req.getRequestDispatcher("viewInventory.jsp");
        view.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("in the right servlet");
		RequestDispatcher view;
		view = req.getRequestDispatcher("viewInventory.jsp");
		view.forward(req,resp);
	}
	
	private void addCarToInventory(HttpServletRequest req) {
		System.out.println("Adding car");
        String vin = req.getParameter("vin").toUpperCase();
		String make = req.getParameter("make").toUpperCase();
        String model = req.getParameter("model").toUpperCase();
        String year = req.getParameter("year").toUpperCase();
        String status = req.getParameter("carStatus").toUpperCase();
        String mileage = req.getParameter("mileage").toUpperCase();
        String price = req.getParameter("price").toUpperCase();
        String salesmanId = req.getParameter("salesmanID").toUpperCase();
        String color = req.getParameter("color").toUpperCase();
        String carType = req.getParameter("carType").toUpperCase();
        String description = req.getParameter("description").toUpperCase();
        DBManager dbManager = new DBManager();
        dbManager.addCarToInventory(make, model, vin, year, status, mileage, price, salesmanId, color, carType, description);
	}
	
	private void removeCarFromInventory(HttpServletRequest req) {
		System.out.println("Removing car");
		String vinToRemove = req.getParameter("vin").toUpperCase();
		DBManager dbManager = new DBManager();
		dbManager.removeCarFromInventory(vinToRemove);
	}

}
