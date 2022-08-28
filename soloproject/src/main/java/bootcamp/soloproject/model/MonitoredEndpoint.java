package bootcamp.soloproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitored_endpoints")
@Getter
@Setter
@NoArgsConstructor
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

    //    TODO nullable = false



}
