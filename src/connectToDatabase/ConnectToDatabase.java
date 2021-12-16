package connectToDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectToDatabase {
	
	public Connection getConnection()
	{
		  String JdbcURL = "jdbc:mysql://localhost:3306/jdbc";
	      String Username = "jdbc";
	      String password = "Passer@1234";
	      Connection con = null;
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");  
	         
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	        
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      return con;
	}
	
	 public static void main(String[] args) {
	      
	 }
}
