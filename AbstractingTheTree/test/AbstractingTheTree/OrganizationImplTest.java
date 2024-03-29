package AbstractingTheTree;

import static org.junit.Assert.*;

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */

import org.junit.Test;

public class OrganizationImplTest {
	
	// create test objects
	NonManagerEmployee t1 = new NonManagerEmployee("Bob", 300.00, Gender.Male);
	NonManagerEmployee t2 = new NonManagerEmployee("Glory", 350.00, Gender.Female);
	NonManagerEmployee t3 = new NonManagerEmployee("Tom", 300.00, Gender.Male);
	NonManagerEmployee t4 = new NonManagerEmployee("Sharon", 350.00, Gender.Female);
	
	//Generate the organization
	OrganizationImpl org = new OrganizationImpl("Test org", 300000.00,Gender.UnDisclosed);

	@Test
	public void testAddEmployeeStringDoubleGenderString() {
		// org has 1 employees at beginning
		assertEquals(1, org.getTotal(), 0.01);

		org.addEmployee(t2, "Test org");
		org.addEmployee(t3,t1.getName());
		org.addEmployee(t4,t2.getName());
		assertEquals(3, org.getTotal(), 0.01);
	}
	
	// test total number
	@Test
	public void testGetTotal() {
		org.addEmployee(t1, t2.getName());
		assertEquals(1, org.getTotal(), 0.01);
	}
	
	// test get size
	@Test
	public void testGetSize() {
		org.addEmployee(t1, t2.getName());
		assertEquals(1, org.getTotal(), 0.01);
	}
	
	//test get size by given gender
	@Test
	public void testGetSizeByGender() {
		org.addEmployee(t1, t2.getName());
		assertEquals(0, org.getSizeByGender(Gender.Male), 0.01);
	}
	
	// test get size by given salary
	@Test
	public void testCountPayAbove() {
		org.addEmployee(t1, t2.getName());
		org.addEmployee(t3, t4.getName());
		assertEquals(1, org.countPayAbove(300), 0.01);
	}
	
	// test percentage calculate for given gender
	@Test
	public void testGenderPercent() {
		org.addEmployee(t1, t2.getName());
		assertEquals(0.0, org.genderPercent(Gender.Male), 0.01);
	}

}
