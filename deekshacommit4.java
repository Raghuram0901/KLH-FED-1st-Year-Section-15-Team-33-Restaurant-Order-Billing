import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantApp extends Restaurant {

    // Stores customer orders
    private ArrayList<String> orderList = new ArrayList<>();

    public void takeOrder(Scanner sc) {

        displayMenu();

        while (true) {

            System.out.print(
                "\nEnter item number (0 to finish): ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > getMenuSize()) {
                System.out.println("Invalid menu choice.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());

            if (quantity <= 0) {
                System.out.println(
                    "Quantity must be greater than zero.");
                continue;
            }

            String item = getMenuItem(choice - 1);

            orderList.add(item + " x " + quantity);

            System.out.println("Order added successfully.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RestaurantApp app = new RestaurantApp();

        try {
            app.loadMenu();
            app.takeOrder(sc);
        } catch (IOException e) {
            System.out.println("Error reading menu.txt.");
        } finally {
            sc.close();
        }
    }
}