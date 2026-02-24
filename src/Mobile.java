// Mobile class inherits from Gadget
public class Mobile extends Gadget {

    private String size;
    private int credit;

    // Constructor
    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight);  // Call parent constructor
        this.size = size;
        this.credit = credit;
    }

    // Method to add credit
    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
        }
    }

    // Override display method
    @Override
    public String displayInfo() {
        return super.displayInfo() +
               "\nSize: " + size +
               "\nCredit: " + credit +
               "\n-------------------";
    }
}