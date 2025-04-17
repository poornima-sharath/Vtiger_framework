package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
//hello im pulling
public class FetchdatafromDataBase {
	
	public static void main(String[] args) throws Throwable {
		/* Creates an object of driver in sql */
		Driver driverRef = new Driver();
		/* Register the driver in driver manager */
		DriverManager.registerDriver(driverRef);
		/* Connecting tool with sql */
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_Details", "root", "root");
		/* get query from database */
		Statement state = conn.createStatement();
		String query = ("select * from employee");
		/* execute query */
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getInt(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4));
		}
		/* Connection is closed */
		conn.close();
		
	}

}
