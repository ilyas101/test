package ru.karimov.sptnk.controler.resource;

import org.springframework.hateoas.RepresentationModel;
import ru.karimov.sptnk.model.Clothes;
import ru.karimov.sptnk.model.Color;
import ru.karimov.sptnk.model.Kind;
import ru.karimov.sptnk.model.Location;
import ru.karimov.sptnk.model.Size;

import java.math.BigDecimal;

/**
 * Created by ikarimov on 13.02.2020.
 */
public class ClothesResource extends RepresentationModel<ClothesResource> {
    private Size size;
    private Color color;
    private Kind kind;
    private Location location;
    private BigDecimal price;
    private String desc;

    public ClothesResource(Clothes clothes) {
        this.color = clothes.getColor();
        this.desc = clothes.getDesc();
        this.kind = clothes.getKind();
        this.size = clothes.getSize();
        this.location = clothes.getLocation();
        this.price = clothes.getPrice();
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
}
