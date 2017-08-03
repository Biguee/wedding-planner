package pl.com.sages.planner.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Justyna Salacinska
 */

@Table(name ="guests")
@Entity
@Data
public class Guest extends AbstractEntity implements Serializable{

    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;



}
