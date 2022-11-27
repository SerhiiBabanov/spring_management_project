package ua.goit.repository;

import org.springframework.data.repository.CrudRepository;
import ua.goit.model.dao.ProducerDAO;

import java.util.UUID;

public interface ProducerRepository extends CrudRepository<ProducerDAO, UUID> {
}
