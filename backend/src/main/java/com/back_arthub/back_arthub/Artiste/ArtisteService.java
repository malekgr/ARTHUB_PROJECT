package com.back_arthub.back_arthub.Artiste;

import com.back_arthub.back_arthub.Article.Article;
import com.back_arthub.back_arthub.Article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArtisteService {
    private final ArtisteRepository artisteRepository;
    @Autowired
    private ArticleRepository articleRepository;
    public ArtisteService(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    public List<Artiste> getArtistes(){return artisteRepository.findAll();
    }

    public void addNewArtiste(Artiste artiste) {
        Optional<Artiste> ArtisteByEmail = artisteRepository.findArtisteById(artiste.getId());
        if(ArtisteByEmail.isPresent()){
            throw new IllegalStateException("id taken");
        }
        artisteRepository.save(artiste);
    }

    public void deleteArtiste(Long ArtisteId) {

        boolean exists = artisteRepository.existsById(ArtisteId);
        if (!exists){
            throw new IllegalStateException("No id exist");
        }
        artisteRepository.deleteById(ArtisteId);
    }
    public Artiste assignedArticleToArtiste(Long artisteid, Long articleid) {
        Set<Article> ArticleSet = null;
        Artiste artiste = artisteRepository.findById(artisteid).get();
        Article article = articleRepository.findById(articleid).get();
        ArticleSet = artiste.getAssignedArticles();
        ArticleSet.add(article);
        artiste.setAssignedArticles(ArticleSet);
        return artisteRepository.save(artiste);



    }
}
