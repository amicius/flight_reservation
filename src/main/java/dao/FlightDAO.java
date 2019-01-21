package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import flightreservation.DatabaseHelper;
import flightreservation.Flight;

public class FlightDAO implements DAO<Flight> {

	public void delete(Flight flight) {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);

		Flight find = db.find(Flight.class, flight.getId());
		if (find != null) {
			db.remove(find);
		}
		DatabaseHelper.commitTxAndClose(db);

	}

	public List<Flight> flightList() {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);
		TypedQuery<Flight> query = db.createQuery("select f from Flight f", Flight.class);

		return query.getResultList();

	}

	public Flight flightSearch(String flightNumb) {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);
		TypedQuery<Flight> query = db.createQuery("select f from Flight f where f.flightNumb=: fn", Flight.class);
		query.setParameter("fn", flightNumb);
		Flight flight;
		try {
			flight = query.getSingleResult();
			return flight;
		} catch (NoResultException e) {
			flight = null;
			return flight;
		}

	}

	public List<Flight> flightSearch(String takeOff, String landing) {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);
		TypedQuery<Flight> query = db.createQuery("select f from Flight f where f.takeOff =:to and f.landing =: land",
				Flight.class);
		query.setParameter("to", takeOff);
		query.setParameter("land", landing);

		return query.getResultList();

	}

}
