
import java.util.*;

// This class uses a queue and stack to manage pending orders and completed orders. It also 
// utilizes a bubble sort to sort each order by the number of items per order which is distinct
// for each customer. 

public class OrderManager {
    private Queue<Order> pendingOrders;
    private Stack<Order> completedOrders;

    public OrderManager() {
        pendingOrders = new LinkedList<>();
        completedOrders = new Stack<>();
    }
// Method to add orders to the pending queue
    public void addOrder(Order order) {
        pendingOrders.add(order);
    }
//  processes the next order in the queue, which then moves it to the completed orders
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

    // Sorting pending orders by number of items using a bubble sort
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
