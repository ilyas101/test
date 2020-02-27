package ru.karimov.sptnk.model;

/**
 * Created by ikarimov on 03.02.2020.
 */
public enum Kind {
    DRESS("платье"),
    PANTS("брюки"),
    SKIRT("юбка"),
    VEST("жилетка"),
    SHIRT("рубашка");

    Kind(String Kind) {
        this.kind = kind;
    }

    private String kind;

    @Override
    public String toString() {
        return kind;
    }
}
