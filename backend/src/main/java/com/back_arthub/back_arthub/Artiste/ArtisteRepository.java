package com.back_arthub.back_arthub.Artiste;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtisteRepository extends
        JpaRepository<Artiste, Long> {
    Optional<Artiste> findArtisteById(Long Id);
}

