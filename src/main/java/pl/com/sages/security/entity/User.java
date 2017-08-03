package pl.com.sages.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
@Data
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    private boolean active;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Authority> authorities = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    private UserProfile userProfile;

    public void addAuthority(Authority authority) {
        if (authorities == null){
            authorities = new HashSet<>();
        }
        authorities.add(authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
