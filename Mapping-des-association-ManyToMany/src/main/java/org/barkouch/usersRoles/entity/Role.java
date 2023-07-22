package org.barkouch.usersRoles.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    private String id;
    @Column(name = "ROLE_NAME",unique = true, nullable = false, length = 20)
    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<User> users = new ArrayList<>();

}
