package ua.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.model.dao.UserDAO;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDAO, UUID> {
    Optional<UserDAO> findByEmail(String email);
    boolean existsByEmail(String email);
}
