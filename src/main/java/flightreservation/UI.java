package flightreservation;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class UI {

	private static final String ERROR = "Mauvaise saisie";
	private static boolean uiBool = true;
	private static final  Logger LOG = LoggerFactory.getLogger(UI.class);
	
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
		LOG.trace("1) Gestion des vols\n2)Gestion des r�servations\n3)quitter\nEntrez votre choix :\n");
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
			break;
		default:
			LOG.error(ERROR);
			mainUI();
		}
	}

	public static void flightUi() {
		LOG.trace(
				"Gestion des vols\n1) Cr�ation d'un vol\n2)Liste des vols\n3)Recherche vol par num�ro\n4)Recherche avion par ville de d�part et d'arriv�\n5)retour\nEntrez votre choix :\n");
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
		default:
			LOG.error(ERROR);
			flightUi();
		}
	}

	public static void bookingUI() {
		LOG.trace(
				"Gestion des r�servations\n1) Cr�er une r�servation\n2) Voir les reservations d'un vol\n3) Annuler une r�servation\n4) Voir toute les r�servation d'une personne\n5) Retour\nEntrez votre choix :\n)");
		Scanner sc = new Scanner(System.in);
		switch (Integer.valueOf(sc.nextLine())) {
		case 1:
			BookingUI.createBookingUI();
			break;
		case 2:
			BookingUI.bookingFlightUI();
			break;
		case 4:
			BookingUI.cancelBookingUI();
			break;
		case 5:
			BookingUI.bookingCustomerUI();
			break;
		case 6:
			mainUI();
			break;
		default:
			LOG.error(ERROR);
			bookingUI();
		}

	}

}
