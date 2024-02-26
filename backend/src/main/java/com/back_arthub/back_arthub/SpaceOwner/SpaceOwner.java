package com.back_arthub.back_arthub.SpaceOwner;

import com.back_arthub.back_arthub.Gallery.Gallery;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class SpaceOwner{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gallery_owner",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "gallery_id"))
    private Set<Gallery> galleries = new HashSet<>();

    public SpaceOwner() {
    }

    public SpaceOwner(String name, Set<Gallery> galleries) {
        this.name = name;
        this.galleries = galleries;
    }

    @Override
    public String toString() {
        return "SpaceOwner{" +
                "ownerId=" + ownerId +
                ", galleries=" + galleries +
                '}';
    }
}
