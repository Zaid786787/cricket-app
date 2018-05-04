package io.cricket.repository;

import io.cricket.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Application user data access
 */

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findOneByUsername(String username);
}
