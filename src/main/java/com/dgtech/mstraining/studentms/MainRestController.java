package com.dgtech.mstraining.studentms;

import com.dgtech.mstraining.studentms.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class MainRestController {

    StudentRepository studentRepository;

    public MainRestController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("students/{rollNumber}")
    public ResponseEntity<Student> getStudent(@PathVariable("rollNumber") String rollNumber){
        Optional<Student> student = studentRepository.findById(rollNumber);
        if (student.isPresent()){
            return new ResponseEntity<>(student.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("students/fullname/{fullname}")
    public ResponseEntity<List<Student>> getStudentsByFullname(@PathVariable("fullname") String fullname){
        List<Student> studentsByFullname = studentRepository.findByFullname(fullname);
        if (studentsByFullname.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(studentsByFullname,HttpStatus.OK);
        }
    }

    @PostMapping("students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        student.setRollNumber(String.valueOf((int)(Math.random()*100000)));
        studentRepository.save(student);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PutMapping("students/{rollNumber}")
    public ResponseEntity<Student> updateStudent(@PathVariable("rollNumber") String rollNumber, @RequestBody Student student){
        Optional<Student> _student = studentRepository.findById(rollNumber);
        if(_student.isPresent()){
            Student studentDB = _student.get();
            studentDB.setAge(student.getAge());
            studentDB.setAddress(student.getAddress());
            studentDB.setFullname(student.getFullname());
            studentDB.setDob(student.getDob());
            studentDB.setGender(student.getGender());
            return new ResponseEntity<>(studentRepository.save(studentDB),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("students/{rollNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable("rollNumber") String rollNumber){
        studentRepository.deleteById(rollNumber);
        return new ResponseEntity<>(String.format("Student with roll-number %s is deleted",rollNumber),HttpStatus.OK);
    }
}
