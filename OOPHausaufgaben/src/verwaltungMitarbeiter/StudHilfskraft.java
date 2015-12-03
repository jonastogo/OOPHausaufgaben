package verwaltungMitarbeiter;

public class StudHilfskraft extends Hilfskraft implements IStudierende{

	protected double TIMERATE = 8.5;
	
	public StudHilfskraft(String surName, String firstName, String street,
			String city, int zip, int day, int month, int year, int hours) {
		super(surName, firstName, street, city, zip, day, month, year, hours);
	}
	
	public double getNetto() {
		return TIMERATE * hours * FACTOR;
	}
}
