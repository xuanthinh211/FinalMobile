package eu.tutorials.fooduiapp.models;

public class CartModel {
    private int image;
    private String name;
    private String price;
    private String ratting;

    public CartModel(int image, String name, String price, String ratting) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.ratting = ratting;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRatting() {
        return ratting;
    }

    public void setRatting(String ratting) {
        this.ratting = ratting;
    }
}
