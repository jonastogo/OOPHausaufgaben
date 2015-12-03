package verwaltungMitarbeiter;

public class VerbeamMitarbeiter extends Beamte implements   IMitarbeiter{//ADDED

	public VerbeamMitarbeiter(String surName, String firstName, String street,
			String city, int zip, int day, int month, int year, double salary) {
		super(surName, firstName, street, city, zip, day, month, year, salary);
		// TODO Auto-generated constructor stub
	}
	public String teaches(){
		String Lehrveranstaltung = null;
		return Lehrveranstaltung;
	}

}
