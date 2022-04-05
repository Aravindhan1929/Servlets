package ServeletsClasses;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class test1 extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String i=req.getParameter("num1");
		String j=req.getParameter("num2");
		PrintWriter r=res.getWriter();
		r.println(i+j);
	}
}
