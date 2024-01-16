package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet { 
	public static void main(String[] args) throws Exception {
		
		 testAdd();
		//testUpdate();
		//testDelete();
		//testReadAll();
		//testFindById();
		//testSearch();
	}

	private static void testSearch() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setName("");
		//bean.setRollno(104);
		
		MarksheetModel model = new MarksheetModel();
		
		List  list = model.search(bean,1, 1);
		
		 Iterator it = list.iterator();
		 
		 while (it.hasNext()) {
			 
		     bean = (MarksheetBean) it.next();
			
			 System.out.print("\t"+bean.getId());
			 System.out.print("\t"+bean.getRollno());
			 System.out.print("\t"+bean.getName());
			 System.out.print("\t"+bean.getPhy());
			 System.out.print("\t"+bean.getChe());
			 System.out.println("\t"+bean.getMaths());
			
		}
		
	}

	private static void testFindById() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		 MarksheetBean bean = model.findByPk(15);
		 
		 if (bean != null) {
			 
			 System.out.print("\t"+bean.getId());
			 System.out.print("\t"+bean.getRollno());
			 System.out.print("\t"+bean.getName());
			 System.out.print("\t"+bean.getPhy());
			 System.out.print("\t"+bean.getChe());
			 System.out.println("\t"+bean.getMaths());
		 }else {
			 
			 System.out.println("id not exist:::>");
		 }
		
	}

	private static void testReadAll() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		model.readAll();
		
	}

	private static void testDelete() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		model.delete(2);
		
	}

	private static void testUpdate() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRollno(109);
		bean.setName("mannu");
		bean.setPhy(64);
		bean.setChe(26);
		bean.setMaths(74);
		bean.setId(9);
		
		MarksheetModel model = new MarksheetModel();
		model.update(bean);
		
	}

	private static void testAdd() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
		//bean.setId(9);
		bean.setRollno(109);
		bean.setName("suraj");
		bean.setPhy(78);
		bean.setChe(86);
		bean.setMaths(89);
		
		MarksheetModel model = new MarksheetModel();
		model.add(bean);
		
		
	}

}
