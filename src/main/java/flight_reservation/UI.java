package flight_reservation;

import java.util.Scanner;

public class UI {
	
	public static void mainUI(){
		System.out.println("1) Gestion des vols\n2)Gestion des r�servations\n3)quitter\nEntrez votre choix :\n");
		Scanner sc = new Scanner(System.in);
		switch (Integer.valueOf(sc.nextLine())) {
		case 1:
			flightUi();
			break;
		case 2:
			bookingUI();
			break;
		case 3:
			Main.ui = false;
			break;
		}
	}
	public static void flightUi() {
		System.out.println("Gestion des vols\n1) Cr�ation d'un vol\n2)Liste des vols\n3)Recherche vol par num�ro\n4)Recherche avion par ville de d�part et d'arriv�\n5)retour\nEntrez votre choix :\n");
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
		}
	}
	
	public static void bookingUI(){
		System.out.println("Gestion des r�servations\n1) Cr�er une r�servation\n2) Voir les reservations d'un vol\n3) Annuler une r�servation\n4) Voir toute les r�servation d'une personne\n5) Retour\nEntrez votre choix :\n)");
		Scanner sc = new Scanner(System.in);
		switch (Integer.valueOf(sc.nextLine())) {
		case 1:
//			BookingUI.
			break;
		case 2:
			break;
		case 3:
			Main.ui = false;
			break;
		}
		
	}
}
