package com.Student.Service;

import com.Student.Payload.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

   List<StudentDto> getAll();

    StudentDto update(long id, StudentDto studentDto);

    void deleteByid(long id);
}
