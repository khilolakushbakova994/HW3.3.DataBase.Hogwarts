package hogwarts.HW33.DataBase.Hogwarts.service;

import hogwarts.HW33.DataBase.Hogwarts.model.Faculty;
import hogwarts.HW33.DataBase.Hogwarts.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }


    public Faculty changeFacultyInfo(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public ResponseEntity<Faculty> removeFaculty(long id) {
        facultyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public List<Faculty> softFacultyByColor(String color) {
        return facultyRepository.softFacultyByColor(color);
    }
}
