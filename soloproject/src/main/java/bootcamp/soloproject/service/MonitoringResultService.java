package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoredEndpointRepository;
import bootcamp.soloproject.interfaces.MonitoringResultRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoringResultService {

    @Autowired
    private MonitoringResultRepository monitoringResultDao;

    @Autowired
    private MonitoredEndpointRepository monitoredEndpointDao;

    public List<MonitoringResult> getMonitoringResults(){
        return monitoringResultDao.findAll();
    }

    public Optional<MonitoringResult> saveMonitoringResult(MonitoringResult monitoringResult, Long endpointId){
        if(endpointId != null){
            monitoringResult.setMonitoredEndpointId(monitoredEndpointDao.findById(endpointId).get());
        }
        monitoringResult.setDateOfCheck(LocalDateTime.now());
        monitoringResultDao.save(monitoringResult);
        return monitoringResultDao.findById(monitoringResult.getId());
    }


//  TODO GET Records for endpoint
//  TODO GET 10 latest records
//  TODO DELETE result
}
