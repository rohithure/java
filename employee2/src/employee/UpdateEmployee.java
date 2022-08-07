package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateEmployee {
	void updateDatabase(Connection c) throws SQLException, InterruptedException {

		
		PreparedStatement p = c.prepareStatement("update employeeInfo set name = ?, city = ? where id = ?");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int i = sc.nextInt();

		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from employeeInfo where id = " + i);

		if (!r.next()) {
//			EmployeeNotFoundException e = new EmployeeNotFoundException();
//			throw e;
			
			System.out.println("Employee not in records");   
		}

		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter name");
		String n = sc1.next();

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter city");
		String city = sc2.next();

		p.setInt(3, i);
		p.setString(1, n);
		p.setString(2, city);
		
		int x = p.executeUpdate();
		

		s.close();
		p.close();
		c.close();

	}
}
