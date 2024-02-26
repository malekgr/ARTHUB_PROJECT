package com.back_arthub.back_arthub.Visitor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Optional<Visitor> findUserByEmail(String email);
}
