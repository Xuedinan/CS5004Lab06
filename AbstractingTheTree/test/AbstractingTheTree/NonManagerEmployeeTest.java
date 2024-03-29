package AbstractingTheTree;

import static org.junit.Assert.*;

import org.junit.Test;

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */

public class NonManagerEmployeeTest {
	
	// create test objects
	NonManagerEmployee t1 = new NonManagerEmployee("Bob", 300.00, Gender.Male);
	NonManagerEmployee t2 = new NonManagerEmployee("Glory", 350.00, Gender.Female);
	
	// test getters

	@Test
	public void testGetName() {
		assertEquals("Bob", t1.getName());
		assertEquals("Glory", t2.getName());
	}

	@Test
	public void testGetAnnualPay(){
		assertEquals(300.00, t1.getAnnualPay(), 0.01);
		assertEquals(350.00, t2.getAnnualPay(), 0.01);
	}

	@Test
	public void testGetGender()  {
		assertEquals(Gender.Male, t1.getGender());
		assertEquals(Gender.Female, t2.getGender());
	}

}
