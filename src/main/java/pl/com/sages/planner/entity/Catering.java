package pl.com.sages.planner.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Justyna Salacinska
 */
@Table(name ="catering")
@Entity
@Data
public class Catering extends AbstractEntity implements Serializable {

    @Column(nullable = false, name = "name")
    private String name;
    @Column(name = "kind")
    @Enumerated(EnumType.STRING)
    private CateringKind kind;



}
