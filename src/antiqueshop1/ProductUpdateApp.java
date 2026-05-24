/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antiqueshop1;

/**
 *
 * @author HP
 */
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductUpdateApp extends JFrame {
    private JTextField productIdField;
    private JTextField quantityField;
    private JButton restockButton;
    private JButton stockoutButton;

    public ProductUpdateApp() {
        setTitle("Product Update App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,550);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel productIdLabel = new JLabel("Product ID:");
        productIdField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(10);

        restockButton = new JButton("Restock");
        stockoutButton = new JButton("Stockout");

        restockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductQuantity("restock");
            }
        });

        stockoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductQuantity("stockout");
            }
        });

        panel.add(productIdLabel);
        panel.add(productIdField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(restockButton);
        panel.add(stockoutButton);

        add(panel);
    }

    private void updateProductQuantity(String action) {
        int productId = Integer.parseInt(productIdField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        String url = "jdbc:mysql://localhost:3306/product";
        String username = "root";
        String password = "ramisa123";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String updateQuery = "UPDATE products SET quantity = quantity + ? WHERE id = ?";
            if (action.equals("stockout")) {
                updateQuery = "UPDATE products SET quantity = quantity - ? WHERE id = ?";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, productId);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product quantity updated successfully!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating product quantity: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProductUpdateApp().setVisible(true);
            }
        });
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductUpdateApp extends JFrame {
    private JTextField productIdField;
    private JTextField productNameField;  // New field for product name
    private JTextField quantityField;
    private JButton restockButton;
    private JButton stockoutButton;
    private JButton addButton;  // New button for adding products

    public ProductUpdateApp() {
        setTitle("Product Update App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));  // Adjusted for new components

        JLabel productIdLabel = new JLabel("Product ID:");
        productIdField = new JTextField(10);
        JLabel productNameLabel = new JLabel("Product Name:");  // New label
        productNameField = new JTextField(10);  // New field
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(10);

        restockButton = new JButton("Restock");
        stockoutButton = new JButton("Stockout");
        addButton = new JButton("Add Product");  // New button

        restockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductQuantity("restock");
            }
        });

        stockoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductQuantity("stockout");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewProduct();
            }
        });

        panel.add(productIdLabel);
        panel.add(productIdField);
        panel.add(productNameLabel);  // New label
        panel.add(productNameField);  // New field
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(restockButton);
        panel.add(stockoutButton);
        panel.add(addButton);  // New button

        add(panel);
    }

    private void updateProductQuantity(String action) {
        int productId = Integer.parseInt(productIdField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        String url = "jdbc:mysql://localhost:3306/product";
        String username = "root";
        String password = "ramisa123";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String updateQuery = "UPDATE products SET quantity = quantity + ? WHERE id = ?";
            if (action.equals("stockout")) {
                updateQuery = "UPDATE products SET quantity = quantity - ? WHERE id = ?";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, productId);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product quantity updated successfully!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating product quantity: " + ex.getMessage());
        }
    }

    private void addNewProduct() {
        int id= Integer.parseInt(productIdField.getText());
        String productName = productNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());

        String url = "jdbc:mysql://localhost:3306/product";
        String username = "root";
        String password = "ramisa123";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insertQuery = "INSERT INTO products (id,name, quantity) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
             preparedStatement.setInt(1, id);
            preparedStatement.setString(2, productName);
            preparedStatement.setInt(3, quantity);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "New product added successfully!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding new product: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProductUpdateApp().setVisible(true);
            }
        });
    }
}
