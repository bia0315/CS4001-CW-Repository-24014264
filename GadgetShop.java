import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener {

    // Store all gadgets
    private ArrayList<Gadget> gadgetList = new ArrayList<>();

    // Text fields
    private JTextField modelField, priceField, weightField;
    private JTextField sizeField, creditField, memoryField;

    // New required fields
    private JTextField displayNumberField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField downloadSizeField;

    // Buttons
    private JButton addMobileBtn, addMP3Btn, displayBtn;
    private JButton makeCallBtn, downloadMusicBtn, clearBtn;

    public GadgetShop() {

        setTitle("Gadget Shop");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(14, 2));

        // Basic inputs
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

        // New required inputs
        add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        add(displayNumberField);

        add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        add(phoneNumberField);

        add(new JLabel("Call Duration (mins):"));
        durationField = new JTextField();
        add(durationField);

        add(new JLabel("Download Size (GB):"));
        downloadSizeField = new JTextField();
        add(downloadSizeField);

        // Buttons
        addMobileBtn = new JButton("Add Mobile");
        addMP3Btn = new JButton("Add MP3");
        displayBtn = new JButton("Display All");
        makeCallBtn = new JButton("Make Call");
        downloadMusicBtn = new JButton("Download Music");
        clearBtn = new JButton("Clear Fields");

        add(addMobileBtn);
        add(addMP3Btn);
        add(displayBtn);
        add(makeCallBtn);
        add(downloadMusicBtn);
        add(clearBtn);

        // Add listeners
        addMobileBtn.addActionListener(this);
        addMP3Btn.addActionListener(this);
        displayBtn.addActionListener(this);
        makeCallBtn.addActionListener(this);
        downloadMusicBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // We will implement logic next
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}