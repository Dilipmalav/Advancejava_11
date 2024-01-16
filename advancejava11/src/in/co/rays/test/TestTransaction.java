package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
			
			 conn.setAutoCommit(false);
			
			Statement stmt  = conn.createStatement();
			
			int i = stmt.executeUpdate("insert into emp values(13, 'jayesh', 15000, 2)");
			i = stmt.executeUpdate("insert into emp values(14, 'lavesh', 15000, 2)");
			i = stmt.executeUpdate("insert into emp values(15, 'suresh', 15000, 2)");
			
			conn.commit();
			conn.close();
			System.out.println("data inserted = "+i);
			
		} catch (Exception e) {
			conn.rollback();
		}
		
	}
	
}
