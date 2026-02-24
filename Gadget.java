// Parent class for all gadgets
public class Gadget {

    // Common variables for all gadgets
    protected int itemNumber;
    protected String brand;
    protected double price;

    // Constructor
    public Gadget(int itemNumber, String brand, double price) {
        this.itemNumber = itemNumber;
        this.brand = brand;
        this.price = price;
    }

    // Getter methods
    public int getItemNumber() {
        return itemNumber;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    // Method to display basic information
    public String displayInfo() {
        return "Item Number: " + itemNumber +
               "\nBrand: " + brand +
               "\nPrice: £" + price;
    }
}