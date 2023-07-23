package org.barkouch.usersRoles.service;


import org.barkouch.usersRoles.entity.Role;
import org.barkouch.usersRoles.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    User findUserByEmail(String email);

    List<User> findAllUsers();
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String roleName,String email);

    List<Role> findAllRoles();
}
