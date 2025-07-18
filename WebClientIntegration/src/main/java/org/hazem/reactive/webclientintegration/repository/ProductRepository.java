package org.hazem.reactive.webclientintegration.repository;

import org.hazem.reactive.webclientintegration.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity,Integer> {
}
