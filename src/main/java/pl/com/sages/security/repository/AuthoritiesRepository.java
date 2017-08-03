package pl.com.sages.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.sages.security.entity.Authority;

public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
}
