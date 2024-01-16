package in.co.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class UserModel {
	
	public void add(UserBean bean) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstname());
		ps.setString(3, bean.getLastname());
		ps.setString(4, bean.getLoginid());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
		
		int i = ps.executeUpdate();
		
		System.out.println("data inserted = "+i);
	}
	
	public void update(UserBean bean) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("update user set firstname=?, lastname=?, loginid=?, password=?, dob=?, address=? where id=?");
		
	    ps.setString(1, bean.getFirstname());
		ps.setString(2, bean.getLastname());
		ps.setString(3, bean.getLoginid());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());
		
		int i = ps.executeUpdate();
		
		System.out.println("data upadted = "+i);
	}
	
	
	public void delete(int id) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		System.out.println("data deleted = "+i);
		
		
	}
	
	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		
		 Connection conn = JDBCDataSource.getConnection();
		 
		 StringBuffer sql = new StringBuffer("select * from user where 1=1");
		 
		 if (bean != null) {
			 if (bean.getFirstname() != null && bean.getFirstname().length() > 0) {
				sql.append(" and first_name like '"+bean.getFirstname()+"%' "); 
				
				if (bean.getDob() != null && bean.getDob().getTime() > 0) {
					sql.append(" and dob like '"+new java.sql.Date(bean.getDob().getTime())+"&'");
				}
			}
			 if (pageSize > 0) {
				 pageNo = (pageNo - 1) * pageSize;
				 sql.append(" limit " + pageNo + "," + pageSize );
			}
			
		}
		
		 System.out.println("sql===>>>"+sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		
		while (rs.next()) {
			 bean = new UserBean();
			
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
			
		}
		return list;
	}
	
	public UserBean findById(int id) throws Exception {
		

		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		UserBean bean = null;
		
		while (rs.next()) {
			
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			
		}
		return bean;
	}
	
	public UserBean authenticate(String loginid, String password) throws Exception {
		
		    Connection conn = JDBCDataSource.getConnection();
			
		    PreparedStatement ps = conn.prepareStatement("select * from user where login_id = ? and password = ?");
		    
		    ps.setString(1, loginid);
		    ps.setString(2, password);
		    
		    ResultSet rs = ps.executeQuery();
		    
		    UserBean bean = null;
		    
		    while (rs.next()) {
		    	
		    	bean = new UserBean();
		    	bean.setId(rs.getInt(1));
		    	bean.setFirstname(rs.getString(2));
		    	bean.setLastname(rs.getString(3));
		    	bean.setLoginid(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
			
		    }
		    return bean;
	}

}
