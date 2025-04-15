package DDT;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDatainPropertiesFile {
	
	 public static void main(String[] args) throws Throwable {
		 
		Properties p = new Properties();
		p.setProperty("browser", "chrome");
		p.setProperty("url", "http://localhost:8888/");
		
		FileOutputStream file = new FileOutputStream("D:\\Selenium-Workspace\\Vtiger_framework\\data\\Commons.properties.txt");
		p.store(file, "storingdata");
	}
}
