package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoredEndpointRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonitoredEndpointService {

    @Autowired
    private MonitoredEndpointRepository monitoredEndpointDao;

    public List<MonitoredEndpoint> getMonitoredEndpoints(){
        return monitoredEndpointDao.findAll();
    }

//    TODO - GET user enpdpoints
//    TODO - POST create endpoint
//    TODO - PUT check endpoint
//    TODO - PUT change owner
//    TODO - DELETE endpoint


}
