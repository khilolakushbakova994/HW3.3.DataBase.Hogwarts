package hogwarts.HW33.DataBase.Hogwarts.controller;


import hogwarts.HW33.DataBase.Hogwarts.service.StudentService;
import hogwarts.HW33.DataBase.Hogwarts.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> find(@PathVariable Long id) {
        Student student = studentService.find(id);
        if (student == null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(student);

    }

    @PutMapping
    public ResponseEntity <Student> changeStudentInfo(@RequestBody Student student) {
        Student changeStudent = studentService.changeStudentInfo(student);
        if(changeStudent==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(changeStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> removeStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/allStudents")
    public ResponseEntity<Collection<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("{age}")
    public List<Student> findStudentByAge(@PathVariable int age) {
        return studentService.findStudentByAge(age);
    }


}
