// MP3 class extends Gadget
public class MP3 extends Gadget {

    private double memorySize;   // Total memory
    private double memoryUsed;   // Used memory

    // Constructor
    public MP3(int itemNumber, String brand, double price, double memorySize) {
        super(itemNumber, brand, price);
        this.memorySize = memorySize;
        this.memoryUsed = 0;
    }

    // Method to download music
    public String download(double size) {
        if (memoryUsed + size <= memorySize) {
            memoryUsed += size;
            return "Download successful. Used memory: " + memoryUsed + "GB";
        } else {
            return "Not enough memory.";
        }
    }

    // Override display method
    @Override
    public String displayInfo() {
        return super.displayInfo() +
               "\nType: MP3 Player" +
               "\nTotal Memory: " + memorySize + "GB" +
               "\nUsed Memory: " + memoryUsed + "GB" +
               "\n-----------------------";
    }
}