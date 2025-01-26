package ruslan.simple_task_tracker_authorization_server.persistence.repositories;

import ruslan.simple_task_tracker_authorization_server.persistence.entities.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String id);
}
