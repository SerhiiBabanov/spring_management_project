package ua.goit.service;

import ua.goit.model.dao.ProducerDAO;
import ua.goit.model.dto.ProducerDTO;

public class ProducerConverter {
    public ProducerDTO mapToDTO(final ProducerDAO producerDao, final ProducerDTO producerDto) {
        producerDto.setId(producerDao.getId());
        producerDto.setName(producerDao.getName());
        return producerDto;
    }
    public ProducerDAO mapToDAO(final ProducerDTO producerDto, final ProducerDAO producerDao) {
        producerDao.setName(producerDto.getName());
        return producerDao;
    }
}
