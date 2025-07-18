package org.hazem.reactive.webclientintegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    private Integer id;

    private String email;

    private String username;

    private String password;

    private String phone;

    private String firstname;

    private String lastname;

    private String city;

    private String street;

    private Integer number;

    private String zipcode;
}
