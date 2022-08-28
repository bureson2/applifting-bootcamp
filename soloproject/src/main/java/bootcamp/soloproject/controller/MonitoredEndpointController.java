package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.service.MonitoredEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MonitoredEndpointController {

    @Autowired
    private MonitoredEndpointService monitoredEndpointService;

    @GetMapping(value = "/endpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoredEndpoint> getMonitoredEndpoints(){
        return monitoredEndpointService.getMonitoredEndpoints();
    }

}
