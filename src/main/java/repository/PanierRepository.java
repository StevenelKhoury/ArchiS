package repository;

import model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Integer>, CrudRepository<Panier, Integer> {

    Panier findById(UUID id);

    Panier findByUtilisateur(Utilisateur user);


    public List<Article> getArticles(UUID id);

    public void removeArticle(UUID id);

}
