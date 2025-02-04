package ruslan.authorization.persistence.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Repository;
import ruslan.authorization.model.SecurityClient;
import ruslan.common.persistence.entities.Client;
import ruslan.common.persistence.repositories.ClientRepository;

@Repository
@RequiredArgsConstructor
public class RegisteredJpaClientRepository implements RegisteredClientRepository {

    private final ClientRepository clientRepository;

    @Override
    public void save(RegisteredClient registeredClient) {
        SecurityClient securityClient = new SecurityClient(registeredClient);
        Client client = securityClient.getClient();
        clientRepository.save(client);
    }

    @Override
    public RegisteredClient findById(String id) {
        long numericId = Long.getLong(id);
        Client client = clientRepository.findById(numericId)
                .orElseThrow(RuntimeException::new);
        return new SecurityClient(client).getRegisteredClient();
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = clientRepository.findByClientId(clientId)
                .orElseThrow(RuntimeException::new);
        return new SecurityClient(client).getRegisteredClient();
    }
}
