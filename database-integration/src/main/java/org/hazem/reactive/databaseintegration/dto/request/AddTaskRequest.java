package org.hazem.reactive.databaseintegration.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskRequest {
    private Integer id;
    private String title;
    private String description;
    private Integer userId;
}
