public void sendToKitchen() {

    StringBuffer ticket = new StringBuffer();

    ticket.append("\n===== KITCHEN ORDER TICKET =====\n");

    for (String order : orderList) {
        ticket.append(order).append("\n");
    }

    ticket.append("Status: Order received by kitchen\n");

    System.out.println(ticket);
}