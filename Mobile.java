// Mobile is a subclass of Gadget.
// It inherits all common gadget information and adds mobile-specific behaviour.
public class Mobile extends Gadget
{
    // Stores the number of calling minutes available on the mobile.
    private int minutesCredit;

    // Constructor for the Mobile class.
    // The shared values are passed to the Gadget constructor using super().
    public Mobile(String model, double price, int weight, String size, int minutesCredit)
    {
        super(model, price, weight, size);
        this.minutesCredit = minutesCredit;
    }

    // Returns the remaining calling credit.
    public int getMinutesCredit()
    {
        return minutesCredit;
    }

    // Adds more calling credit to the phone.
    // Only positive values are accepted.
    public void addCredit(int amount)
    {
        if (amount > 0)
        {
            minutesCredit += amount;
        }
        else
        {
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    // Simulates making a phone call.
    // The call only goes ahead if enough credit is available.
    public void makeCall(String phoneNumber, int duration)
    {
        if (duration <= minutesCredit)
        {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            minutesCredit -= duration;
        }
        else
        {
            System.out.println("Insufficient credit to make this call.");
        }
    }

    // Overrides the display method from Gadget.
    // First it shows the shared gadget details, then the remaining credit.
    public void display()
    {
        super.display();
        System.out.println("Minutes credit remaining: " + minutesCredit);
    }
}