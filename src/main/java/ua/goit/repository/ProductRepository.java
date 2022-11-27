package ua.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.model.dao.ProductDAO;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductDAO, UUID> {
}
