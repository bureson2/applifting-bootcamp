package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.MonitoringResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MonitoringResultController {

    @Autowired
    private MonitoringResultService monitoringResultService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/results", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringResult> getMonitoringResults() {
        return monitoringResultService.getMonitoringResults();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/results/endpoint/{endpointId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringResult> getEndpointResults(@PathVariable Long endpointId){

        return monitoringResultService.getEndpointResults(endpointId);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/results/endpoint/{endpointId}/last")
    public List<MonitoringResult> getLastEndpointResults(@PathVariable Long endpointId){
        return monitoringResultService.getEndpointLastResults(endpointId);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/user/{userId}/results")
    public List<MonitoringResult> getUserEndpointsResults(@PathVariable Long userId){
        return monitoringResultService.getUserResults(userId);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/result/new/{endpointId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MonitoringResult> saveMonitoringResult(@RequestBody MonitoringResult newResult, @PathVariable Long endpointId){
        return monitoringResultService.saveMonitoringResult(newResult, endpointId);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/result/{resultId}")
    public void deleteMonitoringResult(@PathVariable Long resultId){
        monitoringResultService.deleteMonitoringResult(resultId);
    }
}
