package com.back_arthub.back_arthub.Article;

import com.back_arthub.back_arthub.Artiste.Artiste;
import com.back_arthub.back_arthub.Gallery.Gallery;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Article")
public class Article{

        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY

        )
        private Long id;

        private String title;
        private String artiste;
        private String dimension;
        private String price;
        private String description;
        private Integer stock;
        private String imgurl;
        @JsonIgnore
        @ManyToMany(mappedBy = "assignedArticles")
        private Set<Gallery> galleries = new HashSet<>();

        @JsonIgnore
        @ManyToMany(mappedBy = "assignedArticles")
        private Set<Artiste> artistes = new HashSet<>();





        public Article() {
        }

        public Article(String title, String artiste, String dimension, String price, String description,Integer stock,String imgurl) {
            this.title = title;
            this.artiste = artiste;
            this.price = price;
            this.description = description;
            this.dimension=dimension;
            this.stock=stock;
            this.imgurl=imgurl;
        }

//        public Article(String title, String artiste, String price, String description) {
//            this.title = title;
//            this.artiste = artiste;
//            this.price = price;
//            this.description = description;
//        }



    @Override
        public String toString() {
            return "Article{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", artiste='" + artiste + '\'' +
                    ", dimension='" + dimension + '\'' +
                    ", price='" + price + '\'' +
                    ", description=" + description + '\'' +
                    ", stock=" + stock + '\'' +
                    ", imgurl=" + imgurl +
                    '}';
        }



}


