package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public Flux<StudentDto> getStudent()
    {
        return studentService.getStudent().map( StudentMapper::toStudentDto );
    }
    @GetMapping("/{id}")
    public Mono<StudentDto> getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id).map( StudentMapper::toStudentDto );
    }
    @PostMapping
    public Mono<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent( StudentMapper.toStudentEntity(studentDto) ).map( StudentMapper::toStudentDto );
    }
    @PutMapping("/{id}")
    public Mono<StudentDto> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent( StudentMapper.toStudentEntity(studentDto) ).map( StudentMapper::toStudentDto );
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudentById(id);
    }
    @GetMapping("/email/{email}")
    public Mono<StudentDto> getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email).map( StudentMapper::toStudentDto );
    }
}
