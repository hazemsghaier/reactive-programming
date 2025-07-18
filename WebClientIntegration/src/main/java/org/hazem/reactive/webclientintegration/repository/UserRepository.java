package org.hazem.reactive.webclientintegration.repository;

import org.hazem.reactive.webclientintegration.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Integer> {
}
