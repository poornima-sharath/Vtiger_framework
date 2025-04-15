package Test_NG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.Base_Class;

public class SampleTest extends Base_Class{
	
	@Test
	public void contentCreated() {
		System.out.println("content Created");
	}
	
	@Test
	public void contentModified() {
		System.out.println("content modified");
	}
	
	@Test
	public void contentdeleted() {
		System.out.println("content deleted");
	}

}
