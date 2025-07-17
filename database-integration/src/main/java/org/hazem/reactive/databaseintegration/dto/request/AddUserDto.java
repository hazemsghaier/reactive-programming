package org.hazem.reactive.databaseintegration.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDto {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Integer age;
}
