package service;

import lombok.NoArgsConstructor;
import model.Ccategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CcategoryRepository;

import java.util.UUID;

@Service
@NoArgsConstructor
public class CcategoryService {
    private CcategoryRepository repository;

    @Autowired
    public CcategoryService(CcategoryRepository repository) {
        this.repository = repository;
    }
    public Ccategory saveCcategory(Ccategory category){
        return repository.save(category);
    }
    public Ccategory findById(UUID id){
        return repository.findById(id);
    }

    public Ccategory getLibelle(String name){
        return repository.findByLibelle(name);
    }

    public Ccategory updateCategory(Ccategory ccategory){
        Ccategory existingCategory= repository.findById(ccategory.getId());
        existingCategory.setLibelle(ccategory.getLibelle());
        return repository.save(existingCategory);
    }
}
