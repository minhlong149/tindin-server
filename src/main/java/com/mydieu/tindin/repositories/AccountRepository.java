package com.mydieu.tindin.repositories;

import com.mydieu.tindin.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}