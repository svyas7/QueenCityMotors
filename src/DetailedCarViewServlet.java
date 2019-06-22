import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uncc.sharat.database.DBManager;
import com.uncc.sharat.model.DetailedCarViewData;

@WebServlet(
        name = "detailedcarviewservlet",
        urlPatterns = "/DetailedCarView"
)

public class DetailedCarViewServlet extends HttpServlet {
	public static String targetVin = "null";
	public static String[][] detailedData = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("choggy was here");
		System.out.println("Getting from RadioButton:"+req.getParameter("carSelector"));
		targetVin =  req.getParameter("carSelector");
		detailedData = getData();
		DetailedCarViewData.setData(detailedData);
        RequestDispatcher view = req.getRequestDispatcher("detailedCarView.jsp");
        view.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("choggy was here");
		System.out.println("in the right servlet");
		RequestDispatcher view;
		view = req.getRequestDispatcher("detailedCarView.jsp");
		view.forward(req,resp);
	}
	
	private String [][] getData() {
		DBManager manager = new DBManager();
		String query = "select * from cardealership.inventory where VIN = '"+targetVin+"'";
		System.out.println("runnig query "+query);
		String [][] retVal =  manager.getQueryResult(query);
		for(int i=0;i<retVal.length;i++) {
			for(int j=0;j<retVal[0].length;j++) {
				System.out.print(retVal[i][j]+" ");
			}
			System.out.println("\n");
		}
		return retVal;
	}
}
