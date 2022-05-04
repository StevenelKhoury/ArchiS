package controller;

import model.Boutique;
import model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BoutiqueService;

import java.util.UUID;


@CrossOrigin(origins="http://localhost:5050")
@RestController
public class BoutiqueController {

    @Autowired
    private BoutiqueService service;

    public BoutiqueController(BoutiqueService service) {
        this.service = service;
    }

    @PostMapping("/boutique")
    public Boutique addBoutique(@RequestBody Boutique a){
        return service.saveBoutique(a);
    }

    @GetMapping("/boutique/{id}")
    public Boutique findById(@PathVariable UUID id){
        return service.getBoutique(id);
    }

    @GetMapping("/boutique/{name}")
    public Boutique getBoutiqueByName(@PathVariable String name){
        return service.getBoutiqueByName(name);
    }

    @PutMapping("/boutique/{id}")
    public Boutique updatePanier(@RequestBody Boutique boutique) {
        return service.updateBoutique(boutique);
    }


}
