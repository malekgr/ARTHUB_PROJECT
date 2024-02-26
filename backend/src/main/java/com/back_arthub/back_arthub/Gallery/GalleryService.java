package com.back_arthub.back_arthub.Gallery;

import com.back_arthub.back_arthub.Article.ArticleRepository;
import com.back_arthub.back_arthub.Article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;
    @Autowired
    private  ArticleRepository articleRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public List<Gallery> getGalleries(){
        return galleryRepository.findAll();
    }

    public void addNewGallery(Gallery gallery) {
        Optional<Gallery> galleryByEmail = galleryRepository.findGalleryByLocation(gallery.getLocation());
        if(galleryByEmail.isPresent()){
            throw new IllegalStateException("location taken");
        }
        galleryRepository.save(gallery);
    }

    public void deleteGallery(Long galleryId) {
        boolean exists = galleryRepository.existsById(galleryId);
        if (!exists){
            throw new IllegalStateException("No Id exist");
        }
        galleryRepository.deleteById(galleryId);
    }

    public Gallery assignedArticleToGallery(Long galleryid, Long articleid) {
        Set<Article> ArticleSet = null;
        Gallery gallery = galleryRepository.findById(galleryid).get();
        Article article = articleRepository.findById(articleid).get();
        ArticleSet = gallery.getAssignedArticles();
        ArticleSet.add(article);
        gallery.setAssignedArticles(ArticleSet);
        return galleryRepository.save(gallery);



    }
}
