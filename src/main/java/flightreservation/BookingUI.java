package flightreservation;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.FlightDAO;

public class BookingUI {

	private static final Logger LOG = LoggerFactory.getLogger(BookingUI.class);

	private BookingUI() {
		throw new IllegalStateException("Utility class");
	}

	public static void createBookingUI() {
		Scanner sc = new Scanner(System.in);

		FlightDAO flightDAO = new FlightDAO();
		Flight flight;
		LOG.trace("Veuillez saisir le num�ro du vol :");
		flight = flightDAO.flightSearch(sc.nextLine());
		if (flight != null) {
			Booking book = new Booking();
			book.setFlightId(flight);
			LOG.trace("Veuillez saisir les informations suivantes :");
			LOG.trace("Nom :");
			book.setLastname(sc.nextLine());
			LOG.trace("Pr�nom :");
			book.setFirstname(sc.nextLine());
			LOG.trace("Age :");
			book.setAge(sc.nextInt());
			UI.bookingUI();
		}else {
			LOG.error("Vol inexistant");
			UI.bookingUI();
		}

	}

	public static void bookingFlightUI() {}

	public static void cancelBookingUI() {}

	public static void bookingCustomerUI() {}

}
