package hogwarts.HW33.DataBase.Hogwarts.service;

import hogwarts.HW33.DataBase.Hogwarts.model.Student;
import hogwarts.HW33.DataBase.Hogwarts.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent (Student student ){
        return studentRepository.save(student);
    }

    public Student find (Long id){
        return studentRepository.findById(id).get();
    }


    public Student  changeStudentInfo (Student student){
        return studentRepository.save(student);
    }

    public ResponseEntity <Student> removeStudent (Long id){
         studentRepository.deleteById(id);
         return ResponseEntity.ok().build();
    }
    public List<Student> sortStudentByAge (Integer age){
        return studentRepository.sortStudentByAge(age);
    }
}
