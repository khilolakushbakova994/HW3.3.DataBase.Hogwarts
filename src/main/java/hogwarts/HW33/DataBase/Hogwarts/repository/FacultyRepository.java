package hogwarts.HW33.DataBase.Hogwarts.repository;

import hogwarts.HW33.DataBase.Hogwarts.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findFacultyByColor (String color);
}
