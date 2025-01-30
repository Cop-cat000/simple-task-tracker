package ruslan.authorization.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "client_id", unique = true)
    private String clientId;

    private String secret;
    private String scope;

    @Column(name = "auth_method")
    private String authMethod;

    @Column(name = "grant_type")
    private String grantType;

    @Column(name = "redirect_uri")
    private String redirectUri;
}
