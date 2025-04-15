package Test_NG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderex1 {

	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int traveller) {
		
		System.out.println("Book tickets from " +src+" to "+dest +" and travellers are "+traveller);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objarry = new Object[3][3];
		
		objarry[0][0] = "Banglore";
		objarry[0][1] ="Mysore";
		objarry[0][2] = 20;
		
		objarry[1][0] ="Banglore";
		objarry[1][1] ="Goa";
		objarry[1][2] = 30;
		
		objarry[2][0] ="Banglore";
		objarry[2][1] ="Hyd";
		objarry[2][2] = 50;
		
		return objarry;
		}
}
