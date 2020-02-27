package ru.karimov.sptnk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.karimov.sptnk.model.Clothes;
import ru.karimov.sptnk.repository.IClothesRepository;

import java.util.List;

/**
 * Created by ikarimov on 03.02.2020.
 */
@Service
public class ClothesService implements IClothesService {

    @Autowired
    private IClothesRepository clothesRepository;

    @Override
    public Clothes getClothesById(long id) {
        return clothesRepository.getClothesById(id);
    }

    @Override
    public Clothes addClothes(Clothes clothes) {
        return clothesRepository.addClothes(clothes);
    }

    @Override
    public Clothes updateClothes(Clothes clothes) {
        return clothesRepository.updateClothes(clothes);
    }

    @Override
    public void deleteClothes(long id) {
        clothesRepository.deleteClothes(id);
    }

    @Override
    public List<Clothes> getAllClothes() {
        return clothesRepository.getAllClothes();
    }
}

