package com.back_arthub.back_arthub.Artiste;

import com.back_arthub.back_arthub.Article.Article;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artiste")
public class Artiste {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )

    private Long id;
    private String name;
    private String email;
    private String passwd;
    private String type;
    private String portflio;
    public Artiste() {
    }
    @ManyToMany
    @JoinTable(name = "Artiste_Article", joinColumns = @JoinColumn(name = "Artiste_id"),
            inverseJoinColumns = @JoinColumn(name = "Article_id"))

    private Set<Article> assignedArticles = new HashSet<>();

    public void setAssignedArticles(Set<Article> assignedArticles) {
        this.assignedArticles = assignedArticles;
    }



    public Artiste(Long id, String name, String email ,String passwd, String type, String potflio ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.type = type;
        this.portflio = potflio;
    }

    public Artiste(String name, String email, String passwd, String type, String portflio) {
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.type = type;
        this.portflio = portflio;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPortflio() {
        return portflio;
    }

    public void setPortflio(String portflio) {
        this.portflio = portflio;
    }

    @Override
    public String toString() {
        return "Artiste{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", type='" + type + '\'' +
                ", portflio='" + portflio + '\'' +
                '}';
    }
    public Set<Article> getAssignedArticles() {
        return assignedArticles;
    }
}
