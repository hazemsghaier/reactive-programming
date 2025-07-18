package org.hazem.reactive.webclientintegration.repository;

import org.hazem.reactive.webclientintegration.entity.CartEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository extends ReactiveCrudRepository<CartEntity, Integer> {
}
