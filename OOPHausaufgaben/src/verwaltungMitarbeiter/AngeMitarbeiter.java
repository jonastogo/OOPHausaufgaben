package verwaltungMitarbeiter;

public class AngeMitarbeiter extends Angestellte implements IMitarbeiter{//ADDED

	public AngeMitarbeiter(String surName, String firstName, String street,
			String city, int zip, int day, int month, int year, double salary, boolean hasKids) {
		super(surName, firstName, street, city, zip, day, month, year, salary, hasKids);
		// TODO Auto-generated constructor stub
	}

}
