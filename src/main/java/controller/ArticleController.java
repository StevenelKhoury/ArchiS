package controller;

import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ArticleRepository;
import service.ArticleService;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins="http://localhost:5050")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService service;



    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @PostMapping("/article")
    public int addArticle(@RequestBody Article a){
        service.saveArticle(a);
        return 200;
    }

    @GetMapping("/article")
    public List<Article> listArticle() {
        return service.getAllArticle();
    }
    @GetMapping("/article/{id}")
    public Article findArticleByIdArticle(@PathVariable UUID id){
        return service.getArticle(id);
    }

    @GetMapping("/article/{libelle}")
    public Article findArticleByLibelle(@PathVariable String libelle){
        return service.getArticleByLibelle(libelle);
    } //voir avec guillaume la v2

    @DeleteMapping("/article/{id}")
    public int deleteArticleByIdArticle(@PathVariable UUID id){
        service.deleteByIdArticle(id);
        return 200;
    }

    @PutMapping("/article/{id}")
    public void updateArticle(@RequestBody Article article, @PathVariable UUID id){
        service.updateArticle(article);
    }
}
