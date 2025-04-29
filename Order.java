import java.util.*;

public class Order implements Comparable<Order> {
    private static int idCounter = 1;
    private int orderID;
    private String customerName;
    private List<String> items;
    private long orderTime;

    public Order(String customerName, List<String> items) {
        this.orderID = idCounter++;
        this.customerName = customerName;
        this.items = new ArrayList<>(items);
        this.orderTime = System.currentTimeMillis();
    }

    public int getOrderID() { return orderID; }
    public String getCustomerName() { return customerName; }
    public List<String> getItems() { return items; }
    public long getOrderTime() { return orderTime; }

    @Override
    public int compareTo(Order other) {
        return Long.compare(this.orderTime, other.orderTime);
    }

    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Customer: " + customerName + ", Items: " + items;
    }
}
