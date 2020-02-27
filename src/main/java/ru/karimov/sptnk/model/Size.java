package ru.karimov.sptnk.model;

/**
 * Created by ikarimov on 13.02.2020.
 */
public enum Size {
    SIZE_42(42),
    SIZE_44(44),
    SIZE_46(46),
    SIZE_48(48),
    SIZE_50(50),
    SIZE_52(52),
    SIZE_54(54);

    Size(int size) {
        this.size = size;
    }

    private int size;

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
