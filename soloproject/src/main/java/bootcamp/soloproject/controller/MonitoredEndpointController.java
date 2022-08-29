package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.service.MonitoredEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MonitoredEndpointController {

    @Autowired
    private MonitoredEndpointService monitoredEndpointService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/endpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoredEndpoint> getMonitoredEndpoints(){
        return monitoredEndpointService.getMonitoredEndpoints();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/endpoints/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoredEndpoint> getUsersMonitoredEndpoints(@PathVariable Long userId){
        return monitoredEndpointService.getUsersMonitoredEndpoints(userId);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/endpoint/new/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MonitoredEndpoint> addMonitoredEndpoint(@RequestBody MonitoredEndpoint newEndpoint, @PathVariable Long userId){
        return  monitoredEndpointService.addMonitoredEndpoint(newEndpoint, userId);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/endpoint/{endpointId}/user/{userId}")
    public Optional<MonitoredEndpoint> changeOwner(@PathVariable Long endpointId, @PathVariable Long userId){
        return monitoredEndpointService.changeOwner(endpointId, userId);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/endpoint/{endpointId}")
    public void deleteEndpoint(@PathVariable Long endpointId){
        monitoredEndpointService.deleteMonitoredEndpoint(endpointId);
    }

}
