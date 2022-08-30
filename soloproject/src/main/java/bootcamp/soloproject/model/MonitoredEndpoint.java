package bootcamp.soloproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "monitored_endpoints")
@Getter
@Setter
@NoArgsConstructor
public class MonitoredEndpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "uri", nullable = false)
    private String uri;

    @Column(name = "date_of_creation", nullable = false)
    private LocalDateTime dateOfCreation;

    @Column(name = "date_of_last_check")
    private LocalDateTime dateOfLastCheck;

    /* current implementation is limited from 1 to 59 seconds */
    @Column(name = "monitored_interval", nullable = false)
    private Integer monitoredInterval;

    @JoinColumn(name = "owner_id")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User owner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitoredEndpoint endpoint = (MonitoredEndpoint) o;
        return Objects.equals(id, endpoint.id) && Objects.equals(name, endpoint.name) && Objects.equals(uri, endpoint.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, uri);
    }
}
