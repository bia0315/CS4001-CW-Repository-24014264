import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Main class with GUI
public class GadgetShop extends JFrame implements ActionListener {

    // List to store all gadgets
    private ArrayList<Gadget> gadgetList = new ArrayList<>();

    // Text fields
    private JTextField itemField, brandField, priceField;
    private JTextField minuteField, textField, memoryField;
    private JTextField actionField;

    // Buttons
    private JButton addMobileBtn, addMP3Btn, displayBtn;
    private JButton callBtn, downloadBtn, clearBtn;

    public GadgetShop() {

        setTitle("Gadget Shop");
        setSize(500, 500);
        setLayout(new GridLayout(12, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create fields
        itemField = new JTextField();
        brandField = new JTextField();
        priceField = new JTextField();
        minuteField = new JTextField();
        textField = new JTextField();
        memoryField = new JTextField();
        actionField = new JTextField();

        // Create buttons
        addMobileBtn = new JButton("Add Mobile");
        addMP3Btn = new JButton("Add MP3");
        displayBtn = new JButton("Display All");
        callBtn = new JButton("Make Call");
        downloadBtn = new JButton("Download Music");
        clearBtn = new JButton("Clear Fields");

        // Add labels and fields
        add(new JLabel("Item Number:")); add(itemField);
        add(new JLabel("Brand:")); add(brandField);
        add(new JLabel("Price:")); add(priceField);
        add(new JLabel("Minutes (Mobile):")); add(minuteField);
        add(new JLabel("Texts (Mobile):")); add(textField);
        add(new JLabel("Memory (MP3 GB):")); add(memoryField);
        add(new JLabel("Call/Download Value:")); add(actionField);

        // Add buttons
        add(addMobileBtn); add(addMP3Btn);
        add(displayBtn); add(callBtn);
        add(downloadBtn); add(clearBtn);

        // Add action listeners
        addMobileBtn.addActionListener(this);
        addMP3Btn.addActionListener(this);
        displayBtn.addActionListener(this);
        callBtn.addActionListener(this);
        downloadBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // Add Mobile
            if (e.getSource() == addMobileBtn) {
                int item = Integer.parseInt(itemField.getText());
                String brand = brandField.getText();
                double price = Double.parseDouble(priceField.getText());
                int minutes = Integer.parseInt(minuteField.getText());
                int texts = Integer.parseInt(textField.getText());

                Mobile m = new Mobile(item, brand, price, minutes, texts);
                gadgetList.add(m);

                JOptionPane.showMessageDialog(this, "Mobile added successfully.");
            }

            // Add MP3
            if (e.getSource() == addMP3Btn) {
                int item = Integer.parseInt(itemField.getText());
                String brand = brandField.getText();
                double price = Double.parseDouble(priceField.getText());
                double memory = Double.parseDouble(memoryField.getText());

                MP3 mp3 = new MP3(item, brand, price, memory);
                gadgetList.add(mp3);

                JOptionPane.showMessageDialog(this, "MP3 added successfully.");
            }

            // Display All
            if (e.getSource() == displayBtn) {
                String output = "";
                for (Gadget g : gadgetList) {
                    output += g.displayInfo() + "\n";
                }
                JOptionPane.showMessageDialog(this, output);
            }

            // Make Call
            if (e.getSource() == callBtn) {
                int minutes = Integer.parseInt(actionField.getText());

                for (Gadget g : gadgetList) {
                    if (g instanceof Mobile) {
                        Mobile m = (Mobile) g;
                        JOptionPane.showMessageDialog(this, m.makeCall(minutes));
                        break;
                    }
                }
            }

            // Download Music
            if (e.getSource() == downloadBtn) {
                double size = Double.parseDouble(actionField.getText());

                for (Gadget g : gadgetList) {
                    if (g instanceof MP3) {
                        MP3 mp3 = (MP3) g;
                        JOptionPane.showMessageDialog(this, mp3.download(size));
                        break;
                    }
                }
            }

            // Clear Fields
            if (e.getSource() == clearBtn) {
                itemField.setText("");
                brandField.setText("");
                priceField.setText("");
                minuteField.setText("");
                textField.setText("");
                memoryField.setText("");
                actionField.setText("");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check values.");
        }
    }

    // Main method
    public static void main(String[] args) {
        new GadgetShop();
    }
}