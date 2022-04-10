package service;

import model.Ccategory;
import model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CategoryRepository;
import repository.PanierRepository;

import java.util.UUID;

public class PanierService {
    private PanierRepository repository;

    @Autowired
    public PanierService(PanierRepository repository) {
        this.repository = repository;
    }
    public Panier savePanier(Panier panier){
        return repository.save(panier);
    }
    public Panier getById(UUID id){
        return repository.findById(id);
    }
}
