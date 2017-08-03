package pl.com.sages.planner.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Justyna Salacinska
 */
@Table(name ="calculator")
@Entity
@Data
public class Calculator extends AbstractEntity implements Serializable {

    @Column(nullable = false, name = "name")
    private String name;
    @Column(name = "cost")
    private Double cost;


}
