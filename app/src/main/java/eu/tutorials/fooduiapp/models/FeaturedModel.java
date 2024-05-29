package eu.tutorials.fooduiapp.models;

public class FeaturedModel {
    private int image;
    private String name;
    private String des;

    public FeaturedModel(int image, String name, String des) {
        this.image = image;
        this.name = name;
        this.des = des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
