package com.example.demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final  StudentRepository studentRepository;
    public Flux<StudentEntity> getStudent() {
        return studentRepository.findAll();
    }
    public Mono<StudentEntity> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }
    public Mono<StudentEntity> saveStudent(StudentEntity student) {
        return studentRepository.save(student);
    }
    public Mono<Void> deleteStudentById(Integer id) {
        return studentRepository.deleteById(id);
    }
    public Mono<StudentEntity> updateStudent(StudentEntity student) {
        return studentRepository.save(student);
    }
    public Mono<StudentEntity> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

}
