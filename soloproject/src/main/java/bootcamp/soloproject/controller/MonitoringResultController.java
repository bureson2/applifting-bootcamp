package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.security.AuthorizedControlService;
import bootcamp.soloproject.service.MonitoredEndpointService;
import bootcamp.soloproject.service.MonitoringResultService;
import bootcamp.soloproject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MonitoringResultController {

    @Autowired
    private MonitoringResultService monitoringResultService;

    @Autowired
    private AuthorizedControlService controlService;

    @Autowired
    private MonitoredEndpointService endpointService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/results", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringResult> getMonitoringResults() {
        if (controlService.hasAcces()) {
            return monitoringResultService.getMonitoringResults();
        }
        return new ArrayList<>(); // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/results/endpoint/{endpointId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringResult> getEndpointResults(@PathVariable Long endpointId) {
        User user = endpointService.getMonitoredEndpoint(endpointId).get().getOwner(); // TODO
        if (controlService.hasAcces(user.getUsername())) {
            return monitoringResultService.getEndpointResults(endpointId);
        }
        return new ArrayList<>(); // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/results/endpoint/{endpointId}/last")
    public List<MonitoringResult> getLastEndpointResults(@PathVariable Long endpointId) {
        User user = endpointService.getMonitoredEndpoint(endpointId).get().getOwner(); // TODO
        if (controlService.hasAcces(user.getUsername())) {
            return monitoringResultService.getEndpointLastResults(endpointId);
        }
        return new ArrayList<>(); // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/user/{userId}/results")
    public List<MonitoringResult> getUserEndpointsResults(@PathVariable Long userId) {
        User user = userServiceImpl.getUser(userId).get(); // TODO
        if (controlService.hasAcces(user.getUsername())) {
            return monitoringResultService.getUserResults(userId);
        }
        return new ArrayList<>(); // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/result/new/{endpointId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MonitoringResult> saveMonitoringResult(@RequestBody MonitoringResult newResult, @PathVariable Long endpointId) {
        User user = endpointService.getMonitoredEndpoint(endpointId).get().getOwner(); // TODO
        if (controlService.hasAcces(user.getUsername())) {
            return monitoringResultService.saveMonitoringResult(newResult, endpointId);
        }
        return Optional.empty(); // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/result/{resultId}")
    public void deleteMonitoringResult(@PathVariable Long resultId) {
        if (controlService.hasAcces()) {
            monitoringResultService.deleteMonitoringResult(resultId);
        } // TODO acces denied
    }
}
