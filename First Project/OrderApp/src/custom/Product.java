package custom;

public class Product {
    // Create characteristics that our Product will need to have
    private String name;
    private int quantity = 0;
    private double price;
    private double totalPrice = Double.parseDouble(String.format("%.2f", 0.000));

    // Add constructor
    public Product(String name, double price) {
        /*
            Construct is only with two of the variables we have in the class because the others must be with the default
            zero, so that there are no errors in the calculation
        */
        this.name = name;
        this.price = Double.parseDouble(String.format("%.2f", price));
    }

    // Create getters and setters
    public String getName() {
        return name;
    }

    public void editName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void editQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void editPrice(double price) {
        this.price = Double.parseDouble(String.format("%.2f", price));
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = Double.parseDouble(String.format("%.2f", totalPrice));
    }

    // A method that returns us an array of objects because the DefaultTableModel requires it
    public Object[] toTable() {
        return new Object[]{
                this, name, quantity, price, "$ " + totalPrice
        };
    }
}
