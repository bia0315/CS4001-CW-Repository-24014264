// MP3 is also a subclass of Gadget.
// It inherits the basic gadget information and adds memory-related behaviour.
public class MP3 extends Gadget
{
    // Stores the remaining memory available on the MP3 player.
    private double availableMemory;

    // Constructor for the MP3 class.
    // Shared gadget details are passed to the parent class constructor.
    public MP3(String model, double price, int weight, String size, double availableMemory)
    {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    // Returns the amount of available memory.
    public double getAvailableMemory()
    {
        return availableMemory;
    }

    // Simulates downloading music to the MP3 player.
    // Memory is only reduced if enough space is available.
    public void downloadMusic(double size)
    {
        if (size <= availableMemory)
        {
            availableMemory -= size;
            System.out.println("Music downloaded. Remaining memory: " + availableMemory);
        }
        else
        {
            System.out.println("Not enough memory.");
        }
    }

    // Simulates deleting music from the MP3 player.
    // This increases the available memory again.
    public void deleteMusic(double size)
    {
        availableMemory += size;
        System.out.println("Music deleted. Available memory: " + availableMemory);
    }

    // Overrides the display method from Gadget.
    // It first shows the normal gadget details, then the available memory.
    public void display()
    {
        super.display();
        System.out.println("Available memory: " + availableMemory + "GB");
    }
}
