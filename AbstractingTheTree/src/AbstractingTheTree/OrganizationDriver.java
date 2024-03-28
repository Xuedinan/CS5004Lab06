package AbstractingTheTree;

import java.util.List;

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */

/*
This is your starting point and your testing file. 
Except for task 3 the code should work without modifications once you have everything else implemented.
*/


class OrganizationDriver
{
	public static void main(String [] args)
	{
		//Create some employees to play with
		NonManagerEmployee m1 = new NonManagerEmployee("Bob the undfeated", 300.00, Gender.Male);
		NonManagerEmployee m2 = new NonManagerEmployee("Gorg the smelly", 350.00, Gender.Female);
		NonManagerEmployee m3 = new NonManagerEmployee("Nix the ugly", 50.00, Gender.Male);
		NonManagerEmployee m4 = new NonManagerEmployee("Fredick the killer", 550.00, Gender.Male);
		NonManagerEmployee m5 = new NonManagerEmployee("Sue", 1000.00, Gender.Female);
		NonManagerEmployee m6 = new NonManagerEmployee("Hydra the sneaky", 350.00, Gender.Male);
		NonManagerEmployee m7 = new NonManagerEmployee("Gin the drunk", 300.00, Gender.Male);
		NonManagerEmployee m8 = new NonManagerEmployee("Lin the determined", 350.00, Gender.Female);
		ContractEmployee m9 = new ContractEmployee("Blarg the big", 300.00, Gender.Female,31,10,2020);
		
		//Generate the organization
		OrganizationImpl MonsterCorp = new OrganizationImpl("Ug the Terrible", 300000.00,Gender.UnDisclosed);
		
		
		//Create a hierarchy and test
		MonsterCorp.addEmployee(m2, "Ug the Terrible");
		MonsterCorp.addEmployee(m3,m1.getName());
		MonsterCorp.addEmployee(m4,m2.getName());
		MonsterCorp.addEmployee(m5,m2.getName());
		MonsterCorp.addEmployee(m6,m4.getName());
		MonsterCorp.addEmployee(m7,m4.getName());
		MonsterCorp.addEmployee(m8,m5.getName());
		MonsterCorp.addEmployee(m9,m5.getName());
		
		//This was part of the sample code provided my the module
		System.out.println("--- Get total employee number ---");
		System.out.println(MonsterCorp.getTotal());

		//Task 1: 
		//This you'll have to add. We did it as part of the demo code, but you'll have to modify it to make it work with the new structure
		//Print all the employees along with all their information
		System.out.println("\n--- Get each employee information ---\n");
		MonsterCorp.printEmployees();
		
		//Task 2: 
		//This too is something we did in the demo code, but you'll have to modify it to work here.
		//The syntax on this is a bit challenging, but if you study the getSizeByGender you should be able to figure it out
		//Remember, don't try to guess. Try and understand the existing code and then see how you can change it
		//This code segment should return a single int value: the number of employees who make 350.00 annually
		System.out.println("\n--- Get employee number that salary is 300 ---\n");
		System.out.println(MonsterCorp.getSize(m->m.getAnnualPay()==300.00));
		
		//Task 3: 
		//Print out a list of just employee names using allEmployees()
		//This is not a hard task. Just make sure you understand what all Employees returns
		//This function should return a string of all employee names that you can then print as output
		System.out.println("\n--- Get employee name only ---\n");
		List<String> nameList = MonsterCorp.allEmployees();
		nameList.forEach(s -> System.out.println(s));
		
		//Extra Task
		//Because we aren't implementing a filter, I'm removing this, but I invite you to find a workaround
		System.out.println("\n--- Get employee who dosen't have 'the' in their name ---\n");
		System.out.println(MonsterCorp.allEmployees(m->!(m.getName().contains("the"))));
		
		//Extension
		// get employee names that has salary within 300 and 600
		System.out.println("\n--- Get employee names that with salary between 300 and 600 ---\n");
		System.out.println(MonsterCorp.getCertainPayEmployee(m->m.getAnnualPay() > 300.00 && m.getAnnualPay() < 600));
		
		//Extension
		// get percentage of given gender
		System.out.println("\n--- Get percentage of Male employee out of all employees ---\n");
		System.out.println(MonsterCorp.genderPercent(Gender.Male) + "%");
		
	}
	
}