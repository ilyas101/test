package ru.karimov.sptnk.repository;

import org.springframework.stereotype.Service;
import ru.karimov.sptnk.model.Clothes;
import ru.karimov.sptnk.model.Color;
import ru.karimov.sptnk.model.Kind;
import ru.karimov.sptnk.model.Location;
import ru.karimov.sptnk.model.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ikarimov on 03.02.2020.
 */
@Service
public class ClothesRepository implements IClothesRepository {

    private Map<Long, Clothes> clothesMap = new HashMap<>();

    {
        clothesMap.put(1L, new Clothes(1, Size.SIZE_42, Color.BLACK, Kind.SHIRT, Location.SHOP, BigDecimal.valueOf(13), "qqq"));
        clothesMap.put(2L, new Clothes(2, Size.SIZE_52, Color.WHITE, Kind.SKIRT, Location.WAREHOUSE, BigDecimal.valueOf(23), "rr"));
        clothesMap.put(3L, new Clothes(3, Size.SIZE_46, Color.RED, Kind.VEST, Location.WAREHOUSE, BigDecimal.valueOf(15, 5), "ee"));
        clothesMap.put(4L, new Clothes(4, Size.SIZE_46, Color.BLUE, Kind.SHIRT, Location.WAREHOUSE, BigDecimal.valueOf(7), "qqq"));
    }

    @Override
    public Clothes getClothesById(long id) {
        return clothesMap.get(id);
    }

    @Override
    public Clothes addClothes(Clothes clothes) {
        clothes.setId(clothesMap.size()+1);
        clothesMap.put(clothes.getId(), clothes);
        return clothes;
    }

    @Override
    public Clothes updateClothes(Clothes clothes) {
        if (clothes.getId() <= 0)
            return null;
        clothesMap.put(clothes.getId(), clothes);
        return clothes;
    }

    @Override
    public void deleteClothes(long id) {
        clothesMap.remove(id);
    }

    @Override
    public List<Clothes> getAllClothes() {
        return new ArrayList<Clothes>(clothesMap.values());
    }
}
