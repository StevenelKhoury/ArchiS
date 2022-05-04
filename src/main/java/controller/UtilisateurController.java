package controller;

import model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BoutiqueService;
import service.UtilisateurService;

@CrossOrigin(origins="http://localhost:5050")
@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        return service.saveUtilisateur(utilisateur);
    }

}
