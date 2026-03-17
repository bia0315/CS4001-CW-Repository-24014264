import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Main GUI class for the gadget shop
public class GadgetShop extends JFrame implements ActionListener
{
    // Store gadgets in one list
    private ArrayList<Gadget> gadgets;

    // Input fields
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField extraField;          // minutes credit or memory
    private JTextField displayNumberField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField musicSizeField;

    // Buttons
    private JButton addMobileBtn;
    private JButton addMP3Btn;
    private JButton displayAllBtn;
    private JButton makeCallBtn;
    private JButton downloadMusicBtn;
    private JButton clearBtn;

    // Output area
    private JTextArea outputArea;

    // Constructor
    public GadgetShop()
    {
        gadgets = new ArrayList<Gadget>();

        setTitle("Gadget Shop");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));

        // Add space around the window
        ((JComponent) getContentPane()).setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // =========================
        // LEFT PANEL - FORM INPUTS
        // =========================
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Gadget Details"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        modelField = new JTextField(15);
        priceField = new JTextField(15);
        weightField = new JTextField(15);
        sizeField = new JTextField(15);
        extraField = new JTextField(15);
        displayNumberField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        durationField = new JTextField(15);
        musicSizeField = new JTextField(15);

        // Row 0
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        formPanel.add(modelField, gbc);

        // Row 1
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        formPanel.add(priceField, gbc);

        // Row 2
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Weight:"), gbc);
        gbc.gridx = 1;
        formPanel.add(weightField, gbc);

        // Row 3
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Size:"), gbc);
        gbc.gridx = 1;
        formPanel.add(sizeField, gbc);

        // Row 4
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Credit / Memory:"), gbc);
        gbc.gridx = 1;
        formPanel.add(extraField, gbc);

        // Row 5
        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(new JLabel("Display Number:"), gbc);
        gbc.gridx = 1;
        formPanel.add(displayNumberField, gbc);

        // Row 6
        gbc.gridx = 0; gbc.gridy = 6;
        formPanel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        formPanel.add(phoneNumberField, gbc);

        // Row 7
        gbc.gridx = 0; gbc.gridy = 7;
        formPanel.add(new JLabel("Call Duration:"), gbc);
        gbc.gridx = 1;
        formPanel.add(durationField, gbc);

        // Row 8
        gbc.gridx = 0; gbc.gridy = 8;
        formPanel.add(new JLabel("Music Size:"), gbc);
        gbc.gridx = 1;
        formPanel.add(musicSizeField, gbc);

        // =========================
        // RIGHT PANEL - BUTTONS + OUTPUT
        // =========================
        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        addMobileBtn = new JButton("Add Mobile");
        addMP3Btn = new JButton("Add MP3");
        displayAllBtn = new JButton("Display All");
        makeCallBtn = new JButton("Make Call");
        downloadMusicBtn = new JButton("Download Music");
        clearBtn = new JButton("Clear Fields");

        buttonPanel.add(addMobileBtn);
        buttonPanel.add(addMP3Btn);
        buttonPanel.add(displayAllBtn);
        buttonPanel.add(makeCallBtn);
        buttonPanel.add(downloadMusicBtn);
        buttonPanel.add(clearBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setMargin(new Insets(8, 8, 8, 8));
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        rightPanel.add(buttonPanel, BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // Add both main sections
        add(formPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Button listeners
        addMobileBtn.addActionListener(this);
        addMP3Btn.addActionListener(this);
        displayAllBtn.addActionListener(this);
        makeCallBtn.addActionListener(this);
        downloadMusicBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Runs when a button is clicked
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addMobileBtn)
        {
            addMobile();
        }
        else if (e.getSource() == addMP3Btn)
        {
            addMP3();
        }
        else if (e.getSource() == displayAllBtn)
        {
            displayAll();
        }
        else if (e.getSource() == makeCallBtn)
        {
            makeCall();
        }
        else if (e.getSource() == downloadMusicBtn)
        {
            downloadMusic();
        }
        else if (e.getSource() == clearBtn)
        {
            clearFields();
        }
    }

    // Add a mobile
    private void addMobile()
    {
        try
        {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(extraField.getText());

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);

            outputArea.append("Mobile added successfully.\n");
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Please enter valid Mobile values.");
        }
    }

    // Add an MP3
    private void addMP3()
    {
        try
        {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            double memory = Double.parseDouble(extraField.getText());

            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3);

            outputArea.append("MP3 added successfully.\n");
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Please enter valid MP3 values.");
        }
    }

    // Display all gadgets
    private void displayAll()
    {
        outputArea.setText("");

        if (gadgets.size() == 0)
        {
            outputArea.append("No gadgets stored.\n");
            return;
        }

        for (int i = 0; i < gadgets.size(); i++)
        {
            Gadget g = gadgets.get(i);

            outputArea.append("Display Number: " + i + "\n");
            outputArea.append("Model: " + g.getModel() + "\n");
            outputArea.append("Price: £" + g.getPrice() + "\n");
            outputArea.append("Weight: " + g.getWeight() + "g\n");
            outputArea.append("Size: " + g.getSize() + "\n");

            if (g instanceof Mobile)
            {
                Mobile m = (Mobile) g;
                outputArea.append("Type: Mobile\n");
                outputArea.append("Minutes Credit: " + m.getMinutesCredit() + "\n");
            }
            else if (g instanceof MP3)
            {
                MP3 mp3 = (MP3) g;
                outputArea.append("Type: MP3\n");
                outputArea.append("Available Memory: " + mp3.getAvailableMemory() + "\n");
            }

            outputArea.append("-----------------------------------\n");
        }
    }

    // Make a call
    private void makeCall()
    {
        int displayNumber = getDisplayNumber();

        if (displayNumber == -1)
        {
            return;
        }

        Gadget selected = gadgets.get(displayNumber);

        if (selected instanceof Mobile)
        {
            try
            {
                String phoneNumber = phoneNumberField.getText();
                int duration = Integer.parseInt(durationField.getText());

                Mobile mobile = (Mobile) selected;
                mobile.makeCall(phoneNumber, duration);

                outputArea.append("Call made on Mobile at display number " + displayNumber + ".\n");
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter a valid call duration.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Selected gadget is not a Mobile.");
        }
    }

    // Download music
    private void downloadMusic()
    {
        int displayNumber = getDisplayNumber();

        if (displayNumber == -1)
        {
            return;
        }

        Gadget selected = gadgets.get(displayNumber);

        if (selected instanceof MP3)
        {
            try
            {
                double musicSize = Double.parseDouble(musicSizeField.getText());

                MP3 mp3 = (MP3) selected;
                mp3.downloadMusic(musicSize);

                outputArea.append("Music downloaded on MP3 at display number " + displayNumber + ".\n");
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter a valid music size.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Selected gadget is not an MP3.");
        }
    }

    // Check if display number is valid
    private int getDisplayNumber()
    {
        int displayNumber = -1;

        try
        {
            displayNumber = Integer.parseInt(displayNumberField.getText());

            if (displayNumber < 0 || displayNumber >= gadgets.size())
            {
                JOptionPane.showMessageDialog(this, "Invalid display number.");
                return -1;
            }
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid display number.");
            return -1;
        }

        return displayNumber;
    }

    // Clear all fields
    private void clearFields()
    {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        extraField.setText("");
        displayNumberField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        musicSizeField.setText("");
        outputArea.setText("");
    }

    // Main method
    public static void main(String[] args)
    {
        new GadgetShop();
    }
}