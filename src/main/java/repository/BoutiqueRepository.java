package repository;

import model.Article;
import model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique,Integer>, CrudRepository<Boutique, Integer> {
    Boutique findByName(String name);

    Boutique findById(UUID id);

    public List<Article> getArticles();
    public String getContact();
    public String getAdress();
    public String getBoutique_description();
    public String getName();
    public UUID getId();

    }
