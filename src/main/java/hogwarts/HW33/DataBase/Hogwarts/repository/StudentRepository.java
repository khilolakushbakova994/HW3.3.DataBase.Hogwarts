package hogwarts.HW33.DataBase.Hogwarts.repository;

import hogwarts.HW33.DataBase.Hogwarts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByAge (Integer age);
}
