package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WritingDataintoDataBase {
	
	public static void main(String[] args) throws Throwable {
		
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_Details", "root", "root");
		
		Statement state = conn.createStatement();
		String query = "insert into employee values('3','abhinandan','sachidanada','kolkata')";
		String query1 = "insert into employee values('4','poo','s','banglore')";
		String query2= "insert into employee values('5','sharath','m','mysore')";
		
		int result = state.executeUpdate(query);
		int result1 =  state.executeUpdate(query1);
		int result2 =  state.executeUpdate(query2);
		
		
		if(result ==1 && result1==2 && result2==3) {
			System.out.println("Data is added");
		}else {
			System.out.println("Data is not added");
		}
		
		conn.close();
	}

}
