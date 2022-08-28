package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.MonitoringResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MonitoringResultController {

    @Autowired
    private MonitoringResultService monitoringResultService;

    @GetMapping(value = "/results", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringResult> getMonitoringResults() {
        return monitoringResultService.getMonitoringResults();
    }

    @PostMapping(value = "/result/new/{endpointId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MonitoringResult> saveMonitoringResult(@RequestBody MonitoringResult newResult, @PathVariable Long endpointId){
        return monitoringResultService.saveMonitoringResult(newResult, endpointId);
    }

    @DeleteMapping(value = "/result/{resultId}")
    public void deleteMonitoringResult(@PathVariable Long resultId){
        monitoringResultService.deleteMonitoringResult(resultId);
    }
}
