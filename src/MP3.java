// MP3 class inherits from Gadget
public class MP3 extends Gadget {

    private int memorySize;

    // Constructor
    public MP3(String model, double price, int weight, int memorySize) {
        super(model, price, weight);
        this.memorySize = memorySize;
    }

    // Override display method
    @Override
    public String displayInfo() {
        return super.displayInfo() +
               "\nMemory Size: " + memorySize + "GB" +
               "\n-------------------";
    }
}