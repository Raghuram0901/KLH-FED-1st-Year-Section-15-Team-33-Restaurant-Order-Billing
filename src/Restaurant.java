import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurant {
    // Stores the menu items loaded from menu.txt.
    private final ArrayList<String> menuItems = new ArrayList<>();

    // Stores the running total of the customer's order.
    private double totalBill;

    // Reads each menu line from the file and stores it in the ArrayList.
    public void loadMenu(String fileName) throws IOException {
        menuItems.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    menuItems.add(line.trim());
                }
            }
        }
    }

    // Displays each menu item with its number and price.
    public void displayMenu() {
        StringBuffer menuDisplay = new StringBuffer();

        menuDisplay.append("\n========== RESTAURANT MENU ==========\n");

        for (int i = 0; i < menuItems.size(); i++) {
            String[] parts = menuItems.get(i).split(",", 2);
            menuDisplay.append(i + 1)
                       .append(". ")
                       .append(parts[0].trim())
                       .append(" - Rs. ")
                       .append(parts[1].trim())
                       .append('\n');
        }

        System.out.print(menuDisplay);
    }

    // Returns how many items are in the menu.
    public int getMenuSize() {
        return menuItems.size();
    }

    // Returns a menu entry using a zero-based index.
    public String getMenuItem(int index) {
        return menuItems.get(index);
    }

    // Adds an item's cost to the running bill.
    public void addToBill(double amount) {
        totalBill += amount;
    }

    // Returns the running bill.
    public double getTotalBill() {
        return totalBill;
    }
}
