package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PstmtUpdate {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set phy=90, che=90, maths=90 where id=1");
		
		int i = ps.executeUpdate();
		
		System.out.println("data updated = "+i);
	}
}
