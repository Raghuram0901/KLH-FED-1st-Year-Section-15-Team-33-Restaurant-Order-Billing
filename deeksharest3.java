import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantApp extends Restaurant {
    // Stores descriptions of the items ordered by the customer.
    private final ArrayList<String> orderList = new ArrayList<>();

    // Accepts menu selections and quantities from the customer.
    public void takeOrder(Scanner scanner) {
        while (true) {
            System.out.print("\nEnter menu item number (0 to finish): ");
            String choiceText = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(choiceText);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
                continue;
            }

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > getMenuSize()) {
                System.out.println("That menu number does not exist. Try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            String quantityText = scanner.nextLine().trim();

            int quantity;
            try {
                quantity = Integer.parseInt(quantityText);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole-number quantity.");
                continue;
            }

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                continue;
            }

            String[] parts = getMenuItem(choice - 1).split(",", 2);
            String itemName = parts[0].trim();

            double price;
            try {
                price = Double.parseDouble(parts[1].trim());
            } catch (NumberFormatException exception) {
                System.out.println("The price for this menu item is invalid.");
                continue;
            }

            double amount = price * quantity;

            StringBuffer description = new StringBuffer();
            description.append(itemName)
                       .append(" x ")
                       .append(quantity)
                       .append(" = Rs. ")
                       .append(String.format("%.2f", amount));

            orderList.add(description.toString());
            addToBill(amount);

            System.out.println("Added: " + description);
        }

        if (orderList.isEmpty()) {
            System.out.println("No items were ordered.");
        }
    }

    // Prints the customer's order and calculates any eligible discount.
    public void displayBill() {
        System.out.println("\n========== CUSTOMER BILL ==========");

        if (orderList.isEmpty()) {
            System.out.println("No items ordered.");
            System.out.println("Total: Rs. 0.00");
            return;
        }

        for (String item : orderList) {
            System.out.println(item);
        }

        double subtotal = getTotalBill();
        double discountRate;

        if (subtotal >= 1000) {
            discountRate = 0.10;
        } else if (subtotal >= 500) {
            discountRate = 0.05;
        } else {
            discountRate = 0.0;
        }

        double discount = subtotal * discountRate;
        double finalAmount = subtotal - discount;

        System.out.printf("Subtotal: Rs. %.2f%n", subtotal);
        System.out.printf("Discount: Rs. %.2f%n", discount);
        System.out.printf("Final amount: Rs. %.2f%n", finalAmount);
    }
