public class Product {
    public int ProductID;
    public String name;
    protected double price;
    protected int stock;

    public Product() {
        ProductID = 0;
        name = "abc";
        price = 0.0;
        stock = 0;
    }

    public Product(int ProductID, String name, double price, int stock) {
        this.ProductID = ProductID;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void DisplayProductInfo() {
        System.out.println("Product Name: " + name + " | " + "Product ID: " + ProductID + " | " + "Price: " + price + " | " + "Available: " + stock);
    }

    public int ChangePrice(int NewPrice) {
        price = NewPrice;
        return NewPrice;
    }

    public int ChangeStock(int NewStock) {
        stock = NewStock;
        return NewStock;
    }

    public void decreaseStock(int quantity) {
        if (stock >= quantity)
            stock -= quantity;
    }

}
