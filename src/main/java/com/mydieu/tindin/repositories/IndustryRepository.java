package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IndustryRepository extends JpaRepository<Industry, Integer> {
    Industry findByName (String name);

    Industry findByNameContaining(String name);
}