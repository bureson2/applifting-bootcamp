package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoredEndpointRepository;
import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoredEndpointService {

    @Autowired
    private MonitoredEndpointRepository monitoredEndpointDao;

    @Autowired
    private UserRepository userDao;

    public List<MonitoredEndpoint> getMonitoredEndpoints(){
        return monitoredEndpointDao.findAll();
    }

    public Optional<MonitoredEndpoint> addMonitoredEndpoint(MonitoredEndpoint monitoredEndpoint, Long userId){
        if(userId != null){
            monitoredEndpoint.setOwner(userDao.findById(userId).get());
        }
        monitoredEndpoint.setDateOfCreation(LocalDateTime.now());
        monitoredEndpointDao.save(monitoredEndpoint);
        return monitoredEndpointDao.findById(monitoredEndpoint.getId());
    }

    public void deleteMonitoredEndpoint(Long endpointId){
        monitoredEndpointDao.deleteById(endpointId);
    }

//    TODO - GET user enpdpoints
//    TODO - PUT check endpoint
//    TODO - PUT change owner

    //    TODO kontrola existence zaznamu - predchazeni 500
}
