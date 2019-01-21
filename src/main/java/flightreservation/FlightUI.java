package flightreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.FlightDAO;

public class FlightUI {

	private static final FlightDAO flightDAO = new FlightDAO();
	private static final Logger LOG = LoggerFactory.getLogger(BookingUI.class);
	private static final String ENTER = "\nAppuyer sur Entrer pour continuer";

	private FlightUI() {

		throw new IllegalStateException("Utility class");
	}

	public static void createFlightUI() {
		Scanner sc = new Scanner(System.in);
		LOG.trace("Création d'un nouveau vol\nVeuillez saisir les informations suivantes :");
		Flight flight = new Flight();
		LOG.trace("Numéro de vol :");
		flight.setFlightNumb(sc.nextLine());
		LOG.trace("Type d'avion :");
		flight.setPlaneType(PlaneType.valueOf(sc.nextLine()));
		LOG.trace("Nombre de place :");
		flight.setCapacity(sc.nextInt());
		LOG.trace("Ville de départ :");
		flight.setTakeOff(sc.nextLine());
		LOG.trace("Ville d'arrivé :");
		flight.setLanding(sc.nextLine());
		LOG.trace("Date de départ (dd/mm/yyyy) :");
		try {
			flight.setTakeOffDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
		} catch (ParseException e) {
			LOG.error("Erreur sur la date saisie, date du jour mise par defaut");
			flight.setTakeOffDate(new Date());
		}
	}

	public static void printFlightUI() {
		Scanner sc = new Scanner(System.in);
		List<Flight> flights = flightDAO.flightList();
		LOG.trace("liste des vols\nNuméro\t|Type\t|Place\t|Départ\t|Arrivé\t|Date");
		if (LOG.isTraceEnabled()) {
			for (Flight flight : flights) {
				LOG.trace("{}", flight.toString());

			}
		}
		LOG.trace(ENTER);
		sc.nextLine();
		UI.flightUi();
	}

	public static void searchFlightNumUI() {
		Scanner sc = new Scanner(System.in);
		LOG.trace("Veuillez saisir le numéro du vol :");
		Flight flight = flightDAO.flightSearch(sc.nextLine());
		LOG.trace("Votre vol :\nNuméro\t|Type\t|Place\t|Départ\t|Arrivé\t|Date");
		if (LOG.isTraceEnabled()) {
			LOG.trace(flight.toString());
		}
		LOG.trace(ENTER);
		sc.nextLine();
		UI.flightUi();

	}

	public static void searchFlightTownUI() {
		Scanner sc = new Scanner(System.in);
		LOG.trace("Veuillez saisir la ville de départ :");
		String takeOff = sc.nextLine();
		LOG.trace("Veuillez saisir la ville d'arrivé");
		String landing = sc.nextLine();
		List<Flight> flights = flightDAO.flightSearch(takeOff, landing);
		LOG.trace("liste des vols\nNuméro\t|Type\t|Place\t|Départ\t|Arrivé\t|Date");
		if (LOG.isTraceEnabled()) {
			for (Flight flight : flights) {
				LOG.trace("{}", flight.toString());
			}
		}
		LOG.trace(ENTER);
		sc.nextLine();
		UI.flightUi();

	}
}
