package ru.karimov.sptnk.model;

/**
 * Created by ikarimov on 03.02.2020.
 */
public enum Location {
    SHOP("магазин"),
    WAREHOUSE("склад");

    Location(String location) {
        this.location = location;
    }

    private String location;

    @Override
    public String toString() {
        return location;
    }
}
