import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Main GUI class for the gadget shop.
// This class creates the window, handles button clicks,
// and stores all gadget objects inside an ArrayList.
public class GadgetShop extends JFrame implements ActionListener
{
    // This ArrayList stores every gadget added by the user.
    // I use Gadget as the type so both Mobile and MP3 can be stored together.
    private ArrayList<Gadget> gadgets;

    // Text fields used to collect information from the user.
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField extraField;          // Used for minutes credit or available memory
    private JTextField displayNumberField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField musicSizeField;

    // Buttons used to trigger actions in the GUI.
    private JButton addMobileBtn;
    private JButton addMP3Btn;
    private JButton displayAllBtn;
    private JButton makeCallBtn;
    private JButton downloadMusicBtn;
    private JButton clearBtn;

    // Output area used to show messages and gadget details.
    private JTextArea outputArea;

    // Constructor for the GadgetShop class.
    // This sets up the full GUI when the program starts.
    public GadgetShop()
    {
        // Create the ArrayList that will hold all gadgets.
        gadgets = new ArrayList<Gadget>();

        // Basic window settings.
        setTitle("Gadget Shop");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));

        // Add padding around the edge of the main window
        // so the interface looks cleaner.
        ((JComponent) getContentPane()).setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // =========================
        // LEFT PANEL - FORM INPUTS
        // =========================

        // This panel holds all labels and text fields.
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Gadget Details"));

        // GridBagConstraints controls where each component is placed.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create all text fields used by the GUI.
        modelField = new JTextField(15);
        priceField = new JTextField(15);
        weightField = new JTextField(15);
        sizeField = new JTextField(15);
        extraField = new JTextField(15);
        displayNumberField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        durationField = new JTextField(15);
        musicSizeField = new JTextField(15);

        // Row 0 - model
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        formPanel.add(modelField, gbc);

        // Row 1 - price
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        formPanel.add(priceField, gbc);

        // Row 2 - weight
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Weight:"), gbc);
        gbc.gridx = 1;
        formPanel.add(weightField, gbc);

        // Row 3 - size
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Size:"), gbc);
        gbc.gridx = 1;
        formPanel.add(sizeField, gbc);

        // Row 4 - extra field for either mobile credit or MP3 memory
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Credit / Memory:"), gbc);
        gbc.gridx = 1;
        formPanel.add(extraField, gbc);

        // Row 5 - display number used to select a gadget from the list
        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(new JLabel("Display Number:"), gbc);
        gbc.gridx = 1;
        formPanel.add(displayNumberField, gbc);

        // Row 6 - phone number used when making a call
        gbc.gridx = 0; gbc.gridy = 6;
        formPanel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        formPanel.add(phoneNumberField, gbc);

        // Row 7 - call duration
        gbc.gridx = 0; gbc.gridy = 7;
        formPanel.add(new JLabel("Call Duration:"), gbc);
        gbc.gridx = 1;
        formPanel.add(durationField, gbc);

        // Row 8 - music size used for download action
        gbc.gridx = 0; gbc.gridy = 8;
        formPanel.add(new JLabel("Music Size:"), gbc);
        gbc.gridx = 1;
        formPanel.add(musicSizeField, gbc);

        // =========================
        // RIGHT PANEL - BUTTONS + OUTPUT
        // =========================

        // This panel contains the buttons at the top
        // and the output area below.
        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));

        // Panel to organise all action buttons neatly.
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        // Create buttons for each user action.
        addMobileBtn = new JButton("Add Mobile");
        addMP3Btn = new JButton("Add MP3");
        displayAllBtn = new JButton("Display All");
        makeCallBtn = new JButton("Make Call");
        downloadMusicBtn = new JButton("Download Music");
        clearBtn = new JButton("Clear Fields");

        // Add the buttons to the button panel.
        buttonPanel.add(addMobileBtn);
        buttonPanel.add(addMP3Btn);
        buttonPanel.add(displayAllBtn);
        buttonPanel.add(makeCallBtn);
        buttonPanel.add(downloadMusicBtn);
        buttonPanel.add(clearBtn);

        // Create the output area where results are displayed.
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setMargin(new Insets(8, 8, 8, 8));
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        // Put the output area inside a scroll pane.
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        // Add the button panel and output area to the right side.
        rightPanel.add(buttonPanel, BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // Add both main panels to the window.
        add(formPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Register this class as the listener for all button clicks.
        addMobileBtn.addActionListener(this);
        addMP3Btn.addActionListener(this);
        displayAllBtn.addActionListener(this);
        makeCallBtn.addActionListener(this);
        downloadMusicBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        // Centre the window on screen and make it visible.
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // This method runs automatically whenever a button is clicked.
    // It checks which button was pressed and then calls the matching method.
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

    // Reads input values from the GUI, creates a Mobile object,
    // and stores it in the ArrayList.
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
            // Shows an error if the user enters invalid numeric values.
            JOptionPane.showMessageDialog(this, "Please enter valid Mobile values.");
        }
    }

    // Reads input values from the GUI, creates an MP3 object,
    // and stores it in the ArrayList.
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
            // Shows an error if the user enters invalid numeric values.
            JOptionPane.showMessageDialog(this, "Please enter valid MP3 values.");
        }
    }

    // Displays all gadgets currently stored in the ArrayList.
    // Each gadget is shown with its display number (index).
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

            // Check the real object type so the correct extra details are shown.
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

    // Uses the selected display number to make a call on a Mobile object.
    private void makeCall()
    {
        int displayNumber = getDisplayNumber();

        // Stop immediately if the display number is invalid.
        if (displayNumber == -1)
        {
            return;
        }

        Gadget selected = gadgets.get(displayNumber);

        // Make sure the selected gadget is a Mobile before casting it.
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

    // Uses the selected display number to download music onto an MP3 object.
    private void downloadMusic()
    {
        int displayNumber = getDisplayNumber();

        // Stop if the display number entered is invalid.
        if (displayNumber == -1)
        {
            return;
        }

        Gadget selected = gadgets.get(displayNumber);

        // Make sure the selected gadget is an MP3 before casting it.
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

    // Validates the display number entered by the user.
    // Returns -1 if the input is invalid.
    private int getDisplayNumber()
    {
        int displayNumber = -1;

        try
        {
            displayNumber = Integer.parseInt(displayNumberField.getText());

            // Check that the number is within the valid ArrayList range.
            if (displayNumber < 0 || displayNumber >= gadgets.size())
            {
                JOptionPane.showMessageDialog(this, "Invalid display number.");
                return -1;
            }
        }
        catch (NumberFormatException ex)
        {
            // Show an error if the display number is not an integer.
            JOptionPane.showMessageDialog(this, "Please enter a valid display number.");
            return -1;
        }

        return displayNumber;
    }

    // Clears all text fields and also clears the output area.
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

    // Main method used to start the program.
    public static void main(String[] args)
    {
        new GadgetShop();
    }
}