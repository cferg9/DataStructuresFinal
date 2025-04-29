
// OrderManager.java
import java.util.*;

public class OrderManager {
    private Queue<Order> pendingOrders;
    private Stack<Order> completedOrders;

    public OrderManager() {
        pendingOrders = new LinkedList<>();
        completedOrders = new Stack<>();
    }

    public void addOrder(Order order) {
        pendingOrders.add(order);
    }

    public void processOrder() {
        if (!pendingOrders.isEmpty()) {
            completedOrders.push(pendingOrders.poll());
        }
    }

    public Queue<Order> getPendingOrders() {
        return pendingOrders;
    }

    public Stack<Order> getCompletedOrders() {
        return completedOrders;
    }

    // Sorting pending orders by number of items (Bubble Sort for demonstration)
    public List<Order> getPendingOrdersSorted() {
        List<Order> sorted = new ArrayList<>(pendingOrders);
        for (int i = 0; i < sorted.size(); i++) {
            for (int j = 0; j < sorted.size() - 1 - i; j++) {
                if (sorted.get(j).getItems().size() > sorted.get(j + 1).getItems().size()) {
                    Collections.swap(sorted, j, j + 1);
                }
            }
        }
        return sorted;
    }
}