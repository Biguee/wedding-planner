package pl.com.sages.security.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name = "profiles")
@Component
@Entity
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String surname;


    public UserProfile(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public UserProfile() {
    }
}
