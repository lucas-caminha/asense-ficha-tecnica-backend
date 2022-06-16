package br.com.ftservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ftservice.model.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
}
