package ruslan.simple_task_tracker_authorization_server.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
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

    public int getId() { return id;}

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getSecret() { return secret; }
    public void setSecret(String secret) { this.secret = secret; }

    public String getScope() { return scope; }
    public void setScope(String scope) { this.scope = scope; }

    public String getAuthMethod() { return authMethod; }
    public void setAuthMethod(String authMethod) { this.authMethod = authMethod; }

    public String getGrantType() { return grantType; }
    public void setGrantType(String grantType) { this.grantType = grantType; }

    public String getRedirectUri() { return redirectUri; }
    public void setRedirectUri(String redirectUri) { this.redirectUri = redirectUri; }
}
