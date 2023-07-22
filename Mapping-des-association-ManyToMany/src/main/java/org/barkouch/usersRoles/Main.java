package org.barkouch.usersRoles;

import org.barkouch.usersRoles.entity.Role;
import org.barkouch.usersRoles.entity.User;
import org.barkouch.usersRoles.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            for (String name : List.of("Ali", "Mo", "Joe")){
                User user = new User();
                user.setName(name);
                user.setEmail(name+"@gmail.com");
                user.setPasswd("1234");
                userService.saveUser(user);
            }

            for (String roleName : List.of("user","etudiant","ensignant","directeur")){
                Role role = new Role();
                role.setRoleName(roleName.toUpperCase());
                userService.saveRole(role);
            }

            userService.addRoleToUser("user","ali@gmail.com");
            userService.addRoleToUser("etudiant","ali@gmail.com");
            userService.addRoleToUser("directeur","Mo@gmail.com");
            userService.addRoleToUser("ensignant","Mo@gmail.com");
            userService.addRoleToUser("etudiant","Mo@gmail.com");


        };
    }

}
