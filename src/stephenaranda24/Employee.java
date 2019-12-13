package stephenaranda24;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Employee {


  String name;
  String username;
  String password;
  String email;

  Employee(String name, String password) {
    this.name = name;

    if (checkName(name)) {
      String[] fullName = name.split(" ");

      String firstAndLastName = fullName[0].substring(0, 1) + toCapital(fullName[1]);
      String firstNameDotLastName = fullName[0].toLowerCase() + "." + fullName[1].toLowerCase();
      setUsername(
          firstAndLastName);
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

  private void setUsername(String name) {
    this.username = name;
  }

  public String getUsername() {
    return this.username.toString();
  }

  private boolean checkName(String name) {
    //Uses regex to check the users input to see if it passes
    String regex = ".+ .+";
    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }


  private void setEmail(String name) {
    this.email = name + "@oracleacademy.Test";
  }

  public String getEmail() {
    return this.email;
  }

  private boolean isValidPassword(String password) {
    String regex = "^(?=.*[!@#$%^&*()\\-+=]+.*)(?=.*[A-Z]+.*)(?=.*[a-z]+.*)[\\x21-\\x7e]{3,}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    boolean found = matcher.find();
    return found;
  }

  private String toCapital(String word) {
    word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    return word;
  }


  public String toString() {
    return "Employee Details : " + "\n " + "Name : " + name + "\n" + "Username : " + username
        .toLowerCase() + "\n" + "Email : " + email + "\n" + "Initial Password : " + password;
  }
}
