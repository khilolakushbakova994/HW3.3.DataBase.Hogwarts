package hogwarts.HW33.DataBase.Hogwarts.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private  String color;




}
