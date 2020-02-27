package ru.karimov.sptnk.model;

import java.math.BigDecimal;

/**
 * Created by ikarimov on 03.02.2020.
 */
public class Clothes {
    private long id;
    private Size size;
    private Color color;
    private Kind kind;
    private Location location;
    private BigDecimal price;
    private String desc;

    public Clothes() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Clothes(int id, Size size, Color color, Kind kind, Location location, BigDecimal price, String desc) {

        this.id = id;
        this.size = size;
        this.color = color;
        this.kind = kind;
        this.location = location;
        this.price = price;
        this.desc = desc;
    }
}

