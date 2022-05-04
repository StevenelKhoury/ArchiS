package service;

import lombok.NoArgsConstructor;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArticleRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class ArticleService {
    private ArticleRepository repository;

    private List<Article> articles;

    @Autowired
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public Article saveArticle(Article article){
        return repository.save(article);
    }

    public List<Article> getAllArticle(){ return repository.findAll();}

    public Article getArticleByIdArticle(UUID id){
        return repository.findByIdArticle(id);
    }

    public Article getArticleByLibelle(String libelle){
        return repository.findByLibelle(libelle);
    }

    public List<Article> getArticleByLibellev2(String libelle){
        return articles.stream().filter(t -> t.getLibelle().equals(libelle)).collect(Collectors.toList());
    }

    public void deleteByIdArticle(UUID id){
        repository.deleteByIdArticle(id);
    }

    public Article getArticle(UUID id){
        return articles.stream().filter(t -> t.getIdArticle().equals(id)).findFirst().get();
    }
    public void updateArticle(Article article){
        Article existingArticle = repository.findByIdArticle(article.getIdArticle());
        existingArticle.setCategory(article.getCategory());
        existingArticle.setLibelle(article.getLibelle());
        existingArticle.setMarque(article.getMarque());
        existingArticle.setPrix(article.getPrix());
        existingArticle.setPhoto(article.getPhoto());
        repository.save(existingArticle);
    }

    public void updateArticlev2(UUID id, Article article){
        for (int i=0; i< articles.size();i++ ){
            Article t = articles.get(i);
             if (t.getIdArticle().equals(id)){
                 articles.set(i,article);
             }
        }
    }

}
