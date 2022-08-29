package bootcamp.soloproject.interfaces;

import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MonitoredEndpointRepository extends JpaRepository<MonitoredEndpoint, Long> {

    List<MonitoredEndpoint> findByOwner(User user);
}
