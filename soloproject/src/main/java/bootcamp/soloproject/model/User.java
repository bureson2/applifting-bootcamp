package bootcamp.soloproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "system_users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = true)
    private String name;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "acces_token", nullable = true)
    private UUID accesToken;

    //    TODO nullable = false

}
