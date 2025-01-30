package ruslan.authorization.persistence.repositories;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;

//@Repository
public class JpaUserRepository /*implements UserRepository*/ {
//
//    private final EntityManagerFactory entityManagerFactory;
//
//    public JpaUserRepository(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }
//
//    @Override
//    public Optional<User> getUser(String id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        User user = null;
//
//        try {
//            EntityTransaction transaction = entityManager.getTransaction();
//            transaction.begin();
//
//            user = entityManager.find(User.class, id);
//
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            entityManager.close();;
//        }
//
//        return Optional.ofNullable(user);
//    }
}
