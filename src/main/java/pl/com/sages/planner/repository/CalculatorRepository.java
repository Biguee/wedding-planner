package pl.com.sages.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sages.planner.entity.Calculator;
import pl.com.sages.planner.entity.Catering;

/**
 * @author Justyna Salacinska
 */
@Repository
@Transactional
public interface CalculatorRepository extends JpaRepository<Calculator, Long> {
}
