import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class OrderManagerTest {

    @Test
    public void testAddAndProcessOrder() {
        OrderManager manager = new OrderManager();
        Order order = new Order("Alice", Arrays.asList("Burger", "Fries"));
        manager.addOrder(order);

        assertEquals(1, manager.getPendingOrders().size());
        manager.processOrder();
        assertEquals(0, manager.getPendingOrders().size());
        assertEquals(1, manager.getCompletedOrders().size());
    }

    @Test
    public void testSortingOrders() throws InterruptedException {
        OrderManager manager = new OrderManager();
        manager.addOrder(new Order("Bob", Arrays.asList("Taco")));
        Thread.sleep(10); // Ensure different timestamps
        manager.addOrder(new Order("Charlie", Arrays.asList("Pizza")));

        List<Order> sorted = manager.getPendingOrdersSorted();
        assertTrue(sorted.get(0).getOrderTime() <= sorted.get(1).getOrderTime());
    }
} 

