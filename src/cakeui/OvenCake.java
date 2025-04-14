/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeui;


import cakemodel.Cake;
import cakemodel.Oven;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author roger
 */

public class OvenCake extends JFrame {
    private Oven oven = new Oven();
    private JTextArea displayArea;

    public OvenCake() {
        setTitle("Baker's Oven Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Cake Name:");
        JTextField nameField = new JTextField();
        JLabel weightLabel = new JLabel("Weight (grams):");
        JTextField weightField = new JTextField();
        JLabel dateLabel = new JLabel("Best Before (dd/MM/yyyy):");
        JTextField dateField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);

        // Buttons
        JButton addButton = new JButton("Add Cake");
        JButton removeButton = new JButton("Remove Cake");
        JButton displayButton = new JButton("Display All Cakes");
        JButton exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(exitButton);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String weightText = weightField.getText();
                String date = dateField.getText();

                if (name.isEmpty() || weightText.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!");
                    return;
                }

                try {
                    int weight = Integer.parseInt(weightText);
                    String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    Cake cake = new Cake(name, weight, date, time);

                    if (oven.addCake(cake)) {
                        displayArea.append("Added: " + cake + "\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "Oven is full! No more capacity.");
                    }

                    // Clear fields
                    nameField.setText("");
                    weightField.setText("");
                    dateField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Weight must be a number!");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                Cake removedCake = oven.removeCake();
                if (removedCake != null) {
                    displayArea.append("Removed: " + removedCake + "\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Oven is empty!");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(oven.getAllCakes());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                new OvenCake().setVisible(true);
            }
        });
    }
}
