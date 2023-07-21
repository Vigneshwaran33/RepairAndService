package model;
import java.sql.*;
public class Dbconnection {
    private static Connection con;
    private static Statement st;
    
    static {
    	try {
    		con=DriverManager.getConnection("jdbc:mysql://localhost/repair_service","root","");
    		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    	}
    	catch(SQLException e) {
    	throw new RuntimeException(e);
    	}
    }
    public static Connection getConnection() {
    	return con;
    }
    public static Statement getStatement() {
     return st;
    }
  
    
}
