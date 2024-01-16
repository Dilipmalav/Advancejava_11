package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {

	 public static void main(String[] args) throws Exception {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		 
		 Statement stmt = conn.createStatement();
		 
		 int i = stmt.executeUpdate("update marksheet set phy = 100, che = 100, maths = 100 where id = 1");
		 
		 System.out.println("data updated = " +i);
	}
}
