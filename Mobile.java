// Mobile class extends Gadget
public class Mobile extends Gadget {

    private int minutes;
    private int texts;

    // Constructor
    public Mobile(int itemNumber, String brand, double price, int minutes, int texts) {
        super(itemNumber, brand, price); // Call parent constructor
        this.minutes = minutes;
        this.texts = texts;
    }

    // Method to make a call
    public String makeCall(int callMinutes) {
        if (callMinutes <= minutes) {
            minutes -= callMinutes;
            return "Call successful. Remaining minutes: " + minutes;
        } else {
            return "Not enough minutes.";
        }
    }

    // Override display method
    @Override
    public String displayInfo() {
        return super.displayInfo() +
               "\nType: Mobile" +
               "\nMinutes: " + minutes +
               "\nTexts: " + texts +
               "\n-----------------------";
    }
}