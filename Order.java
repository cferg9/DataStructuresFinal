import java.util.*;

// This class represents a customer's order with their name and a list of items. It includes
// methods that get the respective information for the processing system. 

public class Order implements Comparable<Order> {
    private static int idCounter = 1;
    private int orderID;
    private String customerName;
    private List<String> items;
    private long orderTime;

  
// This block of code builds an order with the specified customer name and items they ordered    
    public Order(String customerName, List<String> items) {
        this.orderID = idCounter++;
        this.customerName = customerName;
        this.items = new ArrayList<>(items);
        this.orderTime = System.currentTimeMillis();
    }
 // This block of code is creating methods for an OrderID, customer name, items, and order time
 // to then be able to return it so it is displayed. 
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

