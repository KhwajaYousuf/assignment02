/*
 * Student Name: Khwaja Yousuf Mohiyuddeen
 * Student Number: 041-079-310
 * Assignment 2
 * Section: 302
 */

import java.util.Scanner;

public class Assignment02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeList employeeList = new EmployeeList(); // Initialize the EmployeeList object

        boolean quit = false;
        while (!quit) {
            System.out.println("======= Welcome to the Employee Management System =======");
            System.out.println("a: Add a new employee (Management/Development)");
            System.out.println("u: Update email address of an employee");
            System.out.println("d: Display the employees supervised by a Team Manager");
            System.out.println("p: Print the info of all employees");
            System.out.println("m: Run Monthly payroll");
            System.out.println("s: Search an employee");
            System.out.println("q: Quit");
            System.out.println("Enter your option: ");

            String option = scanner.nextLine();
            switch (option.toLowerCase()) {
                case "a":
                    employeeList.addEmployee(scanner);
                    break;
                case "u":
                	System.out.println("Enter the employee ID:");
                    int employeeIDToUpdate = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Enter the new email address:");
                    String newEmail = scanner.nextLine();

                    // Call the method in EmployeeList to update the email
                    employeeList.updateEmail(employeeIDToUpdate, newEmail);
                    break;                    
                case "d":
                    System.out.println("Enter the manager's ID to display their supervised employees:");
                    int managerID = scanner.nextInt();
                    scanner.nextLine(); 

                    // Call the method in EmployeeList to display employees supervised by a manager
                    employeeList.displayEmployeesByManager(managerID);
                    break;

                case "p":
                    employeeList.printEmployeeDetails();
                    break;
                    
                case "m":
                    employeeList.calculateAndDisplayPayroll();
                    break;

                case "s":
                    System.out.println("Enter search term (name or ID):");
                    String searchTerm = scanner.nextLine();
                    employeeList.searchEmployee(searchTerm);
                    break;

                case "r":
                    System.out.println("Enter employee IDs (comma-separated) to remove:");
                    String input = scanner.nextLine();
                    String[] ids = input.split(",");
                    int[] employeeIDs = new int[ids.length];
                    for (int i = 0; i < ids.length; i++) {
                        employeeIDs[i] = Integer.parseInt(ids[i].trim());
                    }
				boolean isManager = false;
				employeeList.removeEmployee(employeeIDs, isManager); // Assuming 'isManager' determines authorization
                    break;

                case "e":
				Object currentUser = null;
				if (isManager(currentUser)) {
                        System.out.println("Enter the employee ID to promote:");
                        int employeeIDToPromote = Integer.parseInt(scanner.nextLine());
                        employeeList.promoteEmployee(employeeIDToPromote, isManager(currentUser));
                    } else {
                        System.out.println("You do not have permission to perform this action.");
                    }
                    break;

                case "q":
                    quit = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
                    break;
            }
        }
        scanner.close();
    }

	private static boolean isManager(Object currentUser) {
		return false;
	}
}
