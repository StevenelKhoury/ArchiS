package service;

import lombok.NoArgsConstructor;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArticleRepository;

import java.util.UUID;

@Service
@NoArgsConstructor
public class ArticleService {
    private ArticleRepository repository;

    @Autowired
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public Article saveArticle(Article article){
        return repository.save(article);
    }

    public Article getArticleByIdArticle(UUID id){
        return repository.findByIdArticle(id);
    }

    public Article getArticleByLibelle(String libelle){
        return repository.findByLibelle(libelle);
    }

    public void deleteByIdArticle(UUID id){
        repository.deleteByIdArticle(id);
    }

    public Article updateArticle(Article article){
        Article existingArticle = repository.findByIdArticle(article.getIdArticle());
        existingArticle.setCategory(article.getCategory());
        existingArticle.setLibelle(article.getLibelle());
        existingArticle.setMarque(article.getMarque());
        existingArticle.setPrix(article.getPrix());
        existingArticle.setPhoto(article.getPhoto());
        return repository.save(existingArticle);
    }

}
