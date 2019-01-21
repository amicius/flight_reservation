package flightreservation;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UI {

	private static final String ERROR = "Mauvaise saisie";
	private static boolean uiBool = true;
	private static final Logger LOG = LoggerFactory.getLogger(UI.class);

	private UI() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean getUi() {
		return uiBool;
	}

	public static void setUi(boolean ui) {
		UI.uiBool = ui;
	}

	public static void mainUI() {
		if (getUi() == true) {
			LOG.trace("1) Gestion des vols\n2)Gestion des réservations\n3)quitter\nEntrez votre choix :\n");
			Scanner sc = new Scanner(System.in);
			switch (Integer.valueOf(sc.nextLine())) {
			case 1:
				flightUi();
				break;
			case 2:
				bookingUI();
				break;
			case 3:
				uiBool = false;
				mainUI();
				break;
			default:
				LOG.error(ERROR);
				mainUI();
			}
		}
	}

	public static void flightUi() {
		LOG.trace(
				"Gestion des vols\n1) Création d'un vol\n2)Liste des vols\n3)Recherche vol par numéro\n4)Recherche avion par ville de départ et d'arrivé\n5)retour\n6)Quitter\nEntrez votre choix :\n");
		Scanner sc = new Scanner(System.in);
		switch (Integer.valueOf(sc.nextLine())) {
		case 1:
			FlightUI.createFlightUI();
			break;
		case 2:
			FlightUI.printFlightUI();
			break;
		case 3:
			FlightUI.searchFlightNumUI();
			break;
		case 4:
			FlightUI.searchFlightTownUI();
			break;
		case 5:
			mainUI();
			break;
		case 6:
			setUi(false);
			mainUI();
			break;
		default:
			LOG.error(ERROR);
			flightUi();
		}
	}

	public static void bookingUI() {
		LOG.trace(
				"Gestion des réservations\n1) Créer une réservation\n2) Voir les reservations d'un vol\n3) Annuler une réservation\n4) Voir toute les réservation d'une personne\n5) Retour\n6)Quitter\nEntrez votre choix :\n");
		Scanner sc = new Scanner(System.in);
		switch (Integer.valueOf(sc.nextLine())) {
		case 1:
			BookingUI.createBookingUI();
			break;
		case 2:
			BookingUI.bookingFlightUI();
			break;
		case 3:
			BookingUI.cancelBookingUI();
			break;
		case 4:
			BookingUI.bookingCustomerUI();
			break;
		case 5:
			mainUI();
			break;
		case 6:
			setUi(false);
			mainUI();
			break;
		default:
			LOG.error(ERROR);
			bookingUI();
		}

	}

}
