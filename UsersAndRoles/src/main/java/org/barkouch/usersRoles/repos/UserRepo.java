package org.barkouch.usersRoles.repos;


import org.barkouch.usersRoles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo  extends JpaRepository<User, String> {
    User findByEmailIgnoreCase(String email);


}
