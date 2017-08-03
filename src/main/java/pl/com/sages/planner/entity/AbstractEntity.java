package pl.com.sages.planner.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Justyna Salacinska
 */
@MappedSuperclass
@Data
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
}
