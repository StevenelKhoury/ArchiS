package service;


import lombok.NoArgsConstructor;
import model.Article;
import model.Panier;
import model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PanierRepository;

import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class PanierService {

    private PanierRepository repository;

    @Autowired
    public PanierService(PanierRepository repository) {
        this.repository = repository;
    }

    public List<Article> getArticles(UUID id){
        return repository.getArticles(id);
    }

    public Panier findByUtilisateur(Utilisateur user){
        return repository.findByUtilisateur(user);
    }

    public Panier savePanier(Panier panier){
        return repository.save(panier);
    }
    public Panier findById(UUID id){
        return repository.findById(id);
    }

    public Panier updatePanier(Panier panier){
        Panier existingPanier = repository.findById(panier.getId());
        existingPanier.setArticles(panier.getArticles());
        return repository.save(existingPanier);
    }

    public void removeArticle(Panier panier){
        Panier existingPanier = repository.findById(panier.getId());
    }

}
