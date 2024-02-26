package com.back_arthub.back_arthub.SpaceOwner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpaceOwnerRepository extends
        JpaRepository<SpaceOwner, Long> {
    Optional<SpaceOwner> findSpaceOwnerByName(String name);
}
