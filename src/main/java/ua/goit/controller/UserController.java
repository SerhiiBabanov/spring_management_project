package ua.goit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.dto.UserDTO;
import ua.goit.service.RoleService;
import ua.goit.service.UserService;

import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
//@PreAuthorize("ROLE_ADMIN")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @GetMapping
    public ModelAndView getUsers() {
        ModelAndView result = new ModelAndView("users/users");
        result.addObject("users", userService.findAll());
        return result;
    }

    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        ModelAndView result = new ModelAndView("users/createUserForm");
        result.addObject("roles", roleService.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable("id") UUID id) {
        ModelAndView result = new ModelAndView("users/userEditForm");
        result.addObject("user", userService.get(id));
        result.addObject("roles", roleService.findAll());

        return result;
    }

    @PostMapping("/{id}")
    public String update(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result,
                         @PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            return "users/userEditForm";
        }
        if (Objects.nonNull(userDTO.getPassword()) & !userDTO.getPassword().isEmpty() & !userDTO.getPassword().isBlank()){
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        } else {
            userDTO.setPassword(userService.get(id).getPassword());
        }
        userDTO.setEmail(userDTO.getEmail().toLowerCase());
        userService.update(id, userDTO);
        return "redirect:/users";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") UserDTO userDTO,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "users/createUserForm";
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UUID id = userService.create(userDTO);
        return "redirect:/users/" + id;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") UUID id) {
        userService.delete(id);
        return getUsers();
    }

    @ModelAttribute("user")
    private UserDTO getDefaultProduct() {
        return new UserDTO();
    }
}
