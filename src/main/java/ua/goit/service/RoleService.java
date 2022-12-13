package ua.goit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.goit.model.dao.RoleDAO;
import ua.goit.repository.RoleRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public List<RoleDAO> findAll(){
        return roleRepository.findAll();
    }
    public RoleDAO findById(UUID id){
        return roleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public boolean idFound(UUID id){
        return roleRepository.existsById(id);
    }
    public RoleDAO findByName(String name){
        return roleRepository.findByName(name);
    }


}
