package ruslan.authorization.persistence.repositories;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.TypedQuery;


//@Repository
public class JpaClientRepository /*implements RegisteredClientRepository*/ {
//
//    private final EntityManagerFactory entityManagerFactory;
//
//    public JpaClientRepository(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }
//
//    @Override
//    public void save(RegisteredClient registeredClient) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        try {
//            EntityTransaction transaction = entityManager.getTransaction();
//            transaction.begin();
//
//            SecurityClient securityClient = new SecurityClient(registeredClient);
//            Client client = securityClient.getClient();
//            entityManager.persist(client);
//
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            entityManager.close();
//        }
//    }
//
//    @Override
//    public RegisteredClient findById(String id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Optional<Client> client = Optional.ofNullable(entityManager.find(Client.class, Integer.valueOf(id)));
//        SecurityClient securityClient = new SecurityClient(client.orElseThrow(() -> new AuthenticationCredentialsNotFoundException("No client with such Id")));
//        return securityClient.getRegisteredClient();
//    }
//
//    @Override
//    public RegisteredClient findByClientId(String clientId) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        String jpql = "SELECT c FROM Client c WHERE c.clientId = :clientId";
//        TypedQuery<Client> clientTypedQuery = entityManager.createQuery(jpql, Client.class);
//        clientTypedQuery.setParameter("clientId", clientId);
//        Optional<Client> client = Optional.ofNullable(clientTypedQuery.getSingleResult());
//        SecurityClient securityClient = new SecurityClient(client.orElseThrow(() -> new AuthenticationCredentialsNotFoundException("No client with such clientId")));
//        return securityClient.getRegisteredClient();
//    }
}
