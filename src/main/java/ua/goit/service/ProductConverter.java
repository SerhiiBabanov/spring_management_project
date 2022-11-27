package ua.goit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.model.dao.ProductDAO;
import ua.goit.model.dto.ProductDTO;

@Service
@RequiredArgsConstructor
public class ProductConverter {
    private final ProducerConverter producerConverter;

    public ProductDTO mapToDTO(final ProductDAO productDAO) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productDAO.getId());
        productDTO.setName(productDAO.getName());
        productDTO.setPrice(productDAO.getPrice());
        productDTO.setProducer(producerConverter.mapToDTO(productDAO.getProducer()));
        return productDTO;
    }

    public ProductDAO mapToDAO(final ProductDTO productDTO) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setName(productDTO.getName());
        productDAO.setPrice(productDTO.getPrice());
        productDAO.setProducer(producerConverter.mapToDAO(productDTO.getProducer()));
        return productDAO;
    }
}
