import com.uncc.sharat.database.DBManager;
import com.uncc.sharat.model.UserOption;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarDealership {

    public HashMap<String,ArrayList<String>> getOptions(UserOption.UserType userType){
    	HashMap<String, ArrayList<String>> retVal = new HashMap<>();
    	
    	ArrayList<String> userOptionsText = new ArrayList<String>();
        ArrayList<String> userOptionsURL = new ArrayList<String>();
        if(userType.equals(UserOption.UserType.CUSTOMER)){
        	userOptionsURL.add("viewInventory.jsp");
        	userOptionsURL.add("aboutUs.jsp");
        	userOptionsText.add("View Inventory");
        	userOptionsText.add("View About Us");
        }
        if(userType.equals(UserOption.UserType.EMPLOYEE)){
        	userOptionsURL.add("viewInventory.jsp");
        	userOptionsURL.add("addInventory.jsp");
        	userOptionsURL.add("removeInventory.jsp");
        	userOptionsURL.add("aboutUs.jsp");
        	userOptionsText.add("View Inventory");
        	userOptionsText.add("Add To Inventory");
        	userOptionsText.add("Remove From Inventory");
        	userOptionsText.add("View About Us");
        }
        
        retVal.put("url", userOptionsURL);
    	retVal.put("text", userOptionsText);

        DBManager manager = new DBManager();
        Connection connection = manager.getConnection();
        if(connection == null)
            System.out.println("failed");
        else
            System.out.println("passed");
        return retVal;
    }
}
