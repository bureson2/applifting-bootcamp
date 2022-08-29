package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoredEndpointRepository;
import bootcamp.soloproject.interfaces.MonitoringResultRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.MonitoringResult;
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

//    TODO - jak je to mysleny a ma se resit s tim ukladanim tohohle? Mame to posilat v body a neresit, jak by se to provolavalo
//    payload a status code
    public Optional<MonitoringResult> saveMonitoringResult(MonitoringResult monitoringResult, Long endpointId){
        if(endpointId != null){
            monitoringResult.setMonitoredEndpoint(monitoredEndpointDao.findById(endpointId).get());
        }
        monitoringResult.setDateOfCheck(LocalDateTime.now());
        monitoringResultDao.save(monitoringResult);
        return monitoringResultDao.findById(monitoringResult.getId());
    }

    public void deleteMonitoringResult(Long resultId){
        monitoringResultDao.deleteById(resultId);
    }

    //    TODO kontrola existence zaznamu - predchazeni 500
}
