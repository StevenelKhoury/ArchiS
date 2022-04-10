package service;

import model.Boutique;
import model.Ccategory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BoutiqueRepository;
import repository.CategoryRepository;

import java.util.UUID;

public class CategoryService {
    private CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
    public Ccategory saveCategory(Ccategory category){
        return repository.save(category);
    }
    public Ccategory getById(UUID id){
        return repository.findById(id);
    }

    public Ccategory getCategoryByLibelle(String name){
        return repository.findByLibelle(name);
    }
         public Ccategory updateCategory(Ccategory category){
             Ccategory existingCategory= repository.findById(category.getId());
             existingCategory.setId(category.getId());
             existingCategory.setLibelle(category.getLibelle());
             return repository.save(existingCategory);
         }


    }
