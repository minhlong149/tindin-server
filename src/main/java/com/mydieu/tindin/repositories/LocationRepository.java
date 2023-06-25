package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findByCity(String city );

    Location findByCityContaining(String city);
}