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

public class FeedbackPage extends JFrame {
    private JTextArea feedbackTextArea;
    private JButton submitButton;
    private JButton previousButton;

    public FeedbackPage() {
        initializeComponents();
        createAndShowGUI();
    }

    private void initializeComponents() {
        feedbackTextArea = new JTextArea(10, 30);
        feedbackTextArea.setLineWrap(true);
        feedbackTextArea.setWrapStyleWord(true);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedback = feedbackTextArea.getText();
                //database
                JOptionPane.showMessageDialog(FeedbackPage.this,
                        "Thank you for your feedback:\n" + feedback,
                        "Feedback Submitted",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        previousButton = new JButton("Back");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 menuJFrame menu=new  menuJFrame();
        menu.show();
        dispose(); 
            }
        });
    }

    private void createAndShowGUI() {
        setTitle("Feedback Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK); // Set background color to black

        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(new JScrollPane(feedbackTextArea), BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(submitButton);
        buttonPanel.add(previousButton);

       
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

       
        getContentPane().add(mainPanel);

        
        setSize(700, 800);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FeedbackPage();
            }
        });
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FeedbackPage extends JFrame {
    private JTextField nameField;
    private JTextArea feedbackArea;
    private JButton submitButton;

    private Connection connection;

    public FeedbackPage() {
        setTitle("Feedback Page");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        nameField = new JTextField(20);
        feedbackArea = new JTextArea(10, 30);
        submitButton = new JButton("Submit");

        JPanel formPanel = new JPanel(new GridLayout(2, 2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Feedback:"));
        formPanel.add(new JScrollPane(feedbackArea));

        add(formPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitFeedback();
            }
        });

        connectToDatabase();
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

    private void submitFeedback() {
        String name = nameField.getText();
        String feedback = feedbackArea.getText();

        try {
            String query = "INSERT INTO feedback (name, feedback) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, feedback);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Feedback submitted successfully!");
            nameField.setText("");
            feedbackArea.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FeedbackPage feedbackPage = new FeedbackPage();
            feedbackPage.setVisible(true);
        });
    }
}

