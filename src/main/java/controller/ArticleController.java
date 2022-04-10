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
    public Article addArticle(@RequestBody Article a){
        return service.saveArticle(a);
    }

    @GetMapping("/article/{id}")
    public Article findArticleByIdArticle(@PathVariable UUID id){
        return service.getArticleByIdArticle(id);
    }

    @GetMapping("/article/{libelle}")
    public Article findArticleByLibelle(@PathVariable String libelle){
        return service.getArticleByLibelle(libelle);
    }

    @DeleteMapping("/article/{id}")
    public Article deleteArticleByIdArticle(@PathVariable UUID id){
        return service.getArticleByIdArticle(id);
    }

    @PutMapping("/article/{id}")
    public Article updateArticle(@RequestBody Article article){
        return service.updateArticle(article);
    }
}
