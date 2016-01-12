package Mannschaft;

public class MainClass {
	public static void main(String[] args) {
		Liste l = new Liste();
		System.out.println("Ursprungsliste:");
		l.printListe();
		l.sortName();
		System.out.println();
		System.out.println("Sortiert nach Name:");
		l.printListe();
		l.sortSpitz();
		System.out.println();
		System.out.println("Sortiert nach Spitzname:");
		l.printListe();
		l.sortTele();
		System.out.println();
		System.out.println("Sortiert nach Telefonnummer:");
		l.printListe();
		l.sortBirthday();
		System.out.println();
		System.out.println("Sortiert nach Geburtstag:");
		l.printListe();
	}
}
