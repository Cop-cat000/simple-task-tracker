package ruslan.authorization.persistence.repositories;

import ruslan.authorization.persistence.entities.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String id);
}
