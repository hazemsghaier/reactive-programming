package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.student.StudentEntity;

public class StudentMapper {
    /**
     * Converts a StudentDto object to a StudentEntity object.
     *
     * @param studentDto the StudentDto object to be converted
     * @return the converted StudentEntity object
     */
    public static StudentEntity toStudentEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setPhone(studentDto.getPhone());
        studentEntity.setAge(studentDto.getAge());
        studentEntity.setPassword(null);
        return studentEntity;
    }
    /**
     * Converts a StudentEntity object to a StudentDto object.
     *
     * @param studentEntity the StudentEntity object to be converted
     * @return the converted StudentDto object
     */
    public static StudentDto toStudentDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setPhone(studentEntity.getPhone());
        studentDto.setAge(studentEntity.getAge());
        return studentDto;
    }
}
