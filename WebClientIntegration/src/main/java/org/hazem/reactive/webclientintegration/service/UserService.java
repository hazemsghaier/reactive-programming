package org.hazem.reactive.webclientintegration.service;

import lombok.RequiredArgsConstructor;
import org.hazem.reactive.webclientintegration.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final ProductRepository productRepository;
    public Mono<?> getAllProducts(){
        return ;
    }
}
