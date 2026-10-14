public void takeOrder(Scanner sc) {

    displayMenu();

    while (true) {
        try {
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
            String[] details = item.split(",");

            String itemName = details[0];
            double price = Double.parseDouble(details[1]);
            double amount = price * quantity;

            StringBuffer order = new StringBuffer();

            order.append(itemName)
                 .append(" x ")
                 .append(quantity)
                 .append(" = Rs. ")
                 .append(String.format("%.2f", amount));

            orderList.add(order.toString());
            addToBill(amount);

            System.out.println("Added: " + order);

        } catch (NumberFormatException e) {
            System.out.println(
                "Invalid input. Please enter a number.");
        }
    }
}