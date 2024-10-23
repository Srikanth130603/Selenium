package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRowFromDatabase {

	public static void main(String[] args) throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium","root","root");
		Statement statement=connection.createStatement();
		
		int result=statement.executeUpdate("delete from student where sid=104;");
				System.out.println(result);
		connection.close();
	}

}
