/*
 * Student Name: Khwaja Yousuf Mohiyuddeen
 * Student Number: 041-079-310
 * Assignment 2
 * Section: 302
 */
import java.util.Scanner;

class ITDeveloper extends Development {
    private String programmingPlatform;

    // Constructor for ITDeveloper class
    public ITDeveloper(int employeeID, String firstName, String lastName, String email, int supervisorID, double yearlySalary, String programmingPlatform) {
        super(employeeID, firstName, lastName, email, supervisorID, yearlySalary);
        this.programmingPlatform = programmingPlatform;
    }

    public String getProgrammingPlatform() {
        return programmingPlatform;
    }

    public void setProgrammingPlatform(String programmingPlatform) {
        this.programmingPlatform = programmingPlatform;
    }

    // Override toString() method to include 'programmingPlatform'
    @Override
    public String toString() {
        return super.toString() + " | Programming Platform: " + programmingPlatform;
    }

    // Override addEmployee() method to input ITDeveloper specific data
    @Override
    public void addEmployee(Scanner scanner) {
        super.addEmployee(scanner); // Call superclass method to input common data
        
        System.out.println("Enter programming platform:");
        programmingPlatform = scanner.nextLine();
    }

	@Override
	protected String getTeamName() {
		return null;
	}
}
