package sql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassEx1 {
	public static void main(String[] args) {

		// insert a new product into products table
		// id, product_name, list_price, description

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Did not find class: " + e.getMessage());
		}

		insertProduct(100, "Northwind Traders Game", 10.5, "This is a game!");

	}

	private static void insertProduct(int id, String productName, double listPrice, String description) {

		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC",
					"root", "1234");

			PreparedStatement stmt = con.prepareStatement(
					"insert into products(id, product_name, list_price, description) values(?, ?, ?, ?) ");

			stmt.setInt(1, id);
			stmt.setString(2, productName);
			stmt.setDouble(3, listPrice);
			stmt.setString(4, description);

			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
