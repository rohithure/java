package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMain {
	public static void main(String[] args) throws SQLException, InterruptedException {

		System.out.println("Welcome to employee management portal using MYSQL");

		Scanner sc = new Scanner(System.in);
		System.out.println("1 : Add Employee");
		System.out.println("2 : View Employee");
		System.out.println("3 : Delete Employee");
		System.out.println("4 : Update Employee");
		System.out.println("5 : View All Employee");
		System.out.println("6 : Exit");

		System.out.println("\nEnter your choice");
		int ch = sc.nextInt();

		Connection c = DriverManager.getConnection("jdbc:mysql:///employee", "root", "shashi@1996");

		switch (ch) {

		case 1:
			AddEmployee i = new AddEmployee();
			i.insertDatabase(c);
			break;

		case 2:
			ViewEmployee s1 = new ViewEmployee();
			s1.selectDatabase(c);
			break;

		case 3:
			DeleteEmployee d = new DeleteEmployee();
			d.deleteDatabase(c);
			break;

		case 4:
			UpdateEmployee u = new UpdateEmployee();
			u.updateDatabase(c);
			break;

		case 5:
			ViewAllEmployee s = new ViewAllEmployee();
			s.selectAllDatabase(c);
			break;

		case 6:
			System.exit(0);

		default:
//			InputMismatchException i1 = new InputMismatchException("Wrong input");
//			throw i1;
			System.out.println("Invalid selection");
			break;
		}

		sc.close();

	}
}
