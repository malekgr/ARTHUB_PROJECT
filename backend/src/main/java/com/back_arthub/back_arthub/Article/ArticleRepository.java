package com.back_arthub.back_arthub.Article;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends
        JpaRepository<Article, Long> {
    Optional<Article> findArticleBytitle(String Title);
}
