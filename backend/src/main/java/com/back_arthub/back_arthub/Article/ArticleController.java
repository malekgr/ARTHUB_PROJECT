package com.back_arthub.back_arthub.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Article")
public class ArticleController {
    private final ArticleService ArticleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.ArticleService = articleService;
    }

    @GetMapping(path = "/getArticles")
    public List<Article> getArticles(){
        return ArticleService.getArticles();
    }
    @PostMapping
    public void registerNewArticle(@RequestBody Article article){
        ArticleService.addNewArticle(article);
    }
    @DeleteMapping(path = "{articleid}")
    public void deleteArticle(@PathVariable("articleid") Long articleid){
        ArticleService.deleteArticle(articleid);
    }
}
