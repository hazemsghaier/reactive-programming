package com.example.demo.controller;

import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final StudentService studentService;
    @GetMapping
    public Flux<String> demo() {

        return Flux.just("A", "B", "C").delayElements(Duration.ofSeconds(1));
    }

}
