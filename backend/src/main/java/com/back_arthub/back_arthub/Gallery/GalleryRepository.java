package com.back_arthub.back_arthub.Gallery;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GalleryRepository extends
        JpaRepository<Gallery, Long> {
    Optional<Gallery> findGalleryByLocation(String location);
}
