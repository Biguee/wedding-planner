package pl.com.sages.planner.entity;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.EAGER;

/**
 * @author Justyna Salacinska
 */

@Table(name ="games")
@Entity
@Data
public class Game extends AbstractEntity implements Serializable {

    @Column(name = "name")
    private String name;
    @Lob
    @Basic(fetch = EAGER)
    @Column(name = "description")
    private String description;

}
