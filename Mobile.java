// Mobile class extends Gadget
public class Mobile extends Gadget {

    private int minutesCredit;

    public Mobile(String model, double price, int weight, String size, int minutesCredit) {
        super(model, price, weight, size);
        this.minutesCredit = minutesCredit;
    }

    public int getMinutesCredit() {
        return minutesCredit;
    }

    // Add credit method
    public void addCredit(int amount) {
        if (amount > 0) {
            minutesCredit += amount;
        } else {
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    // Make call method
    public void makeCall(String phoneNumber, int duration) {
        if (duration <= minutesCredit) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            minutesCredit -= duration;
        } else {
            System.out.println("Insufficient credit to make this call.");
        }
    }

    // Override display
    public void display() {
        super.display();
        System.out.println("Minutes credit remaining: " + minutesCredit);
    }
}