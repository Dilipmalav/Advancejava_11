package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PstmtRead {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		
	    ResultSet rs =	ps.executeQuery();
	    
	    while (rs.next()) {
			
	    	System.out.print("\t"+rs.getInt(1));
	    	System.out.print("\t"+rs.getInt(2));
	    	System.out.print("\t"+rs.getString(3));
	    	System.out.print("\t"+rs.getInt(4));
	    	System.out.print("\t"+rs.getInt(5));
	    	System.out.println("\t"+rs.getInt(6));
		}
	}
}
