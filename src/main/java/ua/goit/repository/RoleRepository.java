package ua.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.model.dao.RoleDAO;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleDAO, UUID> {
    RoleDAO findByName(String name);
}
