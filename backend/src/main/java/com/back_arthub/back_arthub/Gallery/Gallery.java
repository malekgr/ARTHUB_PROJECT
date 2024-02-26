package com.back_arthub.back_arthub.Gallery;

import com.back_arthub.back_arthub.Article.Article;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Gallery {
    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    private Long id;
    private String name;
    private String location;
    private String dimension;
    private String rentprice;
    private String imgurl;
    private String description;

    //private List<String> articlesEnVente;

    @ManyToMany
    @JoinTable(name = "Gallery_Article", joinColumns = @JoinColumn(name = "Gallery_id"),
            inverseJoinColumns = @JoinColumn(name = "Article_id"))

    private Set<Article> assignedArticles = new HashSet<>();



    public void setAssignedArticles(Set<Article> assignedArticles) {
        this.assignedArticles = assignedArticles;
    }




    public Gallery() {
    }

    public Gallery(Long id, String name, String location, String dimension, String rentprice, String imgurl,String description, List<String> articlesEnVente) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.dimension = dimension;
        this.rentprice = rentprice;
        this.imgurl = imgurl;
        this.description = description;
        //this.articlesEnVente = articlesEnVente;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String property) {
        this.dimension = property;
    }

    //public List<String> getArticlesEnVente() {
       // return articlesEnVente;
   // }

   // public void setArticlesEnVente(List<String> articlesEnVente) {
        //this.articlesEnVente = articlesEnVente;
   // }

    @Override
    public String toString() {
        return "Gallery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dimension='" + dimension + '\'' +
                ", rentprice='" + rentprice + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", description='" + description + '\'' +
               // ", articlesEnVente=" + articlesEnVente +
                '}';
    }


    public void setassignedArticles(Set<Article> articleSet) {

    }

    public Set<Article> getAssignedArticles() {
        return assignedArticles;
    }
}

