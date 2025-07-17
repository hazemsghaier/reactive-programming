package org.hazem.reactive.databaseintegration.repository;

import org.hazem.reactive.databaseintegration.entity.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TaskRepository extends ReactiveCrudRepository<TaskEntity, Integer> {
    Flux<TaskEntity> findByUserId(Integer id);
}
