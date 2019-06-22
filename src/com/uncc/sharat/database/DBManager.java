package com.uncc.sharat.database;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager {
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardealership", "root", "");
            return conn;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public String[][] getQueryResult(String query) {
    	Connection connection = getConnection();
    	String [][] retVal = null;
    	try (Statement stmt = connection.createStatement()) {
    	    ResultSet rs = stmt.executeQuery(query);
    	    retVal = convertResultSet(rs);
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
    }
    
    public String [][] convertResultSet(ResultSet rs) throws Exception {
    	ResultSetMetaData rsmd = rs.getMetaData();
    	int numCols = rsmd.getColumnCount();
    	int numRows = getRowCount(rs);
    	String [][] retVal = initializeRetValTable(numRows,numCols,rsmd);

    	try {
			while (rs.next()) { 
//			    names.add(rs.getString(1));
//			    subjects.add(rs.getString(2));
				for(int i=1;i<numCols+1;i++) {
					retVal[rs.getRow()][i-1] = rs.getString(i);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	// finally turn the array lists into arrays - if really needed
		return retVal;
    }
    
    private int getRowCount(ResultSet rs) throws SQLException {
    	int count=0;
    	rs.last();
    	count = rs.getRow();
    	rs.beforeFirst();
		return count;
    }
    
    private String [][] initializeRetValTable(int numRows, int numCols, ResultSetMetaData rsmd){
    	String [][] retVal = new String [numRows+1][numCols];
    	for(int i=1;i<numCols+1;i++) {
    		try {
				retVal[0][i-1] = rsmd.getColumnName(i);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
    	}
    	return retVal;
    }
    
    public void addCarToInventory(String make, String model, String VIN, String year, String status, String mileage, String price,String salesmanID ,String color, String carType, String description) {
    	Connection connection  = getConnection();
    	
    	try(Statement stmt = connection.createStatement()){
    		String targetQuery = "Insert into cardealership.inventory values ('"+VIN+"','"+make+"','"+model+"','"+year+"','"+status+"','"+mileage+"','"+price+"','"+salesmanID+"','"+color+"','"+carType+"','"+description+"');";
    		System.out.println("TARGET QUERY: "+targetQuery);
    		stmt.executeUpdate(targetQuery);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void removeCarFromInventory(String vin) {
    	Connection connection  = getConnection();
    	try(Statement stmt = connection.createStatement()){
    		String targetQuery = "Delete from cardealership.inventory where VIN = '"+vin+"';";
    		System.out.println("TARGET QUERY: "+targetQuery);
    		stmt.executeUpdate(targetQuery);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
