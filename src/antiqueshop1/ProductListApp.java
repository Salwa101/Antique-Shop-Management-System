/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antiqueshop1;

/**
 *
 * @author HP
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductListApp extends JFrame {

    private JTable productTable;

    public ProductListApp() {
        setTitle("Product List App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);

        productTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(productTable);

        add(scrollPane);
        updateProductTable();
    }

    private void updateProductTable() {
        String url = "jdbc:mysql://localhost:3306/product";
        String username = "root";
        String password = "ramisa123";

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Quantity");

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String selectQuery = "SELECT id, name, quantity FROM products";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                tableModel.addRow(new Object[]{id, productName, quantity});
            }

            productTable.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating product table: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProductListApp().setVisible(true);
            }
        });
    }
}

