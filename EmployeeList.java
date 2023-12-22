/*
 * Student Name: Khwaja Yousuf Mohiyuddeen
 * Student Number: 041-079-310
 * Assignment 2
 * Section: 302
 */
import java.util.ArrayList;
import java.util.Scanner;

class EmployeeList {
    private ArrayList<Management> managementEmployees;
    private ArrayList<Development> developmentEmployees;

    // Constructor to initialize ArrayLists
    public EmployeeList() {
        managementEmployees = new ArrayList<>();
        developmentEmployees = new ArrayList<>();
    }

    // Method to add an employee to the corresponding ArrayList
    public void addEmployee(Scanner scanner) {
        System.out.println("Please select the type of employee you want to add:");
        System.out.println("Enter 'm' for Manager or 'd' for Development Employee:");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("m")) {
            // Add a Manager
            System.out.println("Enter first name of the manager:");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name of the manager:");
            String lastName = scanner.nextLine();
            System.out.println("Enter the ID of the manager:");
            int employeeID = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Enter the Email of the manager:");
            String email = scanner.nextLine();
            System.out.println("Enter salary of the manager:");
            double yearlySalary = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter the team name of the Manager:");
            String teamName = scanner.nextLine();
            System.out.println("Enter the rank of the Manager:");
            String rank = scanner.nextLine();

            Manager manager = new Manager(employeeID, firstName, lastName, email, yearlySalary, teamName, rank);
            managementEmployees.add(manager);
        } else if (choice.equalsIgnoreCase("d")) {
                // Add an IT Analyst
                System.out.println("Enter first name of the IT Analyst:");
                String firstName = scanner.nextLine();
                System.out.println("Enter last name of the IT Analyst:");
                String lastName = scanner.nextLine();
                System.out.println("Enter the ID of the IT Analyst:");
                int employeeID = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Enter the Email of the IT Analyst:");
                String email = scanner.nextLine();
                System.out.println("Enter salary of the IT Analyst:");
                double yearlySalary = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.println("Enter the supervisor ID of the IT Analyst:");
                int supervisorID = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Enter the area of analysis:");
                String areaOfAnalysis = scanner.nextLine();

                // Create an ITAnalyst object and add it to the developmentEmployees list
                ITAnalyst itAnalyst = new ITAnalyst(employeeID, firstName, lastName, email, supervisorID, yearlySalary, areaOfAnalysis);
                developmentEmployees.add(itAnalyst);
            } else {
                System.out.println("Invalid choice for Development Employee type.");
            }
    }
    

    // Method to print details of all employees
    public void printEmployeeDetails() {
        System.out.println("Employee Management System");
        System.out.println("*******************");
        System.out.println("Number of Employees: " + (managementEmployees.size() + developmentEmployees.size()));
        System.out.println("\nList of Management Employees:");

        for (Management manager : managementEmployees) {
            System.out.println(manager.toString());
        }

        System.out.println("\nList of Development Employees:");

        for (Development developer : developmentEmployees) {
            System.out.println(developer.toString());
        }
    }
    

    // Method to update the email address of an employee
        public void updateEmail(int employeeID, String newEmail) {
        boolean found = false;

        for (Management manager : managementEmployees) {
            if (manager.getEmployeeID() == employeeID) {
                manager.setEmail(newEmail);
                found = true;
                break;
            }
        }

        if (!found) {
            for (Development developer : developmentEmployees) {
                if (developer.getEmployeeID() == employeeID) {
                    developer.setEmail(newEmail);
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            System.out.println("Email updated successfully.");
        } else {
            System.out.println("Employee with ID " + employeeID + " not found.");
        }
    }
    

    // Method to calculate and display monthly payroll
        public void calculateAndDisplayPayroll() {
        System.out.println("Payroll Statements:");
        for (Management manager : managementEmployees) {
            double monthlySalary = manager.getYearlySalary() / 12;
            double tax = monthlySalary * 0.2;
            double netSalary = monthlySalary - tax;

            System.out.println("Name: " + manager.getFirstName() + " " + manager.getLastName());
            System.out.println("Employee ID: " + manager.getEmployeeID());
            System.out.println("Net Salary (after 20% tax deduction): $" + netSalary);
            System.out.println("------------------------------");
        }

        for (Development developer : developmentEmployees) {
            double monthlySalary = developer.getYearlySalary() / 12;
            double tax = monthlySalary * 0.2;
            double netSalary = monthlySalary - tax;

            System.out.println("Name: " + developer.getFirstName() + " " + developer.getLastName());
            System.out.println("Employee ID: " + developer.getEmployeeID());
            System.out.println("Net Salary (after 20% tax deduction): $" + netSalary);
            System.out.println("------------------------------");
        }
    }
    

    // Method to display employees supervised by a Team Manager
        public void displayEmployeesByManager(int managerID) {
        boolean found = false;

        for (Management manager : managementEmployees) {
            if (manager.getEmployeeID() == managerID) {
                found = true;
                System.out.println("Employees supervised by Manager:");
                for (Development developer : developmentEmployees) {
                    if (developer.getSupervisorID() == managerID) {
                        System.out.println(developer.toString());
                    }
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Manager with ID " + managerID + " not found.");
        }
    }
    

    // Method to search for an employee by first name or last name
        public void searchEmployee(String searchTerm) {
            boolean found = false;

            System.out.println("Matching Employees:");
            for (Management manager : managementEmployees) {
                if (manager.getFirstName().equalsIgnoreCase(searchTerm) ||
                        manager.getLastName().equalsIgnoreCase(searchTerm) ||
                        Integer.toString(manager.getEmployeeID()).equals(searchTerm)) {
                    System.out.println(manager.toString());
                    found = true;
                }
            }

            for (Development developer : developmentEmployees) {
                if (developer.getFirstName().equalsIgnoreCase(searchTerm) ||
                        developer.getLastName().equalsIgnoreCase(searchTerm) ||
                        Integer.toString(developer.getEmployeeID()).equals(searchTerm)) {
                    System.out.println(developer.toString());
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No matching employees found for the search term: " + searchTerm);
            }
        }

    

    // Method to remove employees from the system
         public void removeEmployee(int[] employeeIDs, boolean isManager) {
        if (!isManager) {
            System.out.println("You are NOT authorized to run this operation.");
            return;
        }

        int removedCount = 0;
        for (int employeeID : employeeIDs) {
            for (Management manager : managementEmployees) {
                if (manager.getEmployeeID() == employeeID) {
                    managementEmployees.remove(manager);
                    removedCount++;
                    break;
                }
            }

            for (Development developer : developmentEmployees) {
                if (developer.getEmployeeID() == employeeID) {
                    developmentEmployees.remove(developer);
                    removedCount++;
                    break;
                }
            }
        }

        System.out.println(removedCount + " employees have been removed from the system.");
    }
    

    // Method to promote an employee from Development to Management department
        public void promoteEmployee(int employeeID, boolean isManager) {
        if (!isManager) {
            System.out.println("You are NOT authorized to run this operation.");
            return;
        }

        Development employeeToPromote = null;

        for (Development developer : developmentEmployees) {
            if (developer.getEmployeeID() == employeeID) {
                employeeToPromote = developer;
                break;
            }
        }

        if (employeeToPromote != null) {
            // Remove from developmentEmployees
            developmentEmployees.remove(employeeToPromote);

            // Add to managementEmployees as a Manager
            Management promotedManager = new Manager(employeeToPromote);
            promotedManager.setTeamName("Management-training");
            promotedManager.setRank("Assistant Manager");

            managementEmployees.add(promotedManager);

            System.out.println("Employee promoted to Manager successfully.");
        } else {
            System.out.println("Employee with ID " + employeeID + " not found in Development Employees.");
        }
    
    }

		public void monthlyPayroll() {
			
		}
}
