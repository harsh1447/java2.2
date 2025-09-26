import java.io.*;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee {ID=" + id + ", Name='" + name + "', Designation='" + designation + "', Salary=" + salary + "}";
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    // Add employee to file
    public static void addEmployee(Employee emp) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(emp.toString());
            bw.newLine();
            System.out.println("✅ Employee added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Display all employees from file
    public static void displayEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Employee Records ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-------------------------\n");
        } catch (FileNotFoundException e) {
            System.out.println("⚠ No employee records found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(id, name, designation, salary);
                    addEmployee(emp);
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    System.out.println("✅ Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("⚠ Invalid choice. Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
