package ua.goit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.model.dto.ProductDTO;
import ua.goit.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        return productRepository.findAll(Sort.by("name"))
                .stream()
                .map(productConverter::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO get(UUID id) {
        return productRepository.findById(id)
                .map(productConverter::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(ProductDTO productDTO) {
        return productRepository.save(productConverter.mapToDAO(productDTO)).getId();
    }

    public void update(ProductDTO productDTO) {
        if (Objects.nonNull(productDTO.getId()) && productRepository.existsById(productDTO.getId())) {
            productRepository.save(productConverter.mapToDAO(productDTO));
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void delete(UUID id){
        productRepository.deleteById(id);
    }
}
