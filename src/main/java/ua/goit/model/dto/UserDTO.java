package ua.goit.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.goit.model.dao.RoleDAO;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    @Email
    @Size(max = 255)
    private String email;

    @Size(max = 255)
    private String password;

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String lastName;

    private Set<RoleDAO> roles;


}
