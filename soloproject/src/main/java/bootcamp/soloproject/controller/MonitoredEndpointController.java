package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.security.AuthorizedControlService;
import bootcamp.soloproject.service.MonitoredEndpointService;
import bootcamp.soloproject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MonitoredEndpointController {

    @Autowired
    private MonitoredEndpointService monitoredEndpointService;

    @Autowired
    private AuthorizedControlService controlService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/endpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoredEndpoint> getMonitoredEndpoints() {
        if (controlService.hasAcces()) {
            return monitoredEndpointService.getMonitoredEndpoints();
        }
        return new ArrayList<>();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/endpoints/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoredEndpoint> getUsersMonitoredEndpoints(@PathVariable Long userId) {
        User user = userServiceImpl.getUser(userId).get(); // TODO
        if (controlService.hasAcces(user.getUsername())) {
            return monitoredEndpointService.getUsersMonitoredEndpoints(userId);
        }
        return new ArrayList<>();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/endpoint/new/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MonitoredEndpoint> addMonitoredEndpoint(@RequestBody MonitoredEndpoint newEndpoint, @PathVariable Long userId) {
        User user = userServiceImpl.getUser(userId).get(); // TODO
        if (controlService.hasAcces(user.getUsername())) {
            return monitoredEndpointService.addMonitoredEndpoint(newEndpoint, userId);
        }
        return Optional.empty(); // TODO
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/endpoint/{endpointId}/user/{userId}")
    public Optional<MonitoredEndpoint> changeOwner(@PathVariable Long endpointId, @PathVariable Long userId) {
        if (controlService.hasAcces("admin")) {
            return monitoredEndpointService.changeOwner(endpointId, userId);
        }
        return Optional.empty(); // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/endpoint/{endpointId}")
    public void deleteEndpoint(@PathVariable Long endpointId) {
        User user = monitoredEndpointService.getMonitoredEndpoint(endpointId).get().getOwner(); // TODO
        if (controlService.hasAcces(user.getUsername())) {
            monitoredEndpointService.deleteMonitoredEndpoint(endpointId);
        } // TODO acces denied
    }
}
