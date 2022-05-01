package controller;

import model.Article;
import model.Panier;
import model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ArticleService;
import service.PanierService;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins="http://localhost:5050")
@RestController
public class PanierController {

    @Autowired
    private PanierService service;

    public PanierController(PanierService service) {
        this.service = service;
    }

    @PostMapping("/panier")
    public Panier addPanier(@RequestBody Panier a){
        return service.savePanier(a);
    }

    @GetMapping("/panier/{id}")
    public Panier findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @GetMapping("/panier/{user}")
    public Panier findByUser(@PathVariable Utilisateur user){
        return service.findByUtilisateur(user);
    }

    @DeleteMapping("/panier/{panier}")
    public void removeArticles(@PathVariable Panier panier){
        service.removeArticle(panier);
    }

    @PutMapping("/article/{id}")
    public Panier updatePanier(@RequestBody Panier panier) {
        return service.updatePanier(panier);
    }
}
