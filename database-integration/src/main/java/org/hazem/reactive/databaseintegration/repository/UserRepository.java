package org.hazem.reactive.databaseintegration.repository;

import org.hazem.reactive.databaseintegration.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
    Mono<UserEntity> findByEmail(String email);
}
