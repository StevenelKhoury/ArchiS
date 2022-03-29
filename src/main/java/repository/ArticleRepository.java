package repository;

import model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>, CrudRepository<Article, Integer> {
    Article findByLibelle(String name);

    Article findByIdArticle(UUID id);

    void deleteByIdArticle(UUID id);



}
