package verwaltungMitarbeiter;

public class Hilfskraft extends Person {

	protected double FACTOR = 4.28;
	protected double TIMERATE = 10.5;
	protected int hours;

	public Hilfskraft(String surName, String firstName, String street,
			String city, int zip, int day, int month, int year, int hours) {
		super(surName, firstName, street, city, zip, day, month, year);
		this.hours = hours;
	}

	public boolean haveToPayTaxes() {
		return false;
	}
	
	public double getNetto() {
		return TIMERATE * hours * FACTOR;
	}
	
	public String toString() {
		String s= super.toString();
		s += String.format("\t%10b" + "\t"+ "\t%6.2f" , this.haveToPayTaxes(), this.getNetto());
		return s;
	}

}