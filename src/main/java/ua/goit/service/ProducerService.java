package ua.goit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.model.dto.ProducerDTO;
import ua.goit.repository.ProducerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducerConverter producerConverter;
    private final ProducerRepository producerRepository;

    public List<ProducerDTO> findAll() {
        return producerRepository.findAll(Sort.by("name"))
                .stream()
                .map(producerConverter::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProducerDTO get(UUID id) {
        return producerRepository.findById(id)
                .map(producerConverter::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(ProducerDTO producerDTO) {
        return producerRepository.save(producerConverter.mapToDAO(producerDTO)).getId();
    }

    public void update(UUID id, ProducerDTO producerDTO) {
        producerRepository.findById(id)
                .map((p)->producerRepository.save(producerConverter.mapToDAO(producerDTO)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public void delete(UUID id) {
        producerRepository.deleteById(id);
    }


}
