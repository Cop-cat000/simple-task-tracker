package ruslan.common.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id", unique = true, nullable = false)
    private String clientId;

    @Column(nullable = false)
    private String secret;

    @Column(nullable = false)
    private String scope;

    @Column(name = "auth_method", nullable = false)
    private String authMethod;

    @Column(name = "grant_type", nullable = false)
    private String grantType;

    @Column(name = "redirect_uri", nullable = false)
    private String redirectUri;

    @ManyToMany(mappedBy = "clients")
    private List<User> users;
}
