package flightreservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author formation
 *
 */
public class DatabaseHelper {

	private static EntityManagerFactory entityManagerFactory;

	private DatabaseHelper() {
		throw new IllegalStateException("Utility class"); 
	}
	
	/**
	 * @return
	 */
	public static EntityManager createEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("unit");
		}
		return entityManagerFactory.createEntityManager();
	}

	/**
	 * @param entityManager
	 */
	public static void commitTxAndClose(EntityManager entityManager) {
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void rollbackTxAndClose(EntityManager entityManager) {
		entityManager.getTransaction().rollback();
		entityManager.close();
	}

	/**
	 * @param entityManager
	 */
	public static void beginTx(EntityManager entityManager) {
		entityManager.getTransaction().begin();
	}
}
