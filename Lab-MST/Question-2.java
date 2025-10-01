import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

public class EmployeeMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> employees = new HashMap<>();

        System.out.println("Adding employees...");
        employees.put(101, "John");
        employees.put(102, "Jane");
        employees.put(103, "Mike");

        System.out.println("Employee Map: " + employees);

        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    employees.put(id, name);
                    System.out.println("Employee added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Employee ID to search: ");
                    int id = sc.nextInt();
                    try {
                        if (!employees.containsKey(id)) {
                            throw new EmployeeNotFoundException("Error: Employee ID not found!");
                        }
                        System.out.println("Name for ID " + id + ": " + employees.get(id));
                    } catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Employee Map:");
                    for (Map.Entry<Integer, String> entry : employees.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
