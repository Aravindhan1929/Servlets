package ServeletsClasses;
import java.sql.*;
public class test {

	public static void main(String[] args) throws SQLException {
		String username="aravinth1929";
		String password="Kalpana@1929";
		Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/SAMPLE","root","Aravinth1929");
		Statement stmt=con.createStatement();
		String query="select count(username) as counts from testsample where username='"+username+"' && password='"+password+"'";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()) {
			for(int i=1;i<=1;i++) {
				//System.out.print(rs.getInt("Counts"));
			if(rs.getInt("counts")>=1) {
				System.out.println("logged in");			
				}
			else {
				System.out.println(rs.getInt(i));
				System.out.println("Register First");
			}
			}
		}
	}
}
