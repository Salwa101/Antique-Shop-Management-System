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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUsPage extends JFrame {
    private JButton backButton;

    public AboutUsPage() {
        initializeComponents();
        createAndShowGUI();
    }

    private void initializeComponents() {
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 menuJFrame menu=new  menuJFrame();
        menu.show();
        dispose();
              
            }
        });
    }

    private void createAndShowGUI() {
        setTitle("About Us - Antique Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE); // Set background color to white

      
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

       
        String description = "Welcome to our Antique Shop!\n\n" +
                "At our shop, we offer a wide and exquisite collection of antique treasures " +
                "from different eras and cultures. Our passion for history and art has led us " +
                "to curate unique and authentic items that carry the stories of the past.\n\n" +
                "Whether you are an avid collector, a history enthusiast, or simply seeking " +
                "a distinctive piece to add character to your home, we have something for everyone. " +
                "From vintage furniture to rare artifacts, each item in our collection is carefully " +
                "selected to ensure its authenticity and charm.\n\n" +
                "Our knowledgeable staff is always delighted to share the history and significance " +
                "of each piece, making your visit a truly enriching experience. We take pride in " +
                "offering exceptional customer service and helping you find that perfect treasure " +
                "you've been searching for.\n\n" +
                "We invite you to step back in time with us and explore the beauty of the past. " +
                "Visit our Antique Shop today and embark on a journey through history.";

        JTextArea descriptionTextArea = new JTextArea(description);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionPanel.add(descriptionTextArea);

      
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(backButton);

       
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(descriptionPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        getContentPane().add(mainPanel);

       
        setSize(600, 700);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AboutUsPage();
            }
        });
    }
}