package sql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Did not find class: " + e.getMessage());
		}

		insertNewEmployeeV2(11, "First1", "Last1");
		insertNewEmployeeV2(12, "First2", "Last2");
		insertNewEmployeeV2(13, "First3", "Last3");

	}

	private static void insertNewEmployeeV2(int id, String firstName, String lastName) {

		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC",
					"root", "1234");
			// the Strings have to have ' ' surrounding them.
			/*
			 * PreparedStatement stmt = con.
			 * prepareStatement("insert into employees(id, first_name, last_name) values(" +
			 * id + ", '" + firstName + "', '" + lastName + "') ");
			 */
			// The efficient way to the above:
			PreparedStatement stmt = con
					.prepareStatement("insert into employees(id, first_name, last_name) values(?, ?, ?) ");
			// this syntax allows to insert the values with .set methods:
			stmt.setInt(1, id); // index in this syntax starts from 1 rather than 0.
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);

			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
