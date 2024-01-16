package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUser {
	
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
		testSearch();
		//testFindById();
		//testAuthenticate();
	}

	private static void testAuthenticate() throws Exception {
		
		UserModel model = new UserModel();
		
	    UserBean bean =	model.authenticate("dilip123@gmail.com", "1234");
	    
	    if (bean != null) {
	    	
	    	System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirstname());
			System.out.print("\t"+bean.getLastname());
			System.out.print("\t"+bean.getLoginid());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
			
		}
		
	}

	private static void testFindById() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean bean = model.findById(1);
       
		if (bean != null) {
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirstname());
			System.out.print("\t"+bean.getLastname());
			System.out.print("\t"+bean.getLoginid());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
		
	}

	private static void testSearch() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();
		//bean.setFirstname("d");
		bean.setDob(sdf.parse("12/01/2024"));
		
		UserModel model = new UserModel();
		
		List list =  model.search(bean,1,5);
		 
		 Iterator it = list.iterator();
		 
		 while (it.hasNext()) {
			
			 bean = (UserBean) it.next();
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirstname());
			System.out.print("\t"+bean.getLastname());
			System.out.print("\t"+bean.getLoginid());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
		
	}

	private static void testDelete() throws Exception {
		
		UserModel model = new UserModel();
		model.delete(1);
		
	}

	private static void testUpdate() throws Exception {
		
		UserBean bean  = new UserBean();
		
		bean.setId(1);
		bean.setFirstname("ram");
		bean.setLastname("sharma");
		bean.setLoginid("ram123@gamil.com");
		bean.setPassword("12345");
		bean.setDob(new Date());
		bean.setAddress("ujjain");
		
		UserModel model = new UserModel();
		model.update(bean);
	}

	private static void testAdd() throws Exception {
		
		UserBean bean  = new UserBean();
		
		bean.setId(4);
		bean.setFirstname("bharat");
		bean.setLastname("malav");
		bean.setLoginid("bharat123@gmail.com");
		bean.setPassword("1236");
		bean.setDob(new Date());
		bean.setAddress("kota");
		
		UserModel model = new UserModel();
		model.add(bean);
		
	}
	
	

}
