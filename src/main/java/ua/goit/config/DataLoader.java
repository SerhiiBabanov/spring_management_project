package ua.goit.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import ua.goit.model.dao.RoleDAO;
import ua.goit.repository.RoleRepository;

//@Component
@AllArgsConstructor
public class DataLoader {
    private final RoleRepository roleRepository;

    @PostConstruct
    private void loadData(){
        roleRepository.deleteAll();
        RoleDAO user = new RoleDAO();
        user.setName("ROLE_USER");
        roleRepository.save(user);
        RoleDAO admin = new RoleDAO();
        admin.setName("ROLE_ADMIN");
        roleRepository.save(admin);

    }
}
