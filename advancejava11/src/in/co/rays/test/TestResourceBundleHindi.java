package in.co.rays.test;

import java.util.ResourceBundle;

public class TestResourceBundleHindi {

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");
		
		System.out.println(rb.getString("greet"));
	}
}
