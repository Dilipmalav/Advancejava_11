package in.co.rays.pstmtcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DynamicPstmtCrud {
	
	public static void main(String[] args) throws Exception {
		DynamicPstmtCrud dc = new DynamicPstmtCrud();
		//testAdd(8,108,"monu",77,88,99);
		//testDelete(8);
		//testUpdate(7,107,"ram",55,66,44);
		//testRead();
		//DynamicPstmtCrud.findById();
		//testFindById();
		dc.findById(5);
	}

	private static void testAdd(int id, int rollno, String name, int phy, int che, int maths) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");		
		
        PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
        
        ps.setInt(1, id);
        ps.setInt(2, rollno);
        ps.setString(3, name);
        ps.setInt(4, phy);
        ps.setInt(5, che);
        ps.setInt(6, maths);
        
        int i = ps.executeUpdate();
        
        System.out.println("data inserted = "+i);
		
	}
	
	private static void testDelete(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id=?");
		
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		System.out.println("data deleted = "+i);
		
		}
	
	private static void testUpdate(int id, int rollno, String name, int phy, int che, int maths) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set rollno=?, name=?, phy=?, che=?, maths=? where id=?");
		
		ps.setInt(1, rollno);
		ps.setString(2, name);
		ps.setInt(3, phy);
		ps.setInt(4, che);
		ps.setInt(5, maths);
		ps.setInt(6, id);
		
		int i = ps.executeUpdate();
		
		System.out.println("data updated = "+i);
		
	}
   
	private static void testRead() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			System.out.print("\t"+rs.getInt(1));
	    	System.out.print("\t"+rs.getInt(2));
	    	System.out.print("\t"+rs.getString(3));
	    	System.out.print("\t"+rs.getInt(4));
	    	System.out.print("\t"+rs.getInt(5));
	    	System.out.println("\t"+rs.getInt(6));
			
		}
	}
	
private static void findById(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id=?");
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
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
