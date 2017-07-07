package ru.nikartm.drag_and_drop.model;

/**
 * @author Ivan Vodyasov on 07.07.2017.
 */

public class DragItem {
    private int image;
    private String name;
    private String description;

    public DragItem(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
