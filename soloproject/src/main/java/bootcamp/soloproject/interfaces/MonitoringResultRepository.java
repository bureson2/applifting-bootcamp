package bootcamp.soloproject.interfaces;

import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.MonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MonitoringResultRepository extends JpaRepository<MonitoringResult, Long> {

    public List<MonitoringResult> findByMonitoredEndpoint(MonitoredEndpoint monitoredEndpoint);

    public List<MonitoringResult> findTop10ByMonitoredEndpointOrderByDateOfCheckDesc(MonitoredEndpoint monitoredEndpoint);
}
