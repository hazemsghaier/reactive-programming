package org.hazem.reactive.databaseintegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class UserEntity {
    private Integer id;
    private String name;
    private String email;
    private   String password;
    private String phone;
    private String address;
    private Integer age;
}
