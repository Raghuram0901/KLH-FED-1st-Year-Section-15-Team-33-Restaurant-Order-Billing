private double totalBill = 0;

public int getMenuSize() {
    return menuItems.size();
}

public String getMenuItem(int index) {
    return menuItems.get(index);
}

public void addToBill(double amount) {
    totalBill += amount;
}

public double getTotalBill() {
    return totalBill;
}