package ruslan.simple_task_tracker_authorization_server.persistence.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import ruslan.simple_task_tracker_authorization_server.persistence.entities.User;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {

    private final EntityManagerFactory entityManagerFactory;

    public JpaUserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Optional<User> getUser(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = null;

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            user = entityManager.find(User.class, id);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();;
        }

        return Optional.ofNullable(user);
    }
}
