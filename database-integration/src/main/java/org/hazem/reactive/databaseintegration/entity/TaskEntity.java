package org.hazem.reactive.databaseintegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hazem.reactive.databaseintegration.enums.TaskStatus;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class TaskEntity {
    private Integer id;
    private String title;
    private String description;
    private TaskStatus status;
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
