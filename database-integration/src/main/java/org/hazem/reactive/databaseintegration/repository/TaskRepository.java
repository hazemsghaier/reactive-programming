package org.hazem.reactive.databaseintegration.repository;

import org.hazem.reactive.databaseintegration.entity.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ReactiveCrudRepository<TaskEntity, Long> {
}
