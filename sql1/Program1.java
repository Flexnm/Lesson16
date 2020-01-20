package sql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// import com.mysql.cj.jdbc.Driver; can also be imported.

public class Program1 {
	public static void main(String[] args) {

		// load the mysql Driver to memory.
		// java doesnt know the Driver yet.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // static method forName() is used to load the sql driver.
			// com.mysql.cj.jbdc.Driver is the john bryce mysql driver.
		} catch (ClassNotFoundException e) {
			// the method throws an exception.
			System.out.println("Did not find class: " + e.getMessage());
		}

		insertNewEmployee();

	}

	private static void insertNewEmployee() {
		// adds a new employee to Northwind (the database).

		// 1) open a connection to the database.
		try {
			// This is the john bryce connection to the northwind example database.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC",
					"root", "1234");
			// DriverManager.getConnection(connectionPath, userName, Password);

			// 2) create an SQL command.
			// the command statement text needs to be written in similar syntax as in the
			// mysql workbench.
			PreparedStatement stmt = con.prepareStatement(
					"insert into employees(id, first_name, last_name) values(10, 'Donald', 'Trump') ");
			
			// 3) Execute command.
			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}