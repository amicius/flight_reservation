package flight_reservation;

import java.util.Date;
import java.util.List;

public class Main {
	
	public static boolean ui = true;

	public static void main(String[] args) {

		FlightDAO flightDAO = new FlightDAO();
		BookingDAO bookingDAO = new BookingDAO();

		Flight flight1 = new Flight("0001", PlaneType.A380, 853, "Brest-Guipavas", "Paris Charles-de-Gaulle",
				new Date());
		Flight flight2 = new Flight("0002", PlaneType.A340, 200, "Brest-Guipavas", "Paris Charles-de-Gaulle",
				new Date());
		Flight flight3 = new Flight("0003", PlaneType.B747, 80,"Nantes-Montoir","Nice cote-d'azur",new Date());
		Booking book1 = new Booking("ASIGARD", "Aria", 20, flight1);
		Booking book4 = new Booking("ASIGARD", "Aria", 20, flight3);
		Booking book5 = new Booking("ASIGARD", "Aria", 20, flight3);
		Booking book2 = new Booking("ASIGARD", "Freya", 20, flight1);
		Booking book3 = new Booking("RHAL","Darken",40,flight1);

		flightDAO.create(flight1);
		flightDAO.create(flight2);
		flightDAO.create(flight3);
		bookingDAO.create(book1);
		bookingDAO.create(book2);
		bookingDAO.create(book3);
		bookingDAO.create(book4);
		bookingDAO.create(book5);

		book1.setBookingNum();
		book2.setBookingNum();
		book3.setBookingNum();
		book4.setBookingNum();
		book5.setBookingNum();

		bookingDAO.updtade(book1);
		bookingDAO.updtade(book2);
		bookingDAO.updtade(book3);
		bookingDAO.updtade(book4);
		bookingDAO.updtade(book5);

		List<Flight> flights = flightDAO.flightList();
		System.out.println("liste des vols\nNuméro\t|\tType  | Place | Départ | Arrivé | Date");
		for (Flight flight : flights) {
			System.out.println(flight.toString());
		}

		List<Booking> books = bookingDAO.bookedFlight(flight1.getFlightNumb());
		System.out.println(
				"liste des passagers ayant reservé le vol 1\nReservation\t| Nom\t\t| prenom\t| age\t| vol");
		for (Booking book : books) {
			System.out.println(book.toString());
		}

		flights = flightDAO.flightSearch(flight2.getFlightNumb());
		System.out.println("liste des vols\nNuméro\t|\tType  | Place | Départ | Arrivé | Date");
		for (Flight flight : flights) {
			System.out.println(flight.toString());
		}
		
		flights = flightDAO.flightSearch(flight1.getTakeOff(), flight1.getLanding());
		System.out.println("liste des vols\nNuméro\t|\tType  | Place | Départ | Arrivé | Date");
		for (Flight flight : flights) {
			System.out.println(flight.toString());
		}
		
		books = bookingDAO.bookedBy("ASIGARD");
		System.out.println(
				"liste des passagers reserve par : 1\nReservation\t| Nom\t\t| prenom\t| age\t| vol");
		for (Booking book : books) {
			System.out.println(book.toString());
		}

	}

}
