package ru.karimov.sptnk.service;

import ru.karimov.sptnk.model.Clothes;

import java.util.List;

/**
 * Created by ikarimov on 03.02.2020.
 */
public interface IClothesService {
    Clothes getClothesById(long id);
    Clothes addClothes(Clothes clothes);
    Clothes updateClothes(Clothes clothes);
    void deleteClothes(long id);
    List<Clothes> getAllClothes();
}
