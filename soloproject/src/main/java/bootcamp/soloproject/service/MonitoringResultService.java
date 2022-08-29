package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoredEndpointRepository;
import bootcamp.soloproject.interfaces.MonitoringResultRepository;
import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoringResultService {

    @Autowired
    private MonitoringResultRepository monitoringResultDao;

    @Autowired
    private MonitoredEndpointRepository monitoredEndpointDao;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private MonitoredEndpointService monitoredEndpointService;

    public List<MonitoringResult> getMonitoringResults(){
        return monitoringResultDao.findAll();
    }

    public List<MonitoringResult> getEndpointResults(Long endpointId){
        Optional<MonitoredEndpoint> monitoredEndpoint = monitoredEndpointDao.findById(endpointId);
        List<MonitoringResult> toReturn = null;
        if(monitoredEndpoint.isPresent()){
            toReturn = monitoringResultDao.findByMonitoredEndpoint(monitoredEndpoint.get());
        }
        return toReturn;
    }

    public List<MonitoringResult> getEndpointLastResults(Long endpointId){
        Optional<MonitoredEndpoint> monitoredEndpoint = monitoredEndpointDao.findById(endpointId);
        List<MonitoringResult> toReturn = null;
        if(monitoredEndpoint.isPresent()){
            toReturn = monitoringResultDao.findTop10ByMonitoredEndpointOrderByDateOfCheckDesc(monitoredEndpoint.get());
        }
        return toReturn;
    }

    public List<MonitoringResult> getUserResults(Long userId){
        Optional<User> user = userDao.findById(userId);
        List<MonitoringResult> toReturn = new ArrayList<>();
        if(user.isPresent()){
            List<MonitoredEndpoint> endpoints = monitoredEndpointService.getUsersMonitoredEndpoints(userId);
            for(MonitoredEndpoint e : endpoints){
                List<MonitoringResult> results = getEndpointResults(e.getId());
                toReturn.addAll(results);
            }
        }
        return toReturn;
    }

    public Optional<MonitoringResult> saveMonitoringResult(MonitoringResult monitoringResult, Long endpointId){
        Optional<MonitoredEndpoint> endpoint = monitoredEndpointDao.findById(endpointId);
        endpoint.ifPresent(monitoredEndpoint -> monitoringResult.setMonitoredEndpoint(monitoredEndpointDao.findById(endpointId).get()));
        monitoringResult.setDateOfCheck(LocalDateTime.now());
        monitoringResultDao.save(monitoringResult);
        return monitoringResultDao.findById(monitoringResult.getId());
    }

    public void deleteMonitoringResult(Long resultId){
        monitoringResultDao.deleteById(resultId);
    }
}
