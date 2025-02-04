package ruslan.authorization.model;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import ruslan.common.persistence.entities.Client;

import java.time.Duration;

public class SecurityClient {

    private RegisteredClient registeredClient;
    private Client client;

    public SecurityClient(RegisteredClient registeredClient) {
        this.registeredClient = registeredClient;
    }

    public SecurityClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        Client newClient = new Client();

        newClient.setClientId(registeredClient.getClientId());
        newClient.setSecret(registeredClient.getClientSecret());
        newClient.setScope(registeredClient.getScopes().stream().findAny().get().toString());
        newClient.setAuthMethod(registeredClient.getClientAuthenticationMethods().stream().findAny().get().toString());
        newClient.setGrantType(registeredClient.getAuthorizationGrantTypes().stream().findAny().get().toString());
        newClient.setRedirectUri(registeredClient.getRedirectUris().stream().findAny().get());

        return newClient;
    }

    public RegisteredClient getRegisteredClient() {
        return RegisteredClient.withId(String.valueOf(client.getId()))
                .clientId(client.getClientId())
                .clientSecret(client.getSecret())
                .scope(client.getScope())
                .clientAuthenticationMethod(new ClientAuthenticationMethod(client.getAuthMethod()))
                .authorizationGrantType(new AuthorizationGrantType(client.getGrantType()))
                .redirectUri(client.getRedirectUri())
                .tokenSettings(TokenSettings.builder().accessTokenTimeToLive(Duration.ofHours(24)).build()) // DEVELOPMENT ONLY
                .build();
    }
}
