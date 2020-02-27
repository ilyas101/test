package ru.karimov.sptnk.controler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import ru.karimov.sptnk.controler.resource.ClothesResource;
import ru.karimov.sptnk.model.Clothes;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * Created by ikarimov on 12.02.2020.
 */
@Component
public class ClothesResourceAssembler extends RepresentationModelAssemblerSupport<Clothes, ClothesResource> {

    public ClothesResourceAssembler() {
        super(ClothesController.class, ClothesResource.class);
    }

    @Override
    public ClothesResource toModel(Clothes clothes) {
        return createModelWithId(clothes.getId(), clothes);
    }

    @Override
    protected ClothesResource instantiateModel(Clothes entity) {
        return new ClothesResource(entity);
    }

    @Override
    public CollectionModel<ClothesResource> toCollectionModel(Iterable<? extends Clothes> entities) {
        CollectionModel<ClothesResource> clothesModels = super.toCollectionModel(entities);
        clothesModels.add(linkTo(methodOn(ClothesController.class).getAllClothes()).withSelfRel());
        return clothesModels;
    }
}
