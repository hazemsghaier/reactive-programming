package com.example.demo.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<StudentEntity, Integer> {
    Mono<StudentEntity> findByEmail(String email);

}
