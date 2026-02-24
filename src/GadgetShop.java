import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener {

    // Store all gadgets here
    private ArrayList<Gadget> gadgetList = new ArrayList<>();

    // Text fields
    private JTextField modelField, priceField, weightField;
    private JTextField sizeField, creditField, memoryField;

    // Buttons
    private JButton addMobileBtn, addMP3Btn, displayBtn;

    public GadgetShop() {

        setTitle("Gadget Shop");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        // Input fields
        add(new JLabel("Model:"));
        modelField = new JTextField();
        add(modelField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Weight:"));
        weightField = new JTextField();
        add(weightField);

        add(new JLabel("Mobile Size:"));
        sizeField = new JTextField();
        add(sizeField);

        add(new JLabel("Mobile Credit:"));
        creditField = new JTextField();
        add(creditField);

        add(new JLabel("MP3 Memory (GB):"));
        memoryField = new JTextField();
        add(memoryField);

        // Buttons
        addMobileBtn = new JButton("Add Mobile");
        addMP3Btn = new JButton("Add MP3");
        displayBtn = new JButton("Display All");

        add(addMobileBtn);
        add(addMP3Btn);
        add(displayBtn);

        // Add listeners
        addMobileBtn.addActionListener(this);
        addMP3Btn.addActionListener(this);
        displayBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Common input validation
        String model = modelField.getText();

        if (model.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Model cannot be empty.");
            return;
        }

        double price;
        int weight;

        try {
            price = Double.parseDouble(priceField.getText());
            weight = Integer.parseInt(weightField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers.");
            return;
        }

        // Add Mobile
        if (e.getSource() == addMobileBtn) {

            String size = sizeField.getText();
            int credit;

            try {
                credit = Integer.parseInt(creditField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid credit.");
                return;
            }

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgetList.add(mobile);

            JOptionPane.showMessageDialog(this, "Mobile added!");
        }

        // Add MP3
        if (e.getSource() == addMP3Btn) {

            int memory;

            try {
                memory = Integer.parseInt(memoryField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid memory size.");
                return;
            }

            MP3 mp3 = new MP3(model, price, weight, memory);
            gadgetList.add(mp3);

            JOptionPane.showMessageDialog(this, "MP3 added!");
        }

        // Display all gadgets
        if (e.getSource() == displayBtn) {

            if (gadgetList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No gadgets added.");
                return;
            }

            String output = "";

            for (Gadget g : gadgetList) {
                output += g.displayInfo() + "\n";
            }

            JTextArea textArea = new JTextArea(output);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(350, 250));

            JOptionPane.showMessageDialog(this, scrollPane, "All Gadgets",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}