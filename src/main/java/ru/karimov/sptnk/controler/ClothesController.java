package ru.karimov.sptnk.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.karimov.sptnk.controler.resource.ClothesResource;
import ru.karimov.sptnk.controler.resource.ClothesResource;
import ru.karimov.sptnk.exception.ResourceNotFoundException;
import ru.karimov.sptnk.model.Clothes;
import ru.karimov.sptnk.service.IClothesService;

import java.util.List;

/**
 * Created by ikarimov on 03.02.2020.
 */
@RestController
@RequestMapping("api/clothes")
public class ClothesController {

    @Autowired
    private IClothesService clothesService;

    @Autowired
    private ClothesResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CollectionModel<ClothesResource>> getAllClothes() {
        List<Clothes> clothesList = clothesService.getAllClothes();
        if (clothesList.isEmpty()){
            throw new ResourceNotFoundException("Clothes not found");
        }
        return new ResponseEntity<>(assembler.toCollectionModel(clothesList), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClothesResource> getClothesById(@PathVariable long id) {
        verifyClothe(id);
        Clothes clothes = clothesService.getClothesById(id);
        return new ResponseEntity<>(assembler.toModel(clothes), HttpStatus.OK); //assembler.toModel(clothes);// new ResponseEntity<Clothes>(clothes, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ClothesResource> addClothes(@RequestBody Clothes clothes, ServletUriComponentsBuilder ucBuilder) {
        Clothes newClothes  = clothesService.addClothes(clothes);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClothes.getId()).toUri());
        return new ResponseEntity<>(assembler.toModel(clothes), headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<ClothesResource> updateClothes(@RequestBody Clothes clothes) {
        verifyClothe(clothes.getId());
        return new ResponseEntity<>(assembler.toModel(clothesService.updateClothes(clothes)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClothes(@PathVariable long id) {
        verifyClothe(id);
        clothesService.deleteClothes(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    protected void verifyClothe(long id) throws ResourceNotFoundException {
        Clothes clothes = clothesService.getClothesById(id);
        if(clothes == null) {
            throw new ResourceNotFoundException("clothes with id " + id + " not found");
        }
    }
}

