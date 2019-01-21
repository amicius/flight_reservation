package flightreservation;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.BookingDAO;
import dao.FlightDAO;

public class BookingUI {

	private static final FlightDAO flightDAO = new FlightDAO();
	private static final BookingDAO bookingDAO = new BookingDAO();
	private static final Logger LOG = LoggerFactory.getLogger(BookingUI.class);
	private static final String vol = "Veuillez saisir le numéro du vol :";

	private BookingUI() {
		throw new IllegalStateException("Utility class");
	}

	public static void createBookingUI() {
		Scanner sc = new Scanner(System.in);
		Flight flight;
		LOG.trace(vol);
		flight = flightDAO.flightSearch(sc.nextLine());
		if (flight != null) {
			Booking book = new Booking();
			book.setFlightId(flight);
			LOG.trace("Veuillez saisir les informations suivantes :");
			LOG.trace("Nom :");
			book.setLastname(sc.nextLine());
			LOG.trace("Prénom :");
			book.setFirstname(sc.nextLine());
			LOG.trace("Age :");
			book.setAge(sc.nextInt());
			UI.bookingUI();
			LOG.trace("Réservation crée");
			LOG.trace("\nAppuyer sur Entrer pour continuer");
			sc.nextLine();
			UI.bookingUI();
		} else {
			LOG.error("Vol inexistant");
			UI.bookingUI();
		}

	}

	public static void bookingFlightUI() {
		Scanner sc = new Scanner(System.in);
		Flight flight;
		LOG.trace(vol);
		flight = flightDAO.flightSearch(sc.nextLine());
		if (flight != null) {
			List<Booking> books = bookingDAO.bookedFlight(flight.getFlightNumb());
			LOG.trace("liste des passagers ayant reservé le vol 1\nReservation\t| Nom\t\t| prenom\t| age\t| vol");
			if (LOG.isTraceEnabled()) {
				for (Booking book : books) {
					LOG.trace("{}", book.toString());
				}
			}
			LOG.trace("\nAppuyer sur Entrer pour continuer");
			sc.nextLine();
			UI.bookingUI();
		} else {
			LOG.error("Vol inexistant");
			UI.bookingUI();
		}
	}

	public static void cancelBookingUI() {
		Scanner sc = new Scanner(System.in);
		Booking book;
		LOG.trace("Veuillez saisir le numéro de la reservation :");
		book = bookingDAO.bookingSearch(sc.nextLine());
		if (book != null) {
			bookingDAO.delete(book);
			LOG.trace("Réservation supprimé");
			LOG.trace("\nAppuyer sur Entrer pour continuer");
			sc.nextLine();
			UI.bookingUI();
		} else {
			LOG.error("Vol inexistant");
			UI.bookingUI();
		}
	}

	public static void bookingCustomerUI() {
		Scanner sc = new Scanner(System.in);
		LOG.trace("Veuillez saisir le nom de la personne :");
		List<Booking> books = bookingDAO.bookedBy(sc.nextLine());
		LOG.trace("liste des passagers reserve par : 1\nReservation\t| Nom\t\t| prenom\t| age\t| vol");
		if (LOG.isTraceEnabled()) {
			for (Booking book : books) {
				LOG.trace("{}", book.toString());
			}
		}
		LOG.trace("\nAppuyer sur Entrer pour continuer");
		sc.nextLine();
		UI.bookingUI();
		
	}

}
