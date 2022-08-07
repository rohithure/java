package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteEmployee {
	void deleteDatabase(Connection con) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id");
		int id = sc.nextInt();

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employeeInfo where id = " + id);

		if (rs.next()) {
			PreparedStatement p = con.prepareStatement("delete from employeeInfo where id = ?");
			p.setInt(1, id);

			int x = p.executeUpdate();
		}

		else {
//			EmployeeNotFoundException e = new EmployeeNotFoundException();
//			throw e;

			System.out.println("Employee not in records");

		}

		rs.close();
		st.close();
		con.close();
		sc.close();
	}
}