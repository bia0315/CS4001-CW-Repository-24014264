import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Main class for the Gadget Shop GUI
public class GadgetShop extends JFrame implements ActionListener
{
    // ArrayList to store all gadgets (polymorphism)
    private ArrayList<Gadget> gadgets;

    // Text fields for user input
    private JTextField modelField, priceField, weightField, sizeField;
    private JTextField creditField, phoneField, memoryField, songField, displayField;

    // Buttons
    private JButton addMobileBtn, addMP3Btn, displayBtn;
    private JButton callBtn, downloadBtn, deleteBtn, addCreditBtn, clearBtn;

    // Constructor (runs when program starts)
    public GadgetShop()
    {
        gadgets = new ArrayList<>();

        // Set up window
        setTitle("Gadget Shop");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout (clean structure)
        setLayout(new BorderLayout(10,10));

        // ==========================
        // INPUT PANEL (TOP)
        // ==========================
        JPanel inputPanel = new JPanel(new GridLayout(5,4,10,10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Details"));

        // Add labels + text fields (clean pairs)
        inputPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        inputPanel.add(modelField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Weight:"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Size:"));
        sizeField = new JTextField();
        inputPanel.add(sizeField);

        inputPanel.add(new JLabel("Credit:"));
        creditField = new JTextField();
        inputPanel.add(creditField);

        inputPanel.add(new JLabel("Phone No:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Memory Size:"));
        memoryField = new JTextField();
        inputPanel.add(memoryField);

        inputPanel.add(new JLabel("Song Name:"));
        songField = new JTextField();
        inputPanel.add(songField);

        inputPanel.add(new JLabel("Display Index:"));
        displayField = new JTextField();
        inputPanel.add(displayField);

        add(inputPanel, BorderLayout.NORTH);

        // ==========================
        // BUTTON PANEL (CENTER)
        // ==========================
        JPanel buttonPanel = new JPanel(new GridLayout(3,3,10,10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        // Create buttons
        addMobileBtn = new JButton("Add Mobile");
        addMP3Btn = new JButton("Add MP3");
        displayBtn = new JButton("Display");

        callBtn = new JButton("Make Call");
        downloadBtn = new JButton("Download");
        deleteBtn = new JButton("Delete Song");

        addCreditBtn = new JButton("Add Credit");
        clearBtn = new JButton("Clear Fields");

        // Add buttons to panel
        buttonPanel.add(addMobileBtn);
        buttonPanel.add(addMP3Btn);
        buttonPanel.add(displayBtn);

        buttonPanel.add(callBtn);
        buttonPanel.add(downloadBtn);
        buttonPanel.add(deleteBtn);

        buttonPanel.add(addCreditBtn);
        buttonPanel.add(clearBtn);

        add(buttonPanel, BorderLayout.CENTER);

        // Add listeners (connect buttons to actions)
        addMobileBtn.addActionListener(this);
        addMP3Btn.addActionListener(this);
        displayBtn.addActionListener(this);
        callBtn.addActionListener(this);
        downloadBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        addCreditBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setLocationRelativeTo(null); // center window
        setVisible(true);
    }

    // ==========================
    // BUTTON ACTIONS
    // ==========================
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            // ADD MOBILE
            if(e.getSource() == addMobileBtn)
            {
                String model = modelField.getText();
                int price = Integer.parseInt(priceField.getText());
                int weight = Integer.parseInt(weightField.getText());
                int size = Integer.parseInt(sizeField.getText());
                int credit = Integer.parseInt(creditField.getText());
                String phone = phoneField.getText();

                gadgets.add(new Mobile(model, price, weight, size, credit, phone));

                JOptionPane.showMessageDialog(this, "Mobile added!");
            }

            // ADD MP3
            if(e.getSource() == addMP3Btn)
            {
                String model = modelField.getText();
                int price = Integer.parseInt(priceField.getText());
                int weight = Integer.parseInt(weightField.getText());
                int size = Integer.parseInt(sizeField.getText());
                int memory = Integer.parseInt(memoryField.getText());

                gadgets.add(new MP3(model, price, weight, size, memory));

                JOptionPane.showMessageDialog(this, "MP3 added!");
            }

            // DISPLAY
            if(e.getSource() == displayBtn)
            {
                int index = Integer.parseInt(displayField.getText());

                if(index >= 0 && index < gadgets.size())
                {
                    gadgets.get(index).display();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Invalid index!");
                }
            }

            // MAKE CALL
            if(e.getSource() == callBtn)
            {
                int index = Integer.parseInt(displayField.getText());

                if(gadgets.get(index) instanceof Mobile)
                {
                    ((Mobile)gadgets.get(index)).makeCall();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Not a Mobile!");
                }
            }

            // DOWNLOAD MUSIC
            if(e.getSource() == downloadBtn)
            {
                int index = Integer.parseInt(displayField.getText());
                String song = songField.getText();

                if(gadgets.get(index) instanceof MP3)
                {
                    ((MP3)gadgets.get(index)).downloadMusic(song);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Not an MP3!");
                }
            }

            // DELETE MUSIC
            if(e.getSource() == deleteBtn)
            {
                int index = Integer.parseInt(displayField.getText());

                if(gadgets.get(index) instanceof MP3)
                {
                    ((MP3)gadgets.get(index)).deleteMusic();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Not an MP3!");
                }
            }

            // ADD CREDIT
            if(e.getSource() == addCreditBtn)
            {
                int index = Integer.parseInt(displayField.getText());
                int credit = Integer.parseInt(creditField.getText());

                if(gadgets.get(index) instanceof Mobile)
                {
                    ((Mobile)gadgets.get(index)).addCredit(credit);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Not a Mobile!");
                }
            }

            // CLEAR FIELDS
            if(e.getSource() == clearBtn)
            {
                modelField.setText("");
                priceField.setText("");
                weightField.setText("");
                sizeField.setText("");
                creditField.setText("");
                phoneField.setText("");
                memoryField.setText("");
                songField.setText("");
                displayField.setText("");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Main method (starts program)
    public static void main(String[] args)
    {
        new GadgetShop();
    }
}