/*
 * Student Name: Khwaja Yousuf Mohiyuddeen
 * Student Number: 041-079-310
 * Assignment 2
 * Section: 302
 */
import java.util.Scanner;

class Manager extends Management {
    private String rank;

    // Constructor for Manager class
    public Manager(int employeeID, String firstName, String lastName, String email, double yearlySalary, String teamName, String rank) {
        super(employeeID, firstName, lastName, email, yearlySalary, teamName);
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    // Override toString() method to include 'rank'
    @Override	
    public String toString() {
        return super.toString() + " | Rank: " + rank;
    }

    // Override addEmployee() method to input Manager specific data
    @Override
    public void addEmployee(Scanner scanner) {
        super.addEmployee(scanner); // Call superclass method to input common data
        
        System.out.println("Enter manager's rank:");
        rank = scanner.nextLine();
    }
    
    public Manager(Development developer) {
        super(developer.getEmployeeID(), developer.getFirstName(), developer.getLastName(), developer.getEmail(), developer.getYearlySalary(), developer.getTeamName());
        this.rank = "Assistant Manager"; // Default rank for promoted employees
    }

}
