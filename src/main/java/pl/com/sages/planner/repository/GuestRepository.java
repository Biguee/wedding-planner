package pl.com.sages.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sages.planner.entity.Guest;

/**
 * @author Justyna Salacinska
 */
@Repository
@Transactional
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Guest findByName(String name);
}
