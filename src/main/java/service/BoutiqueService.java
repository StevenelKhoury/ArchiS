package service;

import lombok.NoArgsConstructor;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class BoutiqueService {
    private BoutiqueRepository repository;

    private List<Boutique> boutiques;

    @Autowired
    public BoutiqueService(BoutiqueRepository repository) {
        this.repository = repository;
    }
    public Boutique saveBoutique(Boutique boutique){
        return repository.save(boutique);
    }
    public Boutique getBoutiqueById(UUID id){
        return repository.findById(id);
    }

    public Boutique getBoutique(UUID id) { return boutiques.stream().filter(t -> t.getId().equals(id)).findFirst().get();}

    public Boutique getBoutiqueByName(String name){
        return repository.findByName(name);
    }

    public Boutique updateBoutique(Boutique boutique){
        Boutique existingBoutique= repository.findById(boutique.getId());
        existingBoutique.setBoutique_description(boutique.getBoutique_description());
        existingBoutique.setAdress(boutique.getAdress());
        existingBoutique.setArticles(boutique.getArticles());
        existingBoutique.setContact(boutique.getContact());
        return repository.save(existingBoutique);
    }
}
