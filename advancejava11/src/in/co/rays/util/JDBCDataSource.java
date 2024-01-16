package in.co.rays.util;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource datasource;

	private ComboPooledDataSource cpds = null;

	private JDBCDataSource() {
	}

	public static JDBCDataSource getInstance() {

		if (datasource == null) {
			
			ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			try {
				datasource.cpds.setDriverClass(rb.getString("Driver"));
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			datasource.cpds.setJdbcUrl(rb.getString("url"));
			datasource.cpds.setUser(rb.getString("username"));
			datasource.cpds.setPassword(rb.getString("password"));
			datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("InitialPoolSize")));
			datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("AcquireIncrement")));
			datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("MaxPoolSize")));
		}
		return datasource;
	}

	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}

	public static void trnRollback(Connection connection) throws Exception {
		if (connection != null) {

			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new Exception(ex.toString());
			}
		}
	}

}