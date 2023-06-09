package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Boolean existsByUsername(String username);
    Optional<Account> findByUsername(String username);
}