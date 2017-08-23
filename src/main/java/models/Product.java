package models;

public class Product {
    private String productName;
    private float price;
    private String description;

    public Product(String productName, float price, String description){
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Float.compare(product.price, price) != 0) return false;
        if (!productName.equals(product.productName)) return false;
        return description.equals(product.description);
    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + description.hashCode();
        return result;
    }
}
