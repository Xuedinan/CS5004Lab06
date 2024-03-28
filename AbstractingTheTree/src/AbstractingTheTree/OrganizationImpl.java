package AbstractingTheTree;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */

/*
This class has to be redesigned to use the generic tree node system instead of the former system. 
I've included a backup of this file in case it is useful to you. 
You'll need to populate the body based on the module and add the requested additional functionality.
*/

public class OrganizationImpl implements Organization {
	 private Employee root;

	  public OrganizationImpl(String nameCEO, double pay, Gender gender) {
	    root = new InternalEmployee(nameCEO,pay,gender);
	  }

	  @Override
	  public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
	    Employee newEmployee = new NonManagerEmployee(name,pay,gender);
	    root = root.addSupervisee(supervisorName,newEmployee);
	  }

	  @Override
	  public void addContractEmployee(String name, double pay, Gender gender, int
	          endDate, int endMonth, int endYear, String supervisorName) {
	    Employee newEmployee = new ContractEmployee(name,pay,gender,endDate,endMonth,
	            endYear);
	    root = root.addSupervisee(supervisorName,newEmployee);
	  }

	  @Override
	  public int getTotal(){
	    return root.count(b -> true);
	  }
	  
	  public int getSize(Predicate<Employee> condition){
	    return root.count(condition);
	  }
	  
	  @Override
	  public int getSizeByGender(Gender gender) {
	    return root.count(b -> b.getGender() == gender);
	  }

	  @Override
	  public List<String> allEmployees() {
	    return root.toList().stream().map(e->e.getName()).collect(Collectors
	            .toList());
	  }

	  @Override
	  public int countPayAbove(double amount) {
	    return root.count(b -> b.getAnnualPay() > amount);
	  }

	  @Override
	  public int terminatedBefore(int date,int month,int year) {
	    LocalDate threshold;

	    try {
	      threshold = LocalDate.of(year,month,date);
	    }
	    catch (DateTimeException e) {
	      return 0;
	    }
	    return root.count(b->{
	      if (b.getEmploymentEndDate().equals("XXXXXXXX"))
	        return false;
	      else {
	        LocalDate d = LocalDate.parse(b.getEmploymentEndDate(),
	                DateTimeFormatter.ofPattern("MMddyyyy"));
	        return d.compareTo(threshold)<0;
	      }
	    });
	  }

	@Override
  	public List<String> allEmployees(Predicate<Employee> predicate) {
       return root.toList(predicate).stream().map(Employee::getName).collect(Collectors.toList());
	}

	public void addEmployee(NonManagerEmployee m2, String string) {
		Employee newEmployee = new NonManagerEmployee(m2.name,m2.pay,m2.gender);
	    root = root.addSupervisee(string,newEmployee);
		
	}
	
	public void printEmployees() {
		List<Employee> list = root.toList();
		list.forEach(s -> System.out.println(s.toString()));
	}
	
	public List<String> getCertainPayEmployee(Predicate<Employee> condition){
		return root.toList(condition).stream().map(Employee::getName).collect(Collectors.toList());
	}

	@Override
	public double genderPercent(Gender gender) {    
		// get number of given gender
	    long genderCount = root.count(b -> b.getGender() == gender);
	    // get total employee number
	    long totalCount = root.count(b -> true);
	    // calculate percentage
	    return (double) genderCount / totalCount * 100.0;
	}
}
