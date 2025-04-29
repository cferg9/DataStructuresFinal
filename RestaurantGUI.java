// RestaurantGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class RestaurantGUI {
    private OrderManager manager = new OrderManager();
    private JFrame frame;
    private JTextArea pendingArea, completedArea;

    public RestaurantGUI() {
        frame = new JFrame("Restaurant Order System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel();
        JTextField nameField = new JTextField(10);
        JTextField itemsField = new JTextField(20);
        JButton addButton = new JButton("Add Order");

        inputPanel.add(new JLabel("Customer Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Items (comma-separated):"));
        inputPanel.add(itemsField);
        inputPanel.add(addButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String[] items = itemsField.getText().split(",");
            if (!name.isEmpty() && items.length > 0) {
                manager.addOrder(new Order(name, Arrays.asList(items)));
                updateDisplay();
            }
        });

        JButton processButton = new JButton("Process Order");
        processButton.addActionListener(e -> {
            manager.processOrder();
            updateDisplay();
        });

        pendingArea = new JTextArea(10, 25);
        completedArea = new JTextArea(10, 25);
        pendingArea.setEditable(false);
        completedArea.setEditable(false);

        JPanel displayPanel = new JPanel();
        displayPanel.add(new JScrollPane(pendingArea));
        displayPanel.add(new JScrollPane(completedArea));

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(processButton, BorderLayout.CENTER);
        panel.add(displayPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        updateDisplay();
    }

    private void updateDisplay() {
        StringBuilder pendingText = new StringBuilder("Pending Orders:\n");
        for (Order order : manager.getPendingOrdersSorted()) {
            pendingText.append(order.toString()).append("\n");
        }

        StringBuilder completedText = new StringBuilder("Completed Orders:\n");
        for (Order order : manager.getCompletedOrders()) {
            completedText.append(order.toString()).append("\n");
        }

        pendingArea.setText(pendingText.toString());
        completedArea.setText(completedText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RestaurantGUI::new);
    }
}
