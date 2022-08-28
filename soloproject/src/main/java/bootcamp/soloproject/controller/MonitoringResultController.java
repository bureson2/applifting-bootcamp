package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.MonitoringResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonitoringResultController {

    @Autowired
    private MonitoringResultService monitoringResultService;

    @GetMapping(value = "/results", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringResult> getMonitoringResults() {
        return monitoringResultService.getMonitoringResults();
    }
}
