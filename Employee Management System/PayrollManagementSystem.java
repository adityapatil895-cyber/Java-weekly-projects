import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int empId;
    String name;
    String designation;
    double basicSalary;
    double hra, da, grossSalary, deductions, netSalary;

    Employee(int empId, String name, String designation, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        calculateSalary();
    }

    void calculateSalary() {
        hra = 0.20 * basicSalary;
        da = 0.10 * basicSalary;
        grossSalary = basicSalary + hra + da;
        deductions = 0.08 * grossSalary;
        netSalary = grossSalary - deductions;
    }

    void display() {
        System.out.println("ID: " + empId +
                ", Name: " + name +
                ", Designation: " + designation +
                ", Net Salary: ₹" + netSalary);
    }
}

public class PayrollManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Employee findEmployee(int id) {
        for (Employee e : employees) {
            if (e.empId == id) {
                return e;
            }
        }
        return null;
    }

    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Designation: ");
        String desig = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, desig, salary));
        System.out.println(" Employee Added & Salary Calculated!");
    }

    static void viewEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);
        if (e != null) {
            e.display();
        } else {
            System.out.println(" Employee Not Found!");
        }
    }

    static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println(" No Employees Found.");
        } else {
            for (Employee e : employees) {
                e.display();
            }
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Employee Payroll Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Payroll");
            System.out.println("3. View All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployee(); break;
                case 3: viewAllEmployees(); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }
}