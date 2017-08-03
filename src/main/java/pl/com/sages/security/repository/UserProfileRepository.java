package pl.com.sages.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.sages.security.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {


}
