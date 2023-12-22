/*
 * Student Name: Khwaja Yousuf Mohiyuddeen
 * Student Number: 041-079-310
 * Assignment 2
 * Section: 302
 */
import java.util.Scanner;

class ITAnalyst extends Development {
    private String areaOfAnalysis;

    // Constructor for ITAnalyst class
    public ITAnalyst(int employeeID, String firstName, String lastName, String email, int supervisorID, double yearlySalary, String areaOfAnalysis) {
        super(employeeID, firstName, lastName, email, supervisorID, yearlySalary);
        this.areaOfAnalysis = areaOfAnalysis;	
    }

    public String getAreaOfAnalysis() {
        return areaOfAnalysis;
    }

    public void setAreaOfAnalysis(String areaOfAnalysis) {
        this.areaOfAnalysis = areaOfAnalysis;
    }

    // Override toString() method to include 'areaOfAnalysis'
    @Override
    public String toString() {
        return super.toString() + " | Area of Analysis: " + areaOfAnalysis;
    }

    // Override addEmployee() method to input ITAnalyst specific data
    @Override
    public void addEmployee(Scanner scanner) {
        super.addEmployee(scanner); // Call superclass method to input common data
        
        System.out.println("Enter area of analysis:");
        areaOfAnalysis = scanner.nextLine();
    }

	@Override
	protected String getTeamName() {
		return null;
	}

	
	}

