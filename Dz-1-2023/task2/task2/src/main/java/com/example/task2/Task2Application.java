package com.example.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;


public class Task2Application {

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String mysqlURL = "jdbc:mysql://localhost/tests";
		Connection connection = DriverManager.getConnection(mysqlURL, "root", "123456789");

		Statement statement = connection.createStatement();
		String query = "SELECT * FROM user WHERE role <> 'student'";
		statement.executeUpdate(query);

		ResultSet result_after_all = statement.executeQuery("SHOW TABLES;");
		while (result_after_all.next()) {
			System.out.print(result_after_all.getString(1));
			System.out.println();
		}

		Statement statement2 = connection.createStatement();
		String query2 = "SELECT * FROM user WHERE role = 2";
		statement.executeUpdate(query2);

		ResultSet result_after_all = statement2.executeQuery("SHOW TABLES;");
		while (result_after_all.next()) {
			System.out.print(result_after_all.getString(1));
			System.out.println();
		}

		Statement statement3 = connection.createStatement();
		String query3 = "SELECT test_id FROM student_answer WHERE user_id = 6";
		statement.executeUpdate(query3);

		ResultSet result_after_all = statement3.executeQuery("SHOW TABLES;");
		while (result_after_all.next()) {
			System.out.print(result_after_all.getString(1));
			System.out.println();
		}

		Statement statement4 = connection.createStatement();
		String query4 = "SELECT score, row_id FROM question INNER JOIN user ON question.row_id = user.row_id";
		statement.executeUpdate(query4);

		ResultSet result_after_all = statement4.executeQuery("SHOW TABLES;");
		while (result_after_all.next()) {
			System.out.print(result_after_all.getString(1));
			System.out.println();
		}
	}
}
