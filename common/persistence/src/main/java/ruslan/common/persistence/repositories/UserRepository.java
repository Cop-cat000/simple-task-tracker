package ruslan.common.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ruslan.common.persistence.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username IN :usernames")
    List<User> findAllByUsername(List<String> usernames);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email IN :emails")
    List<User> findAllByEmail(List<String> emails);
}
