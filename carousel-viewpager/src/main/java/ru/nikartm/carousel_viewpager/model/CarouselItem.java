package ru.nikartm.carousel_viewpager.model;

/**
 * @author Ivan Vodyasov on 20.07.2017.
 */

public class CarouselItem {
    private int image;
    private String name;

    public CarouselItem(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

}
