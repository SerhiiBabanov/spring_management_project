package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.model.dao.UserDAO;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserDAO, UUID> {
}
