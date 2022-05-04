package repository;

import model.Article;
import model.Boutique;
import model.TypeUser;
import model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>, CrudRepository<Utilisateur, Integer> {
    Utilisateur findByName(String name);

    Utilisateur findById(UUID id);

    void deleteUtilisateursById(UUID id);
}
