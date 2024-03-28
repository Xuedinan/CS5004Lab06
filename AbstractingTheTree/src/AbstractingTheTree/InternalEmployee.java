package AbstractingTheTree;

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */

/**
 * This class represents an internal employee who has no managerial
 * responsibilities.
 */
public class InternalEmployee extends NonManagerEmployee {
  public InternalEmployee(String name, double pay, Gender gender) {
    super(name, pay, gender);
  }
}