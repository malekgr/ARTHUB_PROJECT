package com.back_arthub.back_arthub;

import com.back_arthub.back_arthub.Article.Article;
import com.back_arthub.back_arthub.Article.ArticleRepository;
import com.back_arthub.back_arthub.Artiste.Artiste;
import com.back_arthub.back_arthub.Artiste.ArtisteRepository;
import com.back_arthub.back_arthub.Gallery.Gallery;
import com.back_arthub.back_arthub.Gallery.GalleryRepository;
import com.back_arthub.back_arthub.SpaceOwner.SpaceOwner;
import com.back_arthub.back_arthub.SpaceOwner.SpaceOwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class Config {
    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(
            SpaceOwnerRepository spaceOwnerRepository,
            GalleryRepository galleryRepository,
            ArticleRepository repository2,
            ArtisteRepository repository3
    ){
        return args -> {
            SpaceOwner owner1 = new SpaceOwner(
                    "malek",
                    Set.of(new Gallery())
            );

//            Gallery gallery1 = new Gallery(
//                    "paint1",
//                    "Tunis",
//                    "first edition",
//                    Arrays.asList("article1", "article2")
//            );
//            Gallery gallery2 = new Gallery(
//                    "paint2",
//                    "Nabeul",
//                    "second edition",
//                    Arrays.asList("article1", "article2")
//            );
//            HashSet<Gallery> hashset = new HashSet<>();
//            hashset.add(gallery1);
//            hashset.add(gallery2);
//            owner1.setGalleries(hashset);
            spaceOwnerRepository.saveAll(
                    List.of(owner1)
            );
//            galleryRepository.saveAll(
//                    List.of(gallery1, gallery2)
//            );
            Article article3 = new Article(
                    "naturenoire",
                    "steven bo",
                    "30 x 20cm",
                    "1500$",
                    "tableau de 1904,tableau artistique",
                    3,
                    "assests/gallery-1.jpg"
            );
            Article article4 = new Article(
                    "LA JOIE",
                    "william jo",
                    "30 x 20cm",
                    "2000$",
                    "tableau du bon vieux temps",
                    5,
                    "assests/gallery-1.jpg"
            );
            repository2.saveAll(
                    List.of(article3, article4)
            );
            Artiste article5 = new Artiste(
                    2L,
                    "picasso",
                    "picasso@gmail.com",
                    "12345gg",
                    "artiste1995",
                    "link"
            );
            Artiste article6 = new Artiste(
                    3L,
                    "salem",
                    "salem@gmail.com",
                    "1456",
                    "ar2015",
                    "link1"

            );
            repository3.saveAll(
                    List.of(article5, article6)
            );

        };
    }
}
