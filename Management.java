/*
 * Student Name: Khwaja Yousuf Mohiyuddeen
 * Student Number: 041-079-310
 * Assignment 2
 * Section: 302
 */

import java.util.Scanner;

abstract class Management implements Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private double yearlySalary;
    private String teamName;

    // Constructor for Management class
    public Management(int employeeID, String firstName, String lastName, String email, double yearlySalary, String teamName) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearlySalary = yearlySalary;
        this.teamName = teamName;
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

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // toString() method to display employee details
    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                " | Name: " + firstName + " " + lastName +
                " | Email: " + email +
                " | Yearly Salary: " + yearlySalary +
                " | Team: " + teamName;
    }

    // addEmployee() method to input data for Management
    @Override
    public void addEmployee(Scanner scanner) {
        System.out.println("Enter employee ID:");
        if (scanner.hasNextInt()) {
            employeeID = scanner.nextInt();
        }
        scanner.nextLine(); 

        System.out.println("Enter first name:");
        firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        lastName = scanner.nextLine();

        System.out.println("Enter email:");
        email = scanner.nextLine();

        System.out.println("Enter yearly salary:");
        if (scanner.hasNextDouble()) {
            yearlySalary = scanner.nextDouble();
        }
        scanner.nextLine(); // Consume newline

        System.out.println("Enter team name:");
        teamName = scanner.nextLine();
    }

	public void setRank(String string) {
		
	}
}
