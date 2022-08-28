package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoringResultRepository;
import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonitoringResultService {

    @Autowired
    private MonitoringResultRepository monitoringResultDao;

    public List<MonitoringResult> getMonitoringResults(){
        return monitoringResultDao.findAll();
    }

//  TODO GET Records for endpoint
//  TODO POST - Create new Monitoring result
//  TODO DELETE result
}
