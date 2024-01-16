package in.co.rays.test;

import java.util.ResourceBundle;

public class TestResourceBundleSystem {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.System");
		
		System.out.println(rb.getString("Driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("InitialPoolSize"));
		System.out.println(rb.getString("AcquireIncrement"));
		System.out.println(rb.getString("MaxPoolSize"));
	}

}
