package bootcamp.soloproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoring_results")
@Getter
@Setter
@NoArgsConstructor
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

    @JoinColumn(name = "monitored_endpointId", nullable = true)
    @ManyToOne
    private MonitoringResult monitoredEndpointId;

//    TODO nullable = false

}
