package org.hazem.reactive.webclientintegration.dto.fakeApinStore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApiDto {
    private Integer id;
    private String username;
    private String email;
    private String password;
}
