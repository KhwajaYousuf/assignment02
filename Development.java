/*
 * Student Name: Khwaja Yousuf Mohiyuddeen
 * Student Number: 041-079-310
 * Assignment 2
 * Section: 302
 */
import java.util.Scanner;

abstract class Development implements Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private int supervisorID;
    private double yearlySalary;

    // Constructor for Development class
    public Development(int employeeID, String firstName, String lastName, String email, int supervisorID, double yearlySalary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.supervisorID = supervisorID;
        this.yearlySalary = yearlySalary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(int supervisorID) {
        this.supervisorID = supervisorID;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    // toString() method to display employee details
    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                " | Name: " + firstName + " " + lastName +
                " | Email: " + email +
                " | Supervisor ID: " + supervisorID +
                " | Yearly Salary: " + yearlySalary;
    }

    // addEmployee() method to input data for Development
    @Override
    public void addEmployee(Scanner scanner) {
        System.out.println("Enter employee ID:");
        employeeID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter first name:");
        firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        lastName = scanner.nextLine();

        System.out.println("Enter email:");
        email = scanner.nextLine();

        System.out.println("Enter supervisor ID:");
        supervisorID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter yearly salary:");
        yearlySalary = scanner.nextDouble();
        scanner.nextLine();
    }

	protected abstract String getTeamName();
}
