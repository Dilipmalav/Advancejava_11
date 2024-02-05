package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class  UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("UserRegistrationView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("in post method...!!!");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-DD-mm");
		
		   String fname = req.getParameter("firstName");
		   String lname = req.getParameter("lastName");
		   String login = req.getParameter("Loginid");
		   String pass = req.getParameter("Password");
		   String dob = req.getParameter("Dob");
		   String addr = req.getParameter("Address");
		   
		   System.out.println(fname);
		   System.out.println(lname);
		   System.out.println(login);
		   System.out.println(pass);
		   System.out.println(dob);
		   System.out.println(addr);
		   
		   UserBean bean = new UserBean();
		   
		   bean.setFirstname(fname);
		   bean.setLastname(lname);
		   bean.setLoginid(login);
		   bean.setPassword(pass);
		   try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		   bean.setAddress(addr);
		   
		   UserModel model = new UserModel();
		   try {
			model.add(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   resp.sendRedirect("UserRegistrationView.jsp");
	}
}
