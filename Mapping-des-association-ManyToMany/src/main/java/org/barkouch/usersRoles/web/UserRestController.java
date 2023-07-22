package org.barkouch.usersRoles.web;

import org.barkouch.usersRoles.entity.Role;
import org.barkouch.usersRoles.entity.User;
import org.barkouch.usersRoles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> users(){
        return userService.findAllUsers();
    }

    @GetMapping("/roles")
    public List<Role> roles(){
        return userService.findAllRoles();
    }

}
