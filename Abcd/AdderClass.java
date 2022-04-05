package ServeletsClasses;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class AdderClass extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		int i=(int)req.getAttribute("k");
		PrintWriter r=res.getWriter();
		r.println("The added value is : "+i);
		r.println("The squred value is : "+i*i);
		try {
			addingUserDetials(i);
			r.println("The added value is : "+i);
			r.println("The squred value is : "+i*i);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	void addingUserDetials(int i) throws SQLException, ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
    	Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/SAMPLE","root","Aravinth1929");
		Statement stmt=con.createStatement();
		String query="INSERT INTO TEST(num) VALUES ('"+i+"')";
		stmt.executeUpdate(query);
    }
}
