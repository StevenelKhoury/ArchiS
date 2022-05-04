package service;

import lombok.NoArgsConstructor;
import model.Article;
import model.Panier;
import model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UtilisateurRepository;

import java.util.UUID;

@Service
@NoArgsConstructor
public class UtilisateurService {

    private UtilisateurRepository repository;

    @Autowired
    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        return repository.save(utilisateur);
    }

    public Utilisateur findById(UUID id){
        return repository.findById(id);
    }

    public Utilisateur findByName(String name){
        return repository.findByName(name);
    }

    public void deleteById(UUID id) {
        repository.deleteUtilisateursById(id);
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur){
        Utilisateur existingUtilisateur = repository.findById(utilisateur.getId());
        existingUtilisateur.setName(utilisateur.getName());
        existingUtilisateur.setPassword(utilisateur.getPassword());
        existingUtilisateur.setTypeUser(utilisateur.getTypeUser());
        return repository.save(existingUtilisateur);
    }
}
