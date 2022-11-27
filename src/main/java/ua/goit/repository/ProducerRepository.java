package ua.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.model.dao.ProducerDAO;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<ProducerDAO, UUID> {
}
