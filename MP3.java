// MP3 class extends Gadget
public class MP3 extends Gadget {

    private double availableMemory;

    public MP3(String model, double price, int weight, String size, double availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public double getAvailableMemory() {
        return availableMemory;
    }

    // Download music
    public void downloadMusic(double size) {
        if (size <= availableMemory) {
            availableMemory -= size;
            System.out.println("Music downloaded. Remaining memory: " + availableMemory);
        } else {
            System.out.println("Not enough memory.");
        }
    }

    // Delete music
    public void deleteMusic(double size) {
        availableMemory += size;
        System.out.println("Music deleted. Available memory: " + availableMemory);
    }

    // Override display
    public void display() {
        super.display();
        System.out.println("Available memory: " + availableMemory + "GB");
    }
}