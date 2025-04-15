package Test_NG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardCodingAssertEx {
	
	@Test
	
	public void m1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("A", "B");
		System.out.println("Step3");
		System.out.println("Step4");
	}

	@Test
	public void m2() {
		int exp = 10;
		int act = 20;
		Assert.assertEquals(exp, act);
	}
	@Test
	public void m3() {
		int exp = 10;
		int act = 10;
		Assert.assertEquals(exp, act,"Assert are not equal");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m4() {
		String exp ="Qspiders";
		String act = "Qspider";
		Assert.assertNotEquals(exp, act,"Both are not equal");
		System.out.println("Both are equal");
	}
	
	@Test
	public void m5() {
		String exp ="Qspiders";
		String act = "Qspider";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "Both are not equal");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m6() {
		String exp ="Qspiders";
		String act = "Qspiders";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "Both are not equal");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m7() {
		String exp ="Qspiders";
		String act = "Qspiders";
		Assert.assertFalse(act.equalsIgnoreCase(exp), "Both are not equal");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m8() {
		String exp ="Qspiders";
		String act = "Qspiders ";
		Assert.assertFalse(act.equalsIgnoreCase(exp), "Both are not equal");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m9() {
		String s = null;
		Assert.assertNull(s, "String is not null");
		System.out.println("String is null");
	}
	
	@Test
	public void m10() {
		String s = "Qspiders";
		Assert.assertNull(s, "String is not null");
		System.out.println("String is null");
	}
	
	@Test
	public void m11() {
		String s = "Qspiders";
		Assert.assertNotNull(s, "String is null");
		System.out.println("String is null");
	}
	
	@Test
	public void m12() {
		String s = null;
		Assert.assertNotNull(s, "String is null");
		System.out.println("String is not null");
	}
	
	@Test
	public void m13() {
		String exp = "Hello";
		String act = "Hello";
		Assert.assertSame(act, exp, "Values are not same");
		System.out.println("Values are same");
	}
	
	@Test
	public void m14() {
		String exp = "Hello";
		String act = "Hi";
		Assert.assertSame(act, exp, "Values are same");
		System.out.println("Values are not same");
	}
	
	@Test
	public void m15() {
		String exp = "Hello";
		String act = "Hello";
		Assert.assertNotSame(act, exp, "Values are same");
		System.out.println("Values are not same");
	}
	
	@Test
	public void m16() {
		String exp = "Hello";
		String act = "hi";
		Assert.assertNotSame(act, exp, "Values are same");
		System.out.println("Values are not same");
	}
	
	@Test
	public void m17() {
		Assert.fail("I am failing this method");
	}
}
