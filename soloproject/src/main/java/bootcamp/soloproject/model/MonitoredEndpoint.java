package bootcamp.soloproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MonitoredEndpoint {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "uri", nullable = true)
    private String uri;

    @Column(name = "date_of_creation", nullable = true)
    private LocalDateTime dateOfCreation;

    @Column(name = "date_of_last_check", nullable = true)
    private LocalDateTime dateOfLastCheck;

    @Column(name = "monitored_interval", nullable = true)
    private Integer monitoredInterval;

    @JoinColumn(name = "owner", nullable = true)
    @ManyToOne
    private User owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfLastCheck() {
        return dateOfLastCheck;
    }

    public void setDateOfLastCheck(LocalDateTime dateOfLastCheck) {
        this.dateOfLastCheck = dateOfLastCheck;
    }

    public Integer getMonitoredInterval() {
        return monitoredInterval;
    }

    public void setMonitoredInterval(Integer monitoredInterval) {
        this.monitoredInterval = monitoredInterval;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
