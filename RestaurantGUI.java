

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

// This class is the GUI for the restaurant order processing system. When ran, it will display
// a table including multiple text boxes to enter your name, order and boxes that display pending
// and completed orders. 

public class RestaurantGUI extends JFrame {
    private final OrderManager manager = new OrderManager();
    private final JTextField nameField = new JTextField(15);
    private final JTextField itemsField = new JTextField(30);
    private final JTextArea pendingArea = new JTextArea(10, 30);
    private final JTextArea completedArea = new JTextArea(10, 30);

    public RestaurantGUI() {
        setTitle("Restaurant Order Processing System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // input panel for adding orders
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add New Order"));

        inputPanel.add(new JLabel("Customer Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Items (comma-separated):"));
        inputPanel.add(itemsField);

        JButton addButton = new JButton("Add Order");
        JButton processButton = new JButton("Process Order");
        JButton sortButton = new JButton("Show Sorted Orders");

        inputPanel.add(addButton);
        inputPanel.add(processButton);

        add(inputPanel, BorderLayout.NORTH);
        add(sortButton, BorderLayout.SOUTH);

        // Center display panel for the pending orders and completed orders
        JPanel displayPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        pendingArea.setEditable(false);
        completedArea.setEditable(false);
        displayPanel.add(new JScrollPane(pendingArea));
        displayPanel.add(new JScrollPane(completedArea));

        add(displayPanel, BorderLayout.CENTER);

        // Action Listeners for adding, processing and showing sorted orders. 
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String[] itemsArray = itemsField.getText().trim().split(",");
            List<String> items = Arrays.stream(itemsArray).map(String::trim).filter(s -> !s.isEmpty()).toList();

            if (name.isEmpty() || items.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid name and at least one item.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            manager.addOrder(new Order(name, items));
            nameField.setText("");
            itemsField.setText("");
            updateDisplay();
        });

        processButton.addActionListener(e -> {
            manager.processOrder();
            updateDisplay();
        });

        sortButton.addActionListener(e -> {
            List<Order> sorted = manager.getPendingOrdersSorted();
            pendingArea.setText("Sorted Pending Orders:\n");
            for (Order o : sorted) {
                pendingArea.append(o.toString() + "\n");
            }
        });

        updateDisplay();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateDisplay() {
        StringBuilder pendingText = new StringBuilder("Pending Orders:\n");
        for (Order order : manager.getPendingOrders()) {
            pendingText.append(order).append("\n");
        }

        StringBuilder completedText = new StringBuilder("Completed Orders:\n");
        for (Order order : manager.getCompletedOrders()) {
            completedText.append(order).append("\n");
        }

        pendingArea.setText(pendingText.toString());
        completedArea.setText(completedText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RestaurantGUI::new);
    }
}
