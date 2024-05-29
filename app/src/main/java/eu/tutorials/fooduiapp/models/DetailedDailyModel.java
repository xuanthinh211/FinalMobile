package eu.tutorials.fooduiapp.models;

public class DetailedDailyModel {
    private int image;
    private String name;
    private String description;
    private String ratting;
    private String price;
    private String timing;

    public DetailedDailyModel(int image, String name, String description, String ratting, String price, String timing) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.ratting = ratting;
        this.price = price;
        this.timing = timing;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRatting() {
        return ratting;
    }

    public void setRatting(String ratting) {
        this.ratting = ratting;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
