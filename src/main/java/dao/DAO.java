package dao;

import javax.persistence.EntityManager;

import flightreservation.DatabaseHelper;


public interface DAO<T> {

	
	public default void create(T obj) {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);
		db.persist(obj);
		DatabaseHelper.commitTxAndClose(db);
	}
	
	
	public default void updtade(T obj) {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);
		db.merge(obj);
		DatabaseHelper.commitTxAndClose(db);
	}
	public abstract void delete(T obj);
}
