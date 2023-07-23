package org.barkouch.usersRoles.repos;


import org.barkouch.usersRoles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User, String> {
    User findByEmailIgnoreCase(String email);
}
