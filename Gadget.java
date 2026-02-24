// Parent class for all gadgets
public class Gadget {

    // Common attributes shared by all gadgets
    protected String model;
    protected double price;
    protected int weight;

    // Constructor to set values
    public Gadget(String model, double price, int weight) {
        this.model = model;
        this.price = price;
        this.weight = weight;
    }

    // Getter methods
    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    // Method to display basic gadget info
    public String displayInfo() {
        return "Model: " + model +
               "\nPrice: " + price +
               "\nWeight: " + weight;
    }
}