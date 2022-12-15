package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.goit.model.dto.UserDTO;
import ua.goit.service.RoleService;
import ua.goit.service.UserService;

import java.util.Collections;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String signup() {
        return "signup/signup";
    }

    @PostMapping
    public String signup(@ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup/signup";
        }
        if (userService.isExistEmail(userDTO.getEmail())){
            bindingResult.addError(new ObjectError("email", "Email already in use"));
            return "signup/signup";
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userDTO.setEmail(userDTO.getEmail().toLowerCase());
        userDTO.setRoles(Collections.singletonList(roleService.findByName("ROLE_USER")));
        userService.create(userDTO);
        return "redirect:/home";

    }

    @ModelAttribute("user")
    private UserDTO getDefaultProduct() {
        return new UserDTO();
    }

}
