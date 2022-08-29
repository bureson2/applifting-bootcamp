package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoredEndpointRepository;
import bootcamp.soloproject.interfaces.MonitoringResultRepository;
import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoredEndpointService {

    @Autowired
    private MonitoredEndpointRepository monitoredEndpointDao;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private MonitoringResultRepository monitoringResultDao;

    public List<MonitoredEndpoint> getMonitoredEndpoints(){
        return monitoredEndpointDao.findAll();
    }

    public List<MonitoredEndpoint> getUsersMonitoredEndpoints(Long userId){
        Optional<User> user = userDao.findById(userId);
        List<MonitoredEndpoint> toReturn = null;
        if(user.isPresent()){
            toReturn = monitoredEndpointDao.findByOwner(user.get());
        }
        return toReturn;
    }

    public Optional<MonitoredEndpoint> addMonitoredEndpoint(MonitoredEndpoint monitoredEndpoint, Long userId){
        if(userId != null){
            monitoredEndpoint.setOwner(userDao.findById(userId).get());
        }
        monitoredEndpoint.setDateOfCreation(LocalDateTime.now());
        monitoredEndpointDao.save(monitoredEndpoint);
        return monitoredEndpointDao.findById(monitoredEndpoint.getId());
    }

    public Optional<MonitoredEndpoint> changeOwner(Long endpointId ,Long userId){
        Optional<User> newOwner = userDao.findById(userId);
        Optional<MonitoredEndpoint> endpoint = monitoredEndpointDao.findById(endpointId);
        if(newOwner.isPresent() && endpoint.isPresent()){
            endpoint.get().setOwner(newOwner.get());
            monitoredEndpointDao.save(endpoint.get());
        }
        return endpoint;
    }

    public void deleteMonitoredEndpoint(Long endpointId){
        monitoredEndpointDao.deleteById(endpointId);
    }

    @Scheduled(fixedDelay = 5000)
    public void monitorEndpoints() throws IOException {
        List<MonitoredEndpoint> monitoredEndpoints = monitoredEndpointDao.findAll();
        for(MonitoredEndpoint endpoint : monitoredEndpoints){
            MonitoringResult monitoringResult = new MonitoringResult();
            monitoringResultDao.save(monitoringResult);

            /* Control connection */
            URL url = new URL(endpoint.getUri());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            /* Saving response data and closing connection */
            monitoringResult.setReturnedPayload(content.toString());
            in.close();
            con.disconnect();

            monitoringResult.setReturnedHttpStatusCode(con.getResponseCode());
            monitoringResult.setMonitoredEndpoint(monitoredEndpointDao.findById(endpoint.getId()).get());
            monitoringResult.setDateOfCheck(LocalDateTime.now());
            endpoint.setDateOfLastCheck(LocalDateTime.now());
            monitoringResultDao.save(monitoringResult);
            monitoredEndpointDao.save(endpoint);
        }
    }

    //    TODO kontrola existence zaznamu - predchazeni 500
}
