package ua.goit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.model.dto.UserDTO;
import ua.goit.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    public List<UserDTO> findAll() {
        return userRepository.findAll(Sort.by("email"))
                .stream()
                .map(userConverter::mapToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO get(UUID id) {
        return userRepository.findById(id)
                .map(userConverter::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(UserDTO userDTO) {
        return userRepository.save(userConverter.mapToDAO(userDTO)).getId();
    }

    public void update(UUID id, UserDTO userDTO) {
        userDTO.setId(id);
        userRepository.findById(id)
                .map((p)->userRepository.save(userConverter.mapToDAO(userDTO)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(UUID id){
        userRepository.deleteById(id);
    }
    public UserDTO findByUsername(String username){
        return userRepository.findByEmail(username)
                .map(userConverter::mapToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public boolean isExistEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
