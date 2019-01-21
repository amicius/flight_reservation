package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import flightreservation.Booking;
import flightreservation.DatabaseHelper;
import flightreservation.Flight;


public class BookingDAO implements DAO<Booking>{

	
	public void delete(Booking booking) {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);

		Booking find = db.find(Booking.class, booking.getId());
		if (find != null) {
			db.remove(find);
		}
		DatabaseHelper.commitTxAndClose(db);
	}
	
	public Booking bookingSearch(String bookingNumb) {
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);
		TypedQuery<Booking> query = db.createQuery("select b from Booking b where b.bookingNum=: bn", Booking.class);
		query.setParameter("bn", bookingNumb);
		Booking book;
		try {
			book = query.getSingleResult();
			return book;
		} catch (NoResultException e) {
			book = null;
			return book;
		}
		
	}
	
	public List<Booking> bookedFlight(String flightnum){
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);

		TypedQuery<Booking> query = db.createQuery("select b from Booking b inner join b.flight f where f.flightNumb=:id",
				Booking.class);
		query.setParameter("id", flightnum);
		List<Booking> books = query.getResultList();
		DatabaseHelper.commitTxAndClose(db);
		return books;
	}
	
	public List<Booking> bookedBy(String lastname){
		EntityManager db = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(db);

		TypedQuery<Booking> query = db.createQuery("select b from Booking b inner join b.flight where b.lastname=:nom",
				Booking.class);
		query.setParameter("nom", lastname);
		List<Booking> books = query.getResultList();
		DatabaseHelper.commitTxAndClose(db);
		return books;
		
	}

}
