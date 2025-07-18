package org.hazem.reactive.webclientintegration.service;

import lombok.RequiredArgsConstructor;
import org.hazem.reactive.webclientintegration.entity.ProductEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class ProductApiClient {
    private final WebClient webClient;
    public Flux<ProductEntity> getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(ProductEntity.class);
    }
}
