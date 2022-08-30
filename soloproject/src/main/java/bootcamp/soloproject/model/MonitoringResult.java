package bootcamp.soloproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "monitoring_results")
@Getter
@Setter
@NoArgsConstructor
public class MonitoringResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_of_check")
    private LocalDateTime dateOfCheck;

    @Column(name = "returned_http_status_code")
    private Integer returnedHttpStatusCode;

    @Column(name = "returned_payload")
    private String returnedPayload;

    @JoinColumn(name = "monitored_endpoint_id")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private MonitoredEndpoint monitoredEndpoint;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitoringResult that = (MonitoringResult) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
