import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener
{
    private ArrayList<Gadget> gadgets;

    // Text fields
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField downloadSizeField;
    private JTextField displayNumberField;

    public GadgetShop()
    {
        gadgets = new ArrayList<Gadget>();

        setTitle("Gadget Shop");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));

        panel.add(new JLabel("Model:"));
        modelField = new JTextField();
        panel.add(modelField);

        panel.add(new JLabel("Price (£):"));
        priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("Weight (g):"));
        weightField = new JTextField();
        panel.add(weightField);

        panel.add(new JLabel("Size:"));
        sizeField = new JTextField();
        panel.add(sizeField);

        panel.add(new JLabel("Initial Credit:"));
        creditField = new JTextField();
        panel.add(creditField);

        panel.add(new JLabel("Initial Memory:"));
        memoryField = new JTextField();
        panel.add(memoryField);

        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("Call Duration:"));
        durationField = new JTextField();
        panel.add(durationField);

        panel.add(new JLabel("Download Size:"));
        downloadSizeField = new JTextField();
        panel.add(downloadSizeField);

        panel.add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        panel.add(displayNumberField);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new GadgetShop();
    }

    public void actionPerformed(ActionEvent e)
    {
        // Button logic will be added later
    }
}
