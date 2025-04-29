 Restaurant Order Processing System

 Project Description
 
This Java application simulates a restaurant's order processing system using two primary data structures:
- A Queue to manage incoming (pending) orders
- A Stack to keep track of completed orders

It also features a custom bubble sort algorithm to sort pending orders by the number of items. 
The program includes a GUI (Graphical User Interface) built with Java Swing for interactive user input and JUnit tests for logic verification.

---

 Features
- Add a new order with customer name and list of items
- Display pending and completed orders
- Process the next order in line (FIFO order)
- Sort pending orders by item count using custom sort
- Swing-based GUI for real-time interaction
- Input validation for data consistency
- Unit testing with JUnit 5

---

  Technologies Used
- Java
- Java Swing
- JUnit 5
- Git / GitHub

---

 How to Run

Prerequisites
- Java JDK 8 or higher
- IDE such as IntelliJ IDEA or Eclipse

 Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/DataStructuresFinal.git
   ```
2. Open the project folder in your Java IDE.
3. Run the file `RestaurantGUI.java`.
4. Use the application by entering order information in the GUI.

---

  How to Use
- Add Order: Enter a name and a comma-separated list of items, then click "Add Order".
- Process Order: Click "Process Order" to move the oldest order from the pending queue to the completed stack.
- Show Sorted Orders: Click to sort and display pending orders by the number of items.

---

 Running Unit Tests
The project uses **JUnit 5** for testing the `OrderManager` class.

To run tests:
- Open `OrderManagerTest.java`
- Run using your IDE’s JUnit test runner

Tests include:
- Adding and retrieving orders
- Sorting functionality
- Processing completed orders

---

 Screenshots
-- Include screenshots of GUI -- TODO

---

 Author
Colton Ferguson 
Final Project for CIS 153 - Data Structures
Instructed by Byran Burkhardt

---
Thank you for reviewing this project!

