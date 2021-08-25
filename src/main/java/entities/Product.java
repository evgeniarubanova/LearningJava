package entities;

public class Product {

    private String title;
    private String description;
    private int price;
    private String category;
    private int id;
    private int stockBalance;

    public Product(String title, String description, int price, String category, int stockBalance) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockBalance = stockBalance;
    }

    public Product(String title, String description, int price, String category, int stockBalance, int id) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockBalance = stockBalance;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", id=" + id +
                ", stockBalance=" + stockBalance +
                '}';
    }
}
