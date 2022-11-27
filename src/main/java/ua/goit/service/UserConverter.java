package ua.goit.service;

import org.springframework.stereotype.Service;
import ua.goit.model.dao.UserDAO;
import ua.goit.model.dto.UserDTO;

@Service
public class UserConverter {

    public UserDTO mapToDTO(UserDAO userDAO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDAO.getId());
        userDTO.setEmail(userDAO.getEmail());
        userDTO.setPassword(userDAO.getPassword());
        userDTO.setFirstName(userDAO.getFirstName());
        userDTO.setLastName(userDAO.getLastName());
        userDTO.setRoles(userDAO.getRoles());
        return userDTO;
    }

    public UserDAO mapToDAO(UserDTO userDTO){
        UserDAO userDAO = new UserDAO();
        userDAO.setId(userDTO.getId());
        userDAO.setEmail(userDTO.getEmail());
        userDAO.setPassword(userDTO.getPassword());
        userDAO.setFirstName(userDTO.getFirstName());
        userDAO.setLastName(userDTO.getLastName());
        userDAO.setRoles(userDTO.getRoles());
        return userDAO;
    }

}
