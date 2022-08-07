package employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewEmployee 
{
	void selectDatabase(Connection con) throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the emoloyee id");
		int id = sc.nextInt();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employeeInfo where id = "+id);
		
		while(rs.next())
		{
			int i = rs.getInt(1);
			String n = rs.getString(2);
			String c = rs.getString(3);
			
			System.out.print(" "+i);
			System.out.print(" "+n);
			System.out.print(" "+c);
			
			System.out.println();
		}
		
		rs.close();
		st.close();
		con.close();
	}
}