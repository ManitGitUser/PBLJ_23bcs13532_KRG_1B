import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

public class ProductDiscountMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> products = new HashMap<>();

        System.out.println("Adding products: P001=$50.0, P002=$100.0");
        products.put("P001", 50.0);
        products.put("P002", 100.0);

        while (true) {
            System.out.println("\n--- Product Menu ---");
            System.out.println("1. Apply Discount");
            System.out.println("2. Display Products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    String id = sc.next();
                    System.out.print("Enter Discount Percentage: ");
                    double discount = sc.nextDouble();

                    try {
                        if (!products.containsKey(id)) {
                            throw new ProductNotFoundException("Error: Product ID not found!");
                        }
                        if (discount < 0 || discount > 100) {
                            throw new IllegalArgumentException("Error: Discount percentage must be between 0 and 100!");
                        }

                        double oldPrice = products.get(id);
                        double newPrice = oldPrice - (oldPrice * discount / 100);
                        products.put(id, newPrice);

                        System.out.println("New price for " + id + ": $" + newPrice);
                    } catch (ProductNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Product List:");
                    for (Map.Entry<String, Double> entry : products.entrySet()) {
                        System.out.println(entry.getKey() + " = $" + entry.getValue());
                    }
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
