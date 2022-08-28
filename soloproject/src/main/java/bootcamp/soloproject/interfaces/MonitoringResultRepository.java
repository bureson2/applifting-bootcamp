package bootcamp.soloproject.interfaces;

import bootcamp.soloproject.model.MonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringResultRepository extends JpaRepository<MonitoringResult, Long> {
}
