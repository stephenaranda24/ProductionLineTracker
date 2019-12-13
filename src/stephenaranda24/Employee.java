package stephenaranda24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class contains all the characteristics of an employee, such as their name, username,
 * password, and email credentials. This class makes use of regex to test various cases.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-09-21
 */

public class Employee {

  private final String name;
  private String username;
  private final String password;
  private String email;

  /**
   * A constructor for the employee class that takes in the employee name and password as the
   * arguments.
   *
   * @param name Employees full name as string.
   * @param password Employees password as a string.
   */
  Employee(String name, String password) {
    this.name = name;

    if (checkName(name)) {
      String[] fullName = name.split(" ");

      String firstAndLastName = fullName[0].substring(0, 1) + toCapital(fullName[1]);
      String firstNameDotLastName = fullName[0].toLowerCase() + "." + fullName[1].toLowerCase();
      setUsername(firstAndLastName);
      setEmail(firstNameDotLastName);
    } else {
      setUsername("default");
      setEmail("user");
    }

    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * Mutator/setter method for the employee username. Makes it so that you can change its value.
   *
   * @param name A string value that represents the full name of the employee (first and last name).
   */
  private void setUsername(String name) {
    this.username = name;
  }

  /**
   * Accessor/getter method for the employee username.
   *
   * @return A string value that represents the username.
   */
  public String getUsername() {
    return this.username.toString();
  }

  /**
   * A method that checks to see if the name contains a space.
   *
   * @param name A string value that represents the name that is being checked.
   * @return A boolean value that represents whether it passes or not.
   */
  private boolean checkName(String name) {
    // Uses regex to check the users input to see if it passes
    String regex = ".+ .+";
    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }

  /**
   * Mutator/setter for the employees email.
   *
   * @param name A string value that represents the name of the employee.
   */
  private void setEmail(String name) {
    this.email = name + "@oracleacademy.Test";
  }

  /**
   * Accessor/getter method for the employees email.
   *
   * @return A string value that represents the email of the employee.
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * This method checks to see if the password entered is valid using regex.
   *
   * @param password A string that represents the password of the employee.
   * @return A boolean value that determines whether the password is valid or not.
   */
  private boolean isValidPassword(String password) {
    String regex = "^(?=.*[!@#$%^&*()\\-+=]+.*)(?=.*[A-Z]+.*)(?=.*[a-z]+.*)[\\x21-\\x7e]{3,}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    boolean found = matcher.find();
    return found;
  }

  /**
   * A method that checks the characters of the string taken as the argument.
   *
   * @param word A string value.
   * @return A string value is returned.
   */
  private String toCapital(String word) {
    word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    return word;
  }

  /**
   * String formatting method.
   *
   * @return A string after formatting.
   */
  public String toString() {
    return "Employee Details : "
        + "\n "
        + "Name : "
        + name
        + "\n"
        + "Username : "
        + username.toLowerCase()
        + "\n"
        + "Email : "
        + email
        + "\n"
        + "Initial Password : "
        + password;
  }
}
