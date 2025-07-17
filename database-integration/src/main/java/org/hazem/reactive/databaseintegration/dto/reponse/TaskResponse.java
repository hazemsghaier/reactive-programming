package org.hazem.reactive.databaseintegration.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hazem.reactive.databaseintegration.enums.TaskStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
    private Integer id;
    private String title;
    private String description;
    private TaskStatus status;
    private Integer userId;
}
