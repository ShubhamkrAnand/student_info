package com.Student.ServiceImpl;

import com.Student.Entity.Student;
import com.Student.Payload.StudentDto;
import com.Student.Repository.StudentRepository;
import com.Student.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
                private StudentRepository studentRepository;
                public StudentServiceImpl(StudentRepository studentRepository){
                    this.studentRepository=studentRepository;
                }
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student entity = maptoentity(studentDto);
        Student save = studentRepository.save(entity);
        StudentDto dto = maptoDto(save);
        return dto;
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> all = studentRepository.findAll();
        List<StudentDto> collect = all.stream().map(p -> maptoDto(p)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public StudentDto update(long id, StudentDto studentDto) {
        Optional<Student> student = studentRepository.findById(id);
        Student student1 = student.get();

        student1.setName(studentDto.getName());
        student1.setClassName(studentDto.getClassName());
        student1.setAge(studentDto.getAge());
        student1.setEmail(studentDto.getEmail());
              return   maptoDto(student1);

    }

    @Override
    public void deleteByid(long id) {
                    studentRepository.deleteById(id);

    }

    //convert dto to Entity
    public Student maptoentity(StudentDto studentDto){
                 Student student=new Student();
                 student.setName(studentDto.getName());
                 student.setAge(studentDto.getAge());
                 student.setClassName(studentDto.getClassName());
                 student.setEmail(studentDto.getEmail());
                 return student;
    }
    //convert entity to Dto
    public StudentDto maptoDto(Student student){
                    StudentDto studentDto=new StudentDto();
                    studentDto.setId(student.getId());
                    studentDto.setName(student.getName());
                    studentDto.setAge(student.getAge());
                    studentDto.setClassName(student.getClassName());
                    studentDto.setEmail(student.getEmail());
                    return studentDto;

    }
}
