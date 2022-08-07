package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewAllEmployee 
{
	void selectAllDatabase(Connection con) throws SQLException 
	{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employeeInfo");
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String n = rs.getString(2);
			String c = rs.getString(3);
			
			System.out.print(" "+id);
			System.out.print(" "+n);
			System.out.print(" "+c);
			
			System.out.println();
		}
		
		rs.close();
		st.close();
		con.close();
	}
}