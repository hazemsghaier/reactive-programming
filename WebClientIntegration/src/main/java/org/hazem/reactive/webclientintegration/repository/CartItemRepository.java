package org.hazem.reactive.webclientintegration.repository;

import org.hazem.reactive.webclientintegration.entity.CartItemEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartItemRepository extends ReactiveCrudRepository<CartItemEntity, Integer> {
}
