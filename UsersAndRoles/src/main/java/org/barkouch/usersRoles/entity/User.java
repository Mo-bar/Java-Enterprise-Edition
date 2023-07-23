package org.barkouch.usersRoles.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    private String id;
    private String name;
    @Column(name = "EMAIL",unique = true, nullable = false)
    private String email;
    private String passwd;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Role> roles = new ArrayList<>();

}
