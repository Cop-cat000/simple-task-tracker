package ruslan.common.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ruslan.common.persistence.entities.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("""
            SELECT c FROM Client c WHERE c.clientId = :clientId
            """)
    Optional<Client> findByClientId(String clientId);
}
