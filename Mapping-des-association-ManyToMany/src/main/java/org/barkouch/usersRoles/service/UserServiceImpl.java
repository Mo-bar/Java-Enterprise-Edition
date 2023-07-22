package org.barkouch.usersRoles.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.barkouch.usersRoles.entity.Role;
import org.barkouch.usersRoles.entity.User;
import org.barkouch.usersRoles.repos.RoleRepo;
import org.barkouch.usersRoles.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepo userRepo;
    RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        final String id = UUID.randomUUID().toString();
        user.setId(id);
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        final String id = UUID.randomUUID().toString();
        role.setId(id);
        return roleRepo.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmailIgnoreCase(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepo.findByRoleNameIgnoreCase(roleName);
    }

    @Override
    public void addRoleToUser(String roleName, String email) {
        User user = findUserByEmail(email);
        Role role = findRoleByRoleName(roleName);

        if(user.getRoles() != null){
            user.getRoles().add(role);
            role.getUsers().add(user);
            /*
            L'annotation @Transactional assure la mise à jour des objets role et user dans la base de données
            sans nécessiter explicitement de save().
             */

        }
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepo.findAll();
    }
}
