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
import java.awt.*;
import java.sql.*;

public class FeedbackViewer extends JFrame {
    private JTextArea feedbackDisplay;

    private Connection connection;

    public FeedbackViewer() {
        setTitle("Feedback Viewer");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        feedbackDisplay = new JTextArea(10, 30);
        feedbackDisplay.setEditable(false);

        add(new JScrollPane(feedbackDisplay), BorderLayout.CENTER);

        connectToDatabase();
        loadFeedbackData();
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/product";
            String user = "root";
            String password = "ramisa123";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFeedbackData() {
        try {
            String query = "SELECT name, feedback FROM feedback";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder feedbackText = new StringBuilder();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String feedback = resultSet.getString("feedback");
             

                feedbackText.append("Name: ").append(name).append("\n");
                feedbackText.append("Feedback: ").append(feedback).append("\n");
            
            }

            feedbackDisplay.setText(feedbackText.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FeedbackViewer feedbackViewer = new FeedbackViewer();
            feedbackViewer.setVisible(true);
        });
    }
}