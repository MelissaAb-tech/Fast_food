package order;

import java.util.ArrayList;
import item.Item;

public class OrderManager {
    private ArrayList<Item> orderItems;
    private double totalPrice;

    public OrderManager() {
        orderItems = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addItem(Item item) {
        orderItems.add(item);
        totalPrice += item.getPrice();
    }

    public void removeItem(int index) {
        if (index >= 0 && index < orderItems.size()) {
            totalPrice -= orderItems.get(index).getPrice();
            orderItems.remove(index);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        for (Item item : orderItems) {
            summary.append(item.getName()).append(" - ").append(item.getPrice()).append(" €\n");
        }
        summary.append("Total: ").append(String.format("%.2f", totalPrice)).append(" €");
        return summary.toString();
    }

    public void clearOrder() {
        orderItems.clear();
        totalPrice = 0.0;
    }
}
