package AbstractingTheTree;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */

/**
 * This class represents an employee who works on a term-limited contract
 * with the organization. Contract employees cannot manage
 * other employees within this organization.
 */
public class ContractEmployee extends NonManagerEmployee {
  private LocalDate contractEndDate;

  public ContractEmployee(String name, double pay, Gender gender, int date, int
   month, int year) throws IllegalArgumentException{
    super(name, pay, gender);
    //validate our date
    try {
      contractEndDate = LocalDate.of(year, month, date);
    }
    catch (DateTimeException e) {
      throw new IllegalArgumentException("Invalid contract end date");
    }
  }

  @Override
  public String getEmploymentEndDate() {
    return DateTimeFormatter.ofPattern("MMddyyyy").format(contractEndDate);
  }
  
  public void printEmployees()
  {
	  System.out.print("CONTRACTOR ");
	  super.printEmployees();
	  
  }
}