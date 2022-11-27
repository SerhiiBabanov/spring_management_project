package ua.goit.service;

import org.springframework.stereotype.Service;
import ua.goit.model.dao.ProducerDAO;
import ua.goit.model.dto.ProducerDTO;
@Service
public class ProducerConverter {
    public ProducerDTO mapToDTO(final ProducerDAO producerDao) {
        ProducerDTO producerDto = new ProducerDTO();
        producerDto.setId(producerDao.getId());
        producerDto.setName(producerDao.getName());
        return producerDto;
    }
    public ProducerDAO mapToDAO(final ProducerDTO producerDto) {
        ProducerDAO producerDao = new ProducerDAO();
        producerDao.setName(producerDto.getName());
        return producerDao;
    }
}
