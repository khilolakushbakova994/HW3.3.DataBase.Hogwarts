package hogwarts.HW33.DataBase.Hogwarts.controller;

import hogwarts.HW33.DataBase.Hogwarts.model.Faculty;
import hogwarts.HW33.DataBase.Hogwarts.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);

    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if(faculty==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity <Faculty> changeFacultyInfo(@RequestBody Faculty faculty) {
        Faculty changedFaculty = facultyService.changeFacultyInfo(faculty);
        if(changedFaculty==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(changedFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeFaculty(@PathVariable Long id) {
        facultyService.removeFaculty(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("{color}")
    public List<Faculty> findFacultyByColor(@PathVariable String color) {
        return facultyService.findFacultyByColor(color);
    }
}
