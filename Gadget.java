// Gadget is the parent class for the system.
// I use this class to store the information that every gadget should have.
public class Gadget
{
    // These fields are shared by both Mobile and MP3 objects.
    // They are private to protect the data properly.
    private String model;
    private double price;
    private int weight;
    private String size;

    // Constructor for the Gadget class.
    // This runs whenever a new Gadget (or subclass object) is created.
    public Gadget(String model, double price, int weight, String size)
    {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Returns the model of the gadget.
    public String getModel()
    {
        return model;
    }

    // Returns the price of the gadget.
    public double getPrice()
    {
        return price;
    }

    // Returns the weight of the gadget.
    public int getWeight()
    {
        return weight;
    }

    // Returns the size of the gadget.
    public String getSize()
    {
        return size;
    }

    // Displays the common gadget details.
    // This method is reused by the subclasses through inheritance.
    public void display()
    {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }
}