package bootcamp.soloproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MonitoringResult {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_of_check", nullable = true)
    private LocalDateTime dateOfCheck;

    @Column(name = "returned_http_status_code", nullable = true)
    private Integer returnedHttpStatusCode;

    @Column(name = "returned_payload", nullable = true)
    private String returnedPayload;

    @JoinColumn(name = "monitored_endpointId", nullable = false)
    @ManyToOne
    private MonitoringResult monitoredEndpointId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfCheck() {
        return dateOfCheck;
    }

    public void setDateOfCheck(LocalDateTime dateOfCheck) {
        this.dateOfCheck = dateOfCheck;
    }

    public Integer getReturnedHttpStatusCode() {
        return returnedHttpStatusCode;
    }

    public void setReturnedHttpStatusCode(Integer returnedHttpStatusCode) {
        this.returnedHttpStatusCode = returnedHttpStatusCode;
    }

    public String getReturnedPayload() {
        return returnedPayload;
    }

    public void setReturnedPayload(String returnedPayload) {
        this.returnedPayload = returnedPayload;
    }

    public MonitoringResult getMonitoredEndpointId() {
        return monitoredEndpointId;
    }

    public void setMonitoredEndpointId(MonitoringResult monitoredEndpointId) {
        this.monitoredEndpointId = monitoredEndpointId;
    }
}
