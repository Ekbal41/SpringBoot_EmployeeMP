package com.asifekbal.management.AuthController;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.asifekbal.management.Repo.RolesRepository;
import com.asifekbal.management.Repo.UserRepository;
import com.asifekbal.management.Shema.Role;
import com.asifekbal.management.Shema.User;
import com.asifekbal.management.Shema.UserSTO;





@Controller

public class LoginController {
    @Autowired private UserRepository userRepo;
    @Autowired private RolesRepository roleRepo;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String addNewEmployee(Model model) {
        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_ADMIN");
        roleRepo.save(role);
        Role role2 = new Role();
        role2.setId(2);
        role2.setName("ROLE_USER");
        roleRepo.save(role2);
        UserSTO userSTO = new UserSTO();
        model.addAttribute("userSTO", userSTO);
        return "register";
    }
    @Bean
    public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
   }

    @PostMapping("/save_user")
    public String saveEmployee(UserSTO userSTO) {
        User user = new User();

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findByName("ROLE_USER"));
            user.setRoles(roles);

        String password = encoder().encode(userSTO.getPassword());
        
        user.setUsername(userSTO.getUsername());
        user.setPassword(password);
        user.setEmail(userSTO.getEmail());
        userRepo.save(user);
        
        return "redirect:/";
    }
}