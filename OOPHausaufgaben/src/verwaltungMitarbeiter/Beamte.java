package verwaltungMitarbeiter;

public class Beamte extends Person {

	private double salary;
	
	public Beamte(String surName, String firstName, String street, String city,
			int zip, int day, int month, int year, double salary) {
		super(surName, firstName, street, city, zip, day, month, year);
		this.salary = salary;
	}
	

	public boolean haveToPayTaxes() {
		return getNetto() * 12 > SocialInsurance.TAXEXEMPTION;
	}
	
	public double getNetto() {
		return this.salary;
	}

	public String toString() {
		String s= super.toString();
		s += String.format("\t%10b" + "\t"+ "\t%6.2f" , this.haveToPayTaxes(), this.getNetto());
		return s;
	}


}
