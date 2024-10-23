package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyDatabase {

	public static void main(String[] args) throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium","root","root");
		Statement statement=connection.createStatement();
		
		int result=statement.executeUpdate("insert into student(sid,sname,phno,cource)values(104,\"jkl\",\"7094975429\",\"API\")");
				System.out.println(result);
		connection.close();
	}

}
