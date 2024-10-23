package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This classs contains reusable methods to read/write data in database
 * @author sncnr
 */
public class DatabaseUtilites {
	Connection connection;
	Statement statement;
	/**
	 * This method initializers database
	 * @param url
	 * @param user
	 * @param pwd
	 */
	public void databaseInit(String url,String user,String pwd)
	{
		try {
			connection = DriverManager.getConnection(url,user,pwd);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try {
			statement=connection.createStatement();
		}
		catch(SQLException e2)
		{
			e2.printStackTrace();
		}
	}
	/**
	 * This method reads data from database column wise
	 * @param Query
	 * @param colname
	 * @return List<Object>
	 */
	public List<Object> readFromDatabse(String query,String colname)
	{
		ResultSet result=null;
		try {
			result=statement.executeQuery(query);
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		List<Object> list= new ArrayList<Object>();
		try {
			while(result.next())
			{
				list.add(result.getObject(colname));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * This method is used to madify database
	 * @param query
	 * @return int
	 */
	public int modifyDatabase(String query)
	{
		int result=0;
		try {
			result= statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method closes database connection
	 */
	public void closedatabase()
	{
		try {
			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
