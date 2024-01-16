package in.co.rays.dynamicpstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicInsert {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		
		ps.setInt(1, 7);
		ps.setInt(2, 107);
		ps.setString(3, "pawan");
		ps.setInt(4, 85);
		ps.setInt(5, 98);
		ps.setInt(6, 78);
		
		int i = ps.executeUpdate();
		
		System.out.println("data inserted="+i);
		
	}

}
