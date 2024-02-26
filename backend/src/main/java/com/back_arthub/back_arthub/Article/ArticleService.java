package com.back_arthub.back_arthub.Article;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticles(){return articleRepository.findAll();
    }

    public void addNewArticle(Article article) {
        Optional<Article> ArticleByEmail = articleRepository.findArticleBytitle(article.getTitle());
        if(ArticleByEmail.isPresent()){
            throw new IllegalStateException("title taken");
        }
        articleRepository.save(article);
    }

    public void deleteArticle(Long ArticleId) {

        boolean exists = articleRepository.existsById(ArticleId);
        if (!exists){
            throw new IllegalStateException("No id exist");
        }
        articleRepository.deleteById(ArticleId);
    }
}
