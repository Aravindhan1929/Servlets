package ServeletsClasses;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServelets extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String i=req.getParameter("num1");
		String j=req.getParameter("num2");
		PrintWriter r=res.getWriter();
		try {
			//addingUserDetials(i,j);
//			boolean a=isAlreadyExisting(i,j);
//			req.setAttribute("k", a);
//			if(a) {
//				req.setAttribute("l", "Successfull");
//			}else {
//				req.setAttribute("l", "registerFirst");
//			}
//			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
//			rd.forward(req, res);
			String a=isAlreadyExisting(i,j);
			r.println(a);
		}catch(Exception e) {
			r.println(e);
		}
//		int k=i+j;
//		req.setAttribute("k",k);
//		RequestDispatcher rd=req.getRequestDispatcher("sq");
//		rd.forward(req, res);
	}
	String isAlreadyExisting(String username,String password) throws ClassNotFoundException, SQLException {
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
    	Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/SAMPLE","root","Aravinth1929");
		Statement stmt=con.createStatement();
		String query="select count(username) as counts from testsample where username='"+username+"' && password='"+password+"'";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			if(rs.getInt("counts")>=1) {
				return "Successfully Registered "+username;
			}
			else {
				return "Register First";
			}
		}
		return "Register First";
	}
	
	
}
