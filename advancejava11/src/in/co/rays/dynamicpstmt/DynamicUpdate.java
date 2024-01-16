package in.co.rays.dynamicpstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set rollno=?, name=?, phy=?, che=?, maths=? where id=?");
		
		ps.setInt(1, 101);
		ps.setString(2, "ramsh");
		ps.setInt(3, 70);
		ps.setInt(4, 70);
		ps.setInt(5, 70);
		ps.setInt(6, 1);
		
		int i = ps.executeUpdate();
		
		System.out.println("data updated="+i);
	}

}
