package com.Student.Controller;

import com.Student.Payload.StudentDto;
import com.Student.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping("/save")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto student = studentService.createStudent(studentDto);
         return  new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<StudentDto>> getAll(){
        List<StudentDto> all = studentService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable("id") long id,@RequestBody StudentDto studentDto){
        StudentDto update = studentService.update(id, studentDto);
        return new ResponseEntity<>(update,HttpStatus.OK);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable("id") long id){
        studentService.deleteByid(id);
        return new ResponseEntity<>("successfull deleted",HttpStatus.OK);

    }
}
