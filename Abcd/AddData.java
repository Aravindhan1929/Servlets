package ServeletsClasses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class AddData
 */
public class AddData extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String i=req.getParameter("num1");
		String j=req.getParameter("num2");
		PrintWriter r=res.getWriter();
		try {
			String a=addingUserDetials(i,j);
			r.println(a);
		}catch(Exception e) {
			r.println(e);
		}
		
	}
	String addingUserDetials(String username,String password) throws SQLException, ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
    	Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/SAMPLE","root","Aravinth1929");
		Statement stmt=con.createStatement();
		String query="INSERT INTO TESTSAMPLE(USERNAME,PASSWORD) VALUES ('"+username+"','"+password+"')";
		stmt.executeUpdate(query);
		return "Success Fully Registered";
		
    }

	

}
