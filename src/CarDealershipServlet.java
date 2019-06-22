import com.uncc.sharat.model.UserOption;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(
        name = "selectuseroptionservlet",
        urlPatterns = "/SelectOption"
)

public class CarDealershipServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userType = req.getParameter("Type");
        CarDealership dealership = new CarDealership();
        UserOption.UserType option = UserOption.UserType.valueOf(userType.toUpperCase());
        System.setProperty("dealership-user-type", option.toString());
        HashMap<String, ArrayList<String>> userOptions = dealership.getOptions(option);
        req.setAttribute("Options", userOptions);
        RequestDispatcher view;
        if(System.getProperty("UserAutheticated").equals("false"))
        	option = UserOption.UserType.CUSTOMER;
        if(option.equals(UserOption.UserType.CUSTOMER))
       		view = req.getRequestDispatcher("customer.jsp");
        else
        	view = req.getRequestDispatcher("employee.jsp");
        view.forward(req,resp);
    }
}
