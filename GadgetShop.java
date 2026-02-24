import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Main shop GUI class
public class GadgetShop extends JFrame {

    // ArrayList to store gadgets
    private ArrayList<Gadget> gadgets;

    // Text fields (10 required)
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField extraField;       // minutes credit OR memory
    private JTextField displayNumberField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField musicSizeField;
    private JTextArea outputArea;

    public GadgetShop() {

        gadgets = new ArrayList<>();

        setTitle("Gadget Shop");
        setSize(600, 600);
        setLayout(new FlowLayout());

        // Create text fields
        modelField = new JTextField(10);
        priceField = new JTextField(10);
        weightField = new JTextField(10);
        sizeField = new JTextField(10);
        extraField = new JTextField(10);
        displayNumberField = new JTextField(5);
        phoneNumberField = new JTextField(10);
        durationField = new JTextField(5);
        musicSizeField = new JTextField(5);
        outputArea = new JTextArea(10, 50);

        // Add labels and fields
        add(new JLabel("Model:")); add(modelField);
        add(new JLabel("Price:")); add(priceField);
        add(new JLabel("Weight:")); add(weightField);
        add(new JLabel("Size:")); add(sizeField);
        add(new JLabel("Credit/Memory:")); add(extraField);
        add(new JLabel("Display Number:")); add(displayNumberField);
        add(new JLabel("Phone Number:")); add(phoneNumberField);
        add(new JLabel("Duration:")); add(durationField);
        add(new JLabel("Music Size:")); add(musicSizeField);

        // Buttons
        JButton addMobileBtn = new JButton("Add Mobile");
        JButton addMP3Btn = new JButton("Add MP3");
        JButton displayBtn = new JButton("Display All");
        JButton callBtn = new JButton("Make Call");
        JButton downloadBtn = new JButton("Download Music");
        JButton clearBtn = new JButton("Clear");

        add(addMobileBtn);
        add(addMP3Btn);
        add(displayBtn);
        add(callBtn);
        add(downloadBtn);
        add(clearBtn);

        add(new JScrollPane(outputArea));

        // Button Actions

        // Add Mobile
        addMobileBtn.addActionListener(e -> {
            try {
                String model = modelField.getText();
                double price = Double.parseDouble(priceField.getText());
                int weight = Integer.parseInt(weightField.getText());
                String size = sizeField.getText();
                int credit = Integer.parseInt(extraField.getText());

                Mobile m = new Mobile(model, price, weight, size, credit);
                gadgets.add(m);
                outputArea.append("Mobile added.\n");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number input.");
            }
        });

        // Add MP3
        addMP3Btn.addActionListener(e -> {
            try {
                String model = modelField.getText();
                double price = Double.parseDouble(priceField.getText());
                int weight = Integer.parseInt(weightField.getText());
                String size = sizeField.getText();
                double memory = Double.parseDouble(extraField.getText());

                MP3 mp3 = new MP3(model, price, weight, size, memory);
                gadgets.add(mp3);
                outputArea.append("MP3 added.\n");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number input.");
            }
        });

        // Display All
        displayBtn.addActionListener(e -> {
            outputArea.setText("");

            for (int i = 0; i < gadgets.size(); i++) {
                outputArea.append("Display Number: " + i + "\n");
                gadgets.get(i).display();
                outputArea.append("\n");
            }
        });

        // Make Call
        callBtn.addActionListener(e -> {
            int index = getDisplayNumber();

            if (index != -1 && gadgets.get(index) instanceof Mobile) {
                try {
                    String phone = phoneNumberField.getText();
                    int duration = Integer.parseInt(durationField.getText());

                    Mobile m = (Mobile) gadgets.get(index);
                    m.makeCall(phone, duration);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid duration.");
                }
            }
        });

        // Download Music
        downloadBtn.addActionListener(e -> {
            int index = getDisplayNumber();

            if (index != -1 && gadgets.get(index) instanceof MP3) {
                try {
                    double size = Double.parseDouble(musicSizeField.getText());

                    MP3 mp3 = (MP3) gadgets.get(index);
                    mp3.downloadMusic(size);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid music size.");
                }
            }
        });

        // Clear Fields
        clearBtn.addActionListener(e -> {
            modelField.setText("");
            priceField.setText("");
            weightField.setText("");
            sizeField.setText("");
            extraField.setText("");
            displayNumberField.setText("");
            phoneNumberField.setText("");
            durationField.setText("");
            musicSizeField.setText("");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to safely get display number
    private int getDisplayNumber() {
        int number = -1;

        try {
            number = Integer.parseInt(displayNumberField.getText());

            if (number < 0 || number >= gadgets.size()) {
                JOptionPane.showMessageDialog(this, "Invalid display number.");
                return -1;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid display number.");
            return -1;
        }

        return number;
    }

    // Main method
    public static void main(String[] args) {
        new GadgetShop();
    }
}